package com.GRH.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Formation {

    @Id
    private String id;
    private String topic;
    private String description;
    private String duration;
    private int nbStudent;
    private List<String> employeeIds;

}
