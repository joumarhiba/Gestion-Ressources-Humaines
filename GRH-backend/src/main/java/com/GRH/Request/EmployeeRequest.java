package com.GRH.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class EmployeeRequest {
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private Double salaire;
    private String departement;
}
