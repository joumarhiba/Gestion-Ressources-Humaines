package com.GRH.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document

public class Admin extends User{

    private List<Formation> formationIds;
    private List<Recruteur> recruteurIds;

}
