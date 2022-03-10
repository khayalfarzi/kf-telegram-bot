package az.company.kftelegrambot.controller;

import az.company.kftelegrambot.model.ExceptionResponse;
import az.company.kftelegrambot.model.exception.MqException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleInternalServerError(Exception ex) {
        log.error("Exception ", ex);
        return new ExceptionResponse("UNEXPECTED_EXCEPTION", ex.getMessage());
    }

    @ExceptionHandler(MqException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handleMqException(MqException ex) {
        log.error("MqException ", ex);
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }
}