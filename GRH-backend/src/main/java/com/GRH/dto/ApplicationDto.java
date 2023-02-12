package com.GRH.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApplicationDto {
    private String id;
    private String status;
    private String title;
    private String cv;
    private String profile;
}
