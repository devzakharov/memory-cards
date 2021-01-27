package com.zrv.sprbootsrv.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends RuntimeException {

    private final HttpStatus httpStatus;

    private AppException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public static AppException appException(ErrorType errorType, Object... args) {
        return new AppException(String.format(errorType.getMessage(), args), errorType.getHttpStatus());
    }

    public static AppException appException(ErrorType errorType) {
        return new AppException(errorType.getMessage(), errorType.getHttpStatus());
    }

}