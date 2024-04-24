package com.horuz.test.helpwebapp.security.model.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @Size(max = 100, message = "Full Name must have at most {max} characters")
        @NotBlank(message = "Password must be not blank")
        String fullName,
        @NotBlank(message = "Email must be not blank")
        @Email(message = "Please enter a valid email address.")
        String username,
        @Size(min = 8, message = "Password must have at least {min} characters")
        @Size(max = 32, message = "Password must have at most {max} characters")
        @NotBlank(message = "Password must be not blank")
        String password,
        @NotBlank(message = "Password must be not blank")
        String role
) {
}
