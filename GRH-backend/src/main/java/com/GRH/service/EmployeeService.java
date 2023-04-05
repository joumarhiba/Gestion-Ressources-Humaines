package com.GRH.service;


import com.GRH.Request.RegisterRequest;
import com.GRH.dto.EmployeeDto;

import com.GRH.exception.NoItemsFoundException;
import com.GRH.model.Employee;
import com.GRH.model.UserRole;
import com.GRH.repository.EmployeeRepo;
import com.GRH.util.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepo employeeRepo;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponse register(RegisterRequest request) {
       Employee employee = new Employee();
//        employee.setUsername(request.getUsername());
//        employee.setEmail(request.getEmail());
//        employee.setPassword(passwordEncoder.encode(request.getPassword()));
        employee.setRole(UserRole.EMPLOYEE);
        employeeRepo.save(employee);
        return AuthenticationResponse.builder().access_token(employee.toString()).build();

    }

    public AuthenticationResponse getAllEmployees() throws NoItemsFoundException {
        List<Employee> employees = employeeRepo.findAll();
        if(employees.isEmpty()){
            throw new NoItemsFoundException("No employees Record was stored in DB...");
        }
        return AuthenticationResponse.builder()
                .access_token(employees.toString())
                .build();
    }
}
