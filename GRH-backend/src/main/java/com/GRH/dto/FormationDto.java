package com.GRH.dto;

public record FormationDto(String id, String topic, String description, String duration, int nbStudent) {
    public FormationDto(String topic, String description, String duration, int nbStudent){
        this(null,topic, description, duration,nbStudent);
    }
}
