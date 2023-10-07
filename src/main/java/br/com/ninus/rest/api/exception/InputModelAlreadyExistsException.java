package br.com.ninus.rest.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InputModelAlreadyExistsException extends RuntimeException{
    private Integer status;
    private String message;

    public InputModelAlreadyExistsException(String message) {
        super(message);
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST.value();
    }
}
