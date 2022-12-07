package com.maveric.balanceservice.exception;

import com.maveric.balanceservice.dto.ErrorDto;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.maveric.balanceservice.constants.Constants.*;


@RestControllerAdvice

public class ExceptionControllerAdvisor {

//    private static final String BALANCE_NOT_FOUND_CODE = "Balance not Found for Id";
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ExceptionControllerAdvisor.class);
    String exceptionString="";
    public static final ErrorDto handleBalanceNotFoundException(BalanceNotFoundException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BALANCE_NOT_FOUND_CODE);
        errorDto.setMessage(exception.getMessage());
        return errorDto;
    }
    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static final ErrorDto invalidException(InvalidException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BALANCE_NOT_FOUND_CODE);
        errorDto.setMessage(exception.getMessage());
        return errorDto;
    }
    @ExceptionHandler(BalanceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorDto handleBalanceAlreadyExistException(BalanceAlreadyExistException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BAD_REQUEST_CODE);
        errorDto.setMessage(exception.getMessage());
        exceptionString = exception.getMessage();
        log.error("{}->{}",BAD_REQUEST_CODE,exceptionString);
        return errorDto;
    }

}
