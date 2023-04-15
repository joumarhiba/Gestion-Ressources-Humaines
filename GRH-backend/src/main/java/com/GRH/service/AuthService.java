package com.GRH.service;


import com.GRH.Request.AuthenticationRequest;
import com.GRH.Request.RegisterRequest;
import com.GRH.Request.TokenRequest;
import com.GRH.model.Recruteur;
import com.GRH.model.UserRole;
import com.GRH.repository.RecruteurRepository;
import com.GRH.security.JwtHandler;
import com.GRH.util.AuthenticationResponse;
import com.GRH.util.HttpResponse;
import com.GRH.util.IntrospectResponse;
import com.GRH.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j

public class AuthService {
    // private final EmployeeRepo employeeRepo;
    private final RecruteurRepository recruteurRepository;
    private final JwtHandler jwtHandler;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final RestTemplate restTemplate;
    @Value("${spring.security.oauth2.client.provider.keycloak.issuer-uri}")
    private String issueUrl;
    @Value("${spring.security.oauth2.client.registration.oauth2-client-credentials.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.oauth2-client-credentials.authorization-grant-type}")
    private String grantType;
//    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
//        var admin = (Admin) Admin.builder().username(request.getUsername())
//                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
//                .role(UserRole.ADMIN).build();
//
//        adminRepo.save(admin);
//        var jwtToken = jwtHandler.generateToken(admin);
//        return AuthenticationResponse.builder().token(jwtToken).build();
        Recruteur recruteur = new Recruteur();
        recruteur.setUsername(request.getUsername());
        recruteur.setEmail(request.getEmail());
        recruteur.setPassword(passwordEncoder.encode(request.getPassword()));
        recruteur.setRole(UserRole.RECRUTEUR);

        recruteurRepository.save(recruteur);
        String jwtToken = jwtHandler.generateToken(recruteur);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setAccess_token(jwtToken);
        return AuthenticationResponse.builder().access_token(jwtToken).build();
    }


    public String getAuth(String client_id, String app_secret) {
        String auth = client_id + ":" + app_secret;
        return Base64.getEncoder().encodeToString(auth.getBytes());
    }

    public String generateAccessToken() {
        String auth = this.getAuth(clientId, "app_id");
        return auth;
    }

    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Basic " + generateAccessToken());
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id",clientId);
        map.add("grant_type",grantType);
        map.add("username", request.getEmail());
        map.add("password", request.getPassword());

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);
         ResponseEntity<AuthenticationResponse> response = restTemplate.postForEntity("http://localhost:8080/auth/realms/easyRH/protocol/openid-connect/token",
                httpEntity, AuthenticationResponse.class);
        System.out.println("\n---------------------------\n"+response+"\n------------");
         return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }


    public ResponseEntity<Response> logout(TokenRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Basic " + generateAccessToken());
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id",clientId);
        map.add("refresh_token", request.getToken());

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);
        ResponseEntity<Response> response = restTemplate.postForEntity("http://localhost:8080/auth/realms/easyRH/protocol/openid-connect/logout",
                httpEntity, Response.class);
        System.out.println("\n---------------------------\n"+response+"\n------------");
        Response httpResponse = new Response();
        if(response.getStatusCode().is2xxSuccessful()){
            httpResponse.setMessage("logout");
        }
        return new ResponseEntity<>(httpResponse, HttpStatus.OK);
    }

    public ResponseEntity<IntrospectResponse> introspect(TokenRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id",clientId);
      //  map.add("client_secret","1fu9sZE56ydjzGmovEHjIDgrdYDcT5gd-gqgXwhvmS0");
        map.add("token", request.getToken());

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);
        ResponseEntity<IntrospectResponse> response = restTemplate.postForEntity("http://localhost:8080/auth/realms/easyRH/protocol/openid-connect/token/introspect", httpEntity, IntrospectResponse.class);

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
