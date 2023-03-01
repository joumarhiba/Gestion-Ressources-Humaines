package com.GRH.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String description;
    private String contrat;
    private Date datePublication;
    @Enumerated
    private OffreStatus status;

    @ManyToOne
    private Recruteur recruteur;

    @OneToMany(mappedBy = "offre")
    private List<Application> applications;
}
