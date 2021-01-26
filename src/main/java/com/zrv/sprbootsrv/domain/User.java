package com.zrv.sprbootsrv.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    private UUID id;

    @NotNull
    private String nickname;

    @NotNull(message = "The login can't be empty")
    @Size(min = 3, max = 10, message = "The login must be between 3 and 20 characters long")
    private String login;

    @NotNull
    private String avatar;

    @NotNull(message = "The password can't be empty")
    @Size(min = 6, max = 12, message = "The password must between 6 and 12 characters long")
    private String password;

    @NotNull(message = "The email can't be empty")
    @Email(message = "Email must be in the format address@domain.com")
    private String email;

    @NotNull
    private String settings;
}
