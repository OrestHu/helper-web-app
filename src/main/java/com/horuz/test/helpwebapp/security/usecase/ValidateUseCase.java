package com.horuz.test.helpwebapp.security.usecase;

public interface ValidateUseCase {
    boolean checkValidToken(String jwt);
    boolean checkReceiver(String jwt);
    boolean checkHelper(String jwt);
}
