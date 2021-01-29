package com.zrv.sprbootsrv.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @Email
    @JsonProperty(value = "email", required = true)
    private String email;

    @Size(max = 128)
    @JsonProperty(value = "nickname", required = true)
    private String nickname;

    @Size(max = 128)
    @JsonProperty(value = "password", required = true)
    private String password;
}
