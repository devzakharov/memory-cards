package com.zrv.sprbootsrv.dto;

import com.zrv.sprbootsrv.domain.user.RoleName;
import com.zrv.sprbootsrv.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {

    private String token;

    private User user;

    private Set<RoleName> roles;
}
