package com.GRH.dto;

import com.GRH.model.UserRole;

public record RecruteurDto(String id, String username, String email, String password, UserRole role) {
    public RecruteurDto(String username, String email, String password, UserRole role){

        this(null, username, email, password, role);
    }
}
