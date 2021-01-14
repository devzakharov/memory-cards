package com.zrv.sprbootsrv.domain;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {

    @NotNull
    private Integer id;

    @NotNull
    private String nickname;

    @NotNull
    private String login;

    @NotNull
    private String avatar;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private JsonNode settings;
}
