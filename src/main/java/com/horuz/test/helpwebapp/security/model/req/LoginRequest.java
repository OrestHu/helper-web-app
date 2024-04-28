package com.horuz.test.helpwebapp.security.model.req;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = " must be not blank.")
        String email,
        @NotBlank(message = " must be not blank.")
        String password
) {
}
