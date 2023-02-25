package com.GRH.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class FormationRequest {
    @NotNull
    private String topic;
    @NotNull
    private String description;
    @NotNull
    private String duration;
    private int nbStudent;
}
