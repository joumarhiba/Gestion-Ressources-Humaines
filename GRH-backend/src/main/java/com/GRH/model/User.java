package com.GRH.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public abstract class User  {

    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
