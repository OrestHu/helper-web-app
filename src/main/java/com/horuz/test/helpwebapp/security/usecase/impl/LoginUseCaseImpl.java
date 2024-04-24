package com.horuz.test.helpwebapp.security.usecase.impl;

import com.horuz.test.helpwebapp.security.exception.BadDataException;
import com.horuz.test.helpwebapp.security.model.AccessToken;
import com.horuz.test.helpwebapp.security.model.req.LoginRequest;
import com.horuz.test.helpwebapp.security.service.impl.UsersServiceImpl;
import com.horuz.test.helpwebapp.security.usecase.LoginUseCase;
import com.horuz.test.helpwebapp.security.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final AuthenticationManager authenticationManager;
    private final UsersServiceImpl userAccountService;
    private final JwtTokenUtils jwtTokenUtils;
    private final static String BAD_CREDENTIALS = "Not found user %s";
    @Override
    public AccessToken authAcc(LoginRequest request) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username().toLowerCase(Locale.ROOT), request.password()));
        }catch (BadCredentialsException e){
            throw new BadDataException(
                    String.format(BAD_CREDENTIALS, request.username()), HttpStatus.NOT_FOUND
            );
        }
        UserDetails userDetails = userAccountService.loadUserByUsername(request.username().toLowerCase(Locale.ROOT));
        String token = jwtTokenUtils.generateJwtToken(userDetails);
        return new AccessToken(token);
    }
}
