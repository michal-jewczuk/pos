package net.jewczuk.posrest.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super(ExceptionMessages.RESOURCE_NOT_FOUND.toString());
    }
}
