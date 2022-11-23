package com.maveric.balanceservice.exception;

import com.maveric.balanceservice.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice

public class ExceptionControllerAdvisor {

    private static final String BALANCE_NOT_FOUND_CODE = "Balance not Found for Id";

    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static final ErrorDto invalidException(InvalidException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BALANCE_NOT_FOUND_CODE);
        errorDto.setMessage(exception.getMessage());
        return errorDto;
    }

}
