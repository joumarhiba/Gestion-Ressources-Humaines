package com.GRH.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document

public class Candidat extends User {

    private List<Application> applicationIds;
}