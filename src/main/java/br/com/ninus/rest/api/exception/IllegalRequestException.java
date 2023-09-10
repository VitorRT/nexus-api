package br.com.ninus.rest.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class IllegalRequestException extends IllegalArgumentException {
    private String message;
    private Integer status;

    public IllegalRequestException(String message) {
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
