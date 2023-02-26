package com.GRH.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Application {
    @Id
    private Long id;
    private String status;
    private String title;
    private String cv;
    private String profile;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Offre offre;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Candidat candidat;
}
