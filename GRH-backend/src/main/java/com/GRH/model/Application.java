package com.GRH.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Application {
    @Id
    private String id;
    private String status;
    private String title;
    private String cv;
    private String profile;
}
