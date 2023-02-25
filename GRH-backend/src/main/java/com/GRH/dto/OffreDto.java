package com.GRH.dto;

import java.time.LocalDateTime;

public record OffreDto(String id, String title, String description, String contrat, LocalDateTime datePublication, String status) {
    public OffreDto( String title, String description, String contrat, LocalDateTime datePublication, String status){
        this(null,title, description, contrat, datePublication, status);
    }
}
