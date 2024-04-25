package com.horuz.test.helpwebapp.security.model.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @Size(max = 100, message = " must have at most {max} characters")
        @NotBlank(message = " must be not blank")
        String fullName,
        @NotBlank(message = " must be not blank")
        @Email(message = "Please enter a valid email address.")
        String username,
        @Size(min = 8, message = " must have at least {min} characters")
        @Size(max = 32, message = " must have at most {max} characters")
        @NotBlank(message = " must be not blank")
        String password,
        @NotBlank(message = " must be not blank")
        String role
) {
}
