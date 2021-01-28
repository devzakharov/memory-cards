package com.zrv.sprbootsrv.dto;

import com.zrv.sprbootsrv.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {

    private String token;

    private User user;
}
