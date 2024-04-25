package com.horuz.test.helpwebapp.security.api.service;

import com.horuz.test.helpwebapp.security.api.model.CurrUser;
import com.horuz.test.helpwebapp.security.model.Users;

import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrUser> currentUserAccount();
    Optional<Users> currentUserAccountUsername(Long id);
    boolean hasRoleReceiver(String token);
    boolean hasRoleHelper(String token);
}
