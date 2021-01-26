package com.zrv.sprbootsrv.controller.filter;

import com.zrv.sprbootsrv.exception.AppException;
import com.zrv.sprbootsrv.exception.ErrorType;
import com.zrv.sprbootsrv.service.TokenService;
import com.zrv.sprbootsrv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TokenFilter extends GenericFilterBean {

    private final TokenService tokenService;
    private final UserService userService;

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String token = ((HttpServletRequest) servletRequest).getHeader("X-Auth-User-Token");
        try {
            if (token != null && tokenService.validateToken(token)) {
                Authentication authentication = getAuthentication(token);

                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            userService.getRequestContext().setRequest((HttpServletRequest) servletRequest);
            userService.getRequestContext().setResponse((HttpServletResponse) servletResponse);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (AppException e) {
            SecurityContextHolder.clearContext();
            ((HttpServletResponse) servletResponse).sendError(e.getHttpStatus().value());
        }

    }

    private Authentication getAuthentication(String token) {
        String email = tokenService.getEmail(token);
        User user = userService.findByAllEmails(email)
                .orElseThrow(() -> AppException.of(ErrorType.WRONG_JWT_TOKEN));

        authRepository.findByUserIdAndToken(user.getId(), token)
                .orElseThrow(() -> AppException.of(ErrorType.WRONG_JWT_TOKEN));

        Set<Role> roles = roleRepository.findByUserId(user.getId());

        boolean isNotBlocked = user.getStatus() != UserStatus.BLOCKED;

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword() == null ? "socials" : user.getPassword(),
                isNotBlocked, isNotBlocked, isNotBlocked, isNotBlocked,
                roles.stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().name()))
                        .collect(toList())
        );
        UserContext context = userService.getRequestContext();
        context.setRoles(roles);
        context.setToken(token);
        context.setUser(user);

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}
