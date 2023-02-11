package com.GRH.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class User {
    @Id
    private String id;
    private String email;
    private String username;
    private String password;
}
