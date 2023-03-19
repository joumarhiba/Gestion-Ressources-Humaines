package com.GRH.security;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtHandler jwtHandler;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String userRole;
        final String userEmail;
        final String token;
        final boolean isTokenValid;

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        //extract jwt, username and userrole
        token = authHeader.substring(7);
        userEmail = jwtHandler.extractUsername(token);
        userRole = jwtHandler.extractRole(token);

        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            if(jwtHandler.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

//            if("AGENT".equals(userRole) ){
//                System.out.println( "inside jwt filter Agent");
//                userDetails = agentService.loadUserByEmail(userEmail);
//            } else if("CLIENT".equals(userRole)){
//                System.out.println( "inside jwt filter Client");
//                userDetails = clientService.loadUserByEmail(userEmail);
//            }

//            if(userDetails != null){
//                isTokenValid = jwtHandler.validateToken(token, userDetails);
//                if(isTokenValid) {
//                    UsernamePasswordAuthenticationToken authenticationToken =
//                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                }
//            }

        }
        filterChain.doFilter(request,response);
    }
}
