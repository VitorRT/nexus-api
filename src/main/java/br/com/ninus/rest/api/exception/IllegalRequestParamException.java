package br.com.ninus.rest.api.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class IllegalRequestParamException extends IllegalArgumentException {
    private String message;
    private Integer status;

    public IllegalRequestParamException(String message) {
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST.value();
    }
}
