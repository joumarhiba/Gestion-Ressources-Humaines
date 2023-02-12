package com.GRH.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandidatDto {
    private String id;
    private String email;
    private String username;
    private String password;
}
