package ru.practicum.ewmservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ReadResponseBodyException extends RuntimeException {
    protected final String reason;
    protected final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public ReadResponseBodyException(String jsonBody) {
        super(String.format("This jsonBody can not be read: %s", jsonBody));
        this.reason = "This jsonBody can not be read.";
    }
}
