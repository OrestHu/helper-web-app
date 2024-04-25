package com.horuz.test.helpwebapp.security.usecase;

public interface ValidateUseCase {
    boolean checkReceiver(String jwt);
    boolean checkHelper(String jwt);
}
