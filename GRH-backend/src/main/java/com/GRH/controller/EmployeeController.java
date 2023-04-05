package com.GRH.controller;

import com.GRH.Request.RegisterRequest;
import com.GRH.dto.EmployeeDto;
import com.GRH.dto.FormationDto;
import com.GRH.model.Employee;
import com.GRH.model.UserRole;
import com.GRH.repository.EmployeeRepo;
import com.GRH.service.EmployeeService;
import com.GRH.util.AuthenticationResponse;
import com.GRH.util.HttpResponse;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")

public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;
    private final EmployeeRepo employeeRepo;

    @PostMapping
    @RolesAllowed("admin")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeRepo.save(employee));
    }
//    public ResponseEntity<AuthenticationResponse> saveEmployee(@RequestBody RegisterRequest request) {
//        return ResponseEntity.ok(employeeService.register(request));
//    }

    @GetMapping
    @RolesAllowed({"employee", "admin"})
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(employeeRepo.findAll());
    }
//    public ResponseEntity<AuthenticationResponse> getEmployees() {
//        return ResponseEntity.ok(employeeService.getAllEmployees());
//    }
}
