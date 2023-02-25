package com.GRH.dto;

public record EmployeeDto(String id,String username, String email, String password, Double salaire, String departement) {
    public EmployeeDto(String username, String email, String password, Double salaire, String departement){
        this(null,username, email, password, salaire, departement);
    }
}
