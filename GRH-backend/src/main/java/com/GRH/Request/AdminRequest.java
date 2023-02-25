package com.GRH.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdminRequest {
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
