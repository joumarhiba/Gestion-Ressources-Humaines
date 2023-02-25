package com.GRH.dto;

public record ApplicationDto(String id,String status, String title, String profile, String cv) {
    public ApplicationDto(String status, String title, String profile, String cv){
        this(null,status, title, profile, cv);
    }
}
