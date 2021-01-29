package com.zrv.sprbootsrv.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorType {

    USER_NOT_FOUND(NOT_FOUND, "User not found by ID: id=%s"),
    USER_WITH_EMAIL_ALREADY_EXIST(BAD_REQUEST, "User with email %s already exist"),
    USER_WITH_LOGIN_ALREADY_EXIST(BAD_REQUEST, "User with login %s already exist"),
    WRONG_JWT_TOKEN(FORBIDDEN, "Wrong JWT token"),
    USER_ALREADY_CONFIRMED(CONFLICT, "User already confirmed: userId=%s"),
    ALREADY_EXIST_USER_BY_EMAIL(CONFLICT, "User already exist by email: email=%s"),
    NOT_FOUND_USER_BY_EMAIL_TOKEN(NOT_FOUND, "User not found by email token");

    private final HttpStatus httpStatus;
    private final String message;

}