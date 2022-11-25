package com.maveric.balanceservice.exception;

import com.maveric.balanceservice.dto.ErrorDto;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ExceptionControllerAdvisorTest {
    private ExceptionControllerAdvisor controllerAdvisor = new ExceptionControllerAdvisor();
    @Test
    void handleBalanceNotFoundException() {
        BalanceNotFoundException exception = new BalanceNotFoundException("User Not found");
        ErrorDto error = controllerAdvisor.handleBalanceNotFoundException(exception);
        assertEquals("404",error.getCode());
    }

    @Test
    void invalidException() {
        InvalidException exception = new InvalidException("User Not found");
        ErrorDto error = controllerAdvisor.invalidException(exception);
        assertEquals("404",error.getCode());
      }

}