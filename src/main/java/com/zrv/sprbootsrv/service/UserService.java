package com.zrv.sprbootsrv.service;

import com.zrv.sprbootsrv.domain.user.User;
import com.zrv.sprbootsrv.dto.UserContext;
import com.zrv.sprbootsrv.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserContext userContext;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserContext getRequestContext() {
        return userContext;
    }

    @Transactional(readOnly = true)
    public Optional<User> findByAllEmails(String email) {
        return userRepository.findByAllEmails(email);
    }
}
