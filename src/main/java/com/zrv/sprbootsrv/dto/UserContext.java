package com.zrv.sprbootsrv.dto;

import com.zrv.sprbootsrv.domain.user.Role;
import com.zrv.sprbootsrv.domain.user.RoleName;
import com.zrv.sprbootsrv.domain.user.User;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserContext {

    private String token;

    private User user;

    private Set<Role> roles;

    private HttpServletRequest request;

    private HttpServletResponse response;

    public Set<RoleName> getRoleNames() {
        return getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
