package com.horuz.test.helpwebapp.security.model.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Email must be not blank")
        @Email(message = "Please enter a valid email address.")
        String username,
        @NotBlank(message = "Password must be not blank")
        @NotBlank String password
) {
}
