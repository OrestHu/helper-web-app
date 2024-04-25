package com.horuz.test.helpwebapp.post.model.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostRequest(
        @Size(min = 5, message = " must have at least {min} characters")
        @Size(max = 50, message = " must have at most {max} characters")
        @NotBlank(message = "Name must be not blank")
        String name,
        @NotBlank(message = " must be not blank")
        String description,
        @Size(min = 1, message = " must have at least {min} characters")
        @Size(max = 50, message = " must have at most {max} characters")
        @NotBlank(message = " must be not blank")
        String city,
        String img
) {
}
