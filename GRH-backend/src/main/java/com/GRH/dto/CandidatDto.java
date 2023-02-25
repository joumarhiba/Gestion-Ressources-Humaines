package com.GRH.dto;

public record CandidatDto(String id,String username, String email, String password ) {
    public CandidatDto(String username, String email, String password) {
            this(null, username, email, password);
    }
}
