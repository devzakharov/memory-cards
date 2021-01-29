package com.zrv.sprbootsrv.domain.user;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleName {
    USER,
    MODERATOR,
    ADMIN;

    public static final String USER_ROLE = "hasRole('USER')";
    public static final String MODERATOR_ROLE = "hasRole('MODERATOR')";
    public static final String ADMIN_ROLE = "hasRole('ADMIN')";
}