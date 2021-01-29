package com.zrv.sprbootsrv.controller.converter;

import com.zrv.sprbootsrv.api.RegisterRequest;
import com.zrv.sprbootsrv.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
@RequiredArgsConstructor
public class RegisterConverter {

    private final ModelMapper modelMapper;

    public RegisterDto toRegisterDto(RegisterRequest request) {

        TypeMap<RegisterRequest, RegisterDto> mapper = modelMapper
                .typeMap(RegisterRequest.class, RegisterDto.class);

        return mapper.map(request);
    }

}

