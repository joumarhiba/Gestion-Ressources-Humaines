package com.GRH.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee extends User {
    private Double salaire;
    private String departement;
    private String formationId;
}
