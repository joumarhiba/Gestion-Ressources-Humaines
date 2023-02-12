package com.GRH.model;

import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Offre {
    @Id
    private String id;
    private String title;
    private String description;
    private String contrat;
    private LocalDate date_publication;
    @Enumerated
    private String status;
    private String recruteurId;
    private List<Application> applicationIds;
}
