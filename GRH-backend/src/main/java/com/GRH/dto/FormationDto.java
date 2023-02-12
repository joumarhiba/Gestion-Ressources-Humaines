package com.GRH.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FormationDto {
    private String id;
    private String topic;
    private String description;
    private String duration;
    private int nb_student;
}
