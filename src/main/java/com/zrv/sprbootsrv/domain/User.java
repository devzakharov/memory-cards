package com.zrv.sprbootsrv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @NotNull
    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @NotNull
    @Column(name = "avatar_id", unique = true)
    private UUID avatar_id;

    @NotNull(message = "The password can't be empty")
    @Size(min = 6, max = 12, message = "The password must between 6 and 12 characters long")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "The email can't be empty")
    @Email(message = "Email must be in the format address@domain.com")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
