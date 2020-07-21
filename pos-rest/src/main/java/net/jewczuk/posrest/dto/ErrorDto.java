package net.jewczuk.posrest.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorDto {

    String error;
    LocalDateTime timestamp;

    public ErrorDto() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorDto(String error) {
        this();
        this.error = error;
    }

}
