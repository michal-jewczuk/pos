package net.jewczuk.posrest.controller;

import net.jewczuk.posrest.dto.ErrorDto;
import net.jewczuk.posrest.exception.BadRequestException;
import net.jewczuk.posrest.exception.ExceptionMessages;
import net.jewczuk.posrest.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDto> handleDefaultException(Exception ex, WebRequest request) {
        ErrorDto response = new ErrorDto(ExceptionMessages.UNIDENTIFIED_SERVER_ERROR.toString());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDto response = new ErrorDto(ExceptionMessages.RESOURCE_NOT_FOUND.toString());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ErrorDto> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ErrorDto response = new ErrorDto(ExceptionMessages.INVALID_REQUEST_PARAMETERS.toString());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
