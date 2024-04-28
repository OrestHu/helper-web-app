package com.horuz.test.helpwebapp.security.model.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = " must be not blank.")
        @Email(message = "must be valid email address.")
        String username,
        @NotBlank(message = " must be not blank.")
        @NotBlank String password
) {
}
