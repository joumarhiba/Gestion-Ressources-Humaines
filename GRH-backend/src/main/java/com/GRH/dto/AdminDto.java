package com.GRH.dto;

public record AdminDto(String id,String username, String email, String password ) {
    public AdminDto(String username, String email, String password){
        this(null, username, email, password);
    }
}
