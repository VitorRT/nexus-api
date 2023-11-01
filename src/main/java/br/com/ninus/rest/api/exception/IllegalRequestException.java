package br.com.ninus.rest.api.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class IllegalRequestException extends IllegalArgumentException {
    private String message;
    private Integer status;

    public IllegalRequestException(String message) {
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
