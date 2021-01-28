package com.zrv.sprbootsrv.service;

import com.zrv.sprbootsrv.domain.user.User;
import com.zrv.sprbootsrv.dto.RegisterDto;
import com.zrv.sprbootsrv.dto.UserContext;
import com.zrv.sprbootsrv.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.zrv.sprbootsrv.exception.AppException.appException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserContext userContext;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    @SneakyThrows
    @Transactional
    public void register(RegisterDto register) {
        String email = register.getEmail();
        existsByEmail(email);

        UUID userId = UUID.randomUUID();
        User user = User.builder()
                .id(userId)
                .email(register.getEmail())
                .nickname(register.getNickname())
                .password(passwordEncoder.encode(register.getPassword()))
                .status(INACTIVE)
                .createDate(getDateTime())
                .build();

        save(user);
        emailService.sendRegisterConfirm(user);
    }

    @Transactional
    public void registerConfirm(String token) {
        User user = getByToken(token);

        if (user.getStatus() != INACTIVE) {
            throw appException(ErrorType.USER_ALREADY_CONFIRMED, user.getId());
        }
        user.setStatus(UserStatus.ACTIVE);
        save(user);
    }

    @Transactional(readOnly = true)
    public UserContext getRequestContext() {
        return userContext;
    }

    @Transactional(readOnly = true)
    public Optional<User> findByAllEmails(String email) {
        return userRepository.findByAllEmails(email);
    }

    @Transactional(readOnly = true)
    public void existsByEmail(String email) {
        if (userRepository.findByAllEmails(email).isPresent()) {
            throw appException(ALREADY_EXIST_USER_BY_EMAIL, email);
        }
    }
}
