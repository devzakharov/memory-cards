package com.zrv.sprbootsrv.service;

import com.zrv.sprbootsrv.domain.user.Auth;
import com.zrv.sprbootsrv.domain.user.Role;
import com.zrv.sprbootsrv.domain.user.User;
import com.zrv.sprbootsrv.dto.AuthResponseDto;
import com.zrv.sprbootsrv.dto.UserContext;
import com.zrv.sprbootsrv.repository.user.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.zrv.sprbootsrv.util.TimeUtils.getDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RoleService roleService;
    private final TokenService tokenService;
    private final AuthRepository authRepository;

    @Transactional
    public AuthResponseDto singin(String email, User user) {
        UUID userId = user.getId();

        Auth auth = authRepository.findByUserId(userId)
                .orElseGet(() -> authRepository.save(Auth.builder()
                        .id(UUID.randomUUID())
                        .userId(userId)
                        .token(tokenService.createToken(email))
                        .createDate(getDateTime())
                        .build()));

        Set<Role> roles = roleService.findByUserId(userId);

        return AuthResponseDto.builder()
                .token(auth.getToken())
                .user(user)
                .roles(roles.stream().map(Role::getName).collect(Collectors.toSet()))
                .build();
    }

    @Transactional
    public void logout(UUID userId, UserContext requestContext) {
        authRepository.deleteByUserId(userId);
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(requestContext.getRequest(), requestContext.getResponse(), null);
    }
}
