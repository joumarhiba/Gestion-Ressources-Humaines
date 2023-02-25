package com.GRH.Request;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OffreRequest {
    @NotNull
    private String title;
    @NotNull
    private String description;
    private String contrat;
    private LocalDateTime datePublication;
    @NotNull
    @Enumerated
    private String status;
}
