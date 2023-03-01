package com.GRH.dto;

import com.GRH.model.OffreStatus;

import java.time.LocalDateTime;
import java.util.Date;

public record OffreDto(Long id, String title, String description, String contrat, Date datePublication, OffreStatus status) {
    public OffreDto(String title, String description, String contrat, Date datePublication, OffreStatus status){
        this(null,title, description, contrat, datePublication, status);
    }
}
