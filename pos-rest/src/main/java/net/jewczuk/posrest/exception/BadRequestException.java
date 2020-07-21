package net.jewczuk.posrest.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super(ExceptionMessages.INVALID_REQUEST_PARAMETERS.toString());
    }
}
