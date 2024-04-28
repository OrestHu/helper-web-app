package com.horuz.test.helpwebapp.security.controller;

import com.horuz.test.helpwebapp.security.usecase.ValidateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/validate")
@RequiredArgsConstructor
public class ValidateController {
    private final ValidateUseCase validateUseCase;

    @GetMapping("/checkValidToken/{jwt}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean checkValidToken(@PathVariable("jwt") String jwt){
        return validateUseCase.checkValidToken(jwt);
    }

    @GetMapping("/checkReceiver/{jwt}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean checkReceiver(@PathVariable("jwt") String jwt){
        return validateUseCase.checkReceiver(jwt);
    }
    @GetMapping("/checkHelper/{jwt}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean checkHelper(@PathVariable("jwt") String jwt){
        return validateUseCase.checkHelper(jwt);
    }
}
