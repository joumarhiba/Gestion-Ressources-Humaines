package com.GRH.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {
    private String id;
    private String email;
    private String username;
    private String password;
    private Double salaire;
    private String departement;
}
