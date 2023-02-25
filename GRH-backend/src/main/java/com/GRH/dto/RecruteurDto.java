package com.GRH.dto;

public record RecruteurDto(String id,String username, String email, String password) {
    public RecruteurDto(String username, String email, String password){

        this(null, username, email, password);
    }
}
