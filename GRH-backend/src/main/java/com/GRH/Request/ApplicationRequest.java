package com.GRH.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ApplicationRequest {
    @NotNull
    private String title;
    @NotNull
    private String cv;
    @NotNull
    private String profile;
    @NotNull
    private String status;
}
