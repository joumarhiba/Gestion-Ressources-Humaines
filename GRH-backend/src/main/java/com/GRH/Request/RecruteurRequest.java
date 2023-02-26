package com.GRH.request;

import com.GRH.model.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RecruteurRequest {
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private UserRole role;
}
