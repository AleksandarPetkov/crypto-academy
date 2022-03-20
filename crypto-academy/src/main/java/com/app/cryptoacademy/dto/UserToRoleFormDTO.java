package com.app.cryptoacademy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserToRoleFormDTO {

    @Size(min = 2, max = 15, message = "Username must be between 3 AND 15 characters")
    @NotNull(message = "Username is compulsory")
    private String username;

    @NotNull(message = "role is compulsory")
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
