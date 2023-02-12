package com.GRH.dto;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreDto {
    private String id;
    private String title;
    private String description;
    private String contrat;
    private LocalDate date_publication;
    @Enumerated
    private String status;
}
