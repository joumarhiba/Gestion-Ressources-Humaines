package com.GRH.service;


import com.GRH.Request.AuthenticationRequest;
import com.GRH.Request.RegisterRequest;
import com.GRH.model.Employee;

import com.GRH.model.UserRole;

import com.GRH.repository.EmployeeRepo;
import com.GRH.security.JwtHandler;
import com.GRH.util.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class AuthService {
    private final EmployeeRepo employeeRepo;
    private final JwtHandler jwtHandler;
    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
//        var admin = (Admin) Admin.builder().username(request.getUsername())
//                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
//                .role(UserRole.ADMIN).build();
//
//        adminRepo.save(admin);
//        var jwtToken = jwtHandler.generateToken(admin);
//        return AuthenticationResponse.builder().token(jwtToken).build();
        Employee employee = new Employee();
        employee.setUsername(request.getUsername());
        employee.setEmail(request.getEmail());
        employee.setPassword(passwordEncoder.encode(request.getPassword()));
        employee.setRole(UserRole.EMPLOYEE);

        employeeRepo.save(employee);
        String jwtToken = jwtHandler.generateToken(employee);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        log.info("\n\nin the service\n\n");

//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            request.getEmail(),
//                            request.getPassword()
//                    )
//            );
        var user = employeeRepo.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtHandler.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
