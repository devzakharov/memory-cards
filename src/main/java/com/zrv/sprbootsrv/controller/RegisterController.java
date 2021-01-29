package com.zrv.sprbootsrv.controller;

import com.zrv.sprbootsrv.api.RegisterRequest;
import com.zrv.sprbootsrv.controller.converter.RegisterConverter;
import com.zrv.sprbootsrv.dto.RegisterDto;
import com.zrv.sprbootsrv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final RegisterConverter registerConverter;

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequest registerRequest) {
        RegisterDto registerDto = registerConverter.toRegisterDto(registerRequest);
        userService.register(registerDto);
    }
}
