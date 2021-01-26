package com.zrv.sprbootsrv.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public void handleException(HttpServletResponse httpServletResponse, Exception e) throws IOException {

        int code;
        String message;

        if (e instanceof AppException) {
            AppException appException = (AppException) e;
            code = appException.getHttpStatus().value();
            message = appException.getMessage();
        } else {
            code = 500;
            message = e.getMessage();
        }

        httpServletResponse.sendError(code, message);
    }
}