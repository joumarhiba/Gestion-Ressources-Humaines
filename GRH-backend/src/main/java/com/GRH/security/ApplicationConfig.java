package com.GRH.security;

import com.GRH.model.Admin;
import com.GRH.model.Employee;
import com.GRH.model.Recruteur;
import com.GRH.model.User;
import com.GRH.repository.AdminRepo;
import com.GRH.repository.EmployeeRepo;
import com.GRH.repository.RecruteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final AdminRepo adminRepository;

    private final RecruteurRepository recruteurRepository;
    private final EmployeeRepo employeeRepo;


//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            User user = userRepo.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//            if(user.getRole().name().equals("EMPLOYEE")) {
//                Employee employee = employeeRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Employee not found"));
//            }
//            return username;
//        };
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> adminRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            System.out.println("\nemail : "+email+"\n");
            Optional<Admin> admin = adminRepository.findByEmail(email);

            if (admin.isPresent()) {
                return new Admin();
            }


            Optional<Employee> employee = employeeRepo.findByEmail(email);

            if (employee.isPresent()) {
                return new Employee();
            }

            Optional<Recruteur> client = recruteurRepository.findByEmail(email);

            if (client.isPresent()) {
                return new Recruteur();
            }

            throw new UsernameNotFoundException("User not found");
//            return (UserDetails) new User();
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
