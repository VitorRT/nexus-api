package br.com.ninus.rest.api.config;

import br.com.ninus.rest.api.exception.RestException;
import br.com.ninus.rest.api.exception.RestNotFoundException;
import br.com.ninus.rest.api.exception.RestValidationException;
import br.com.ninus.rest.api.exception.dto.ValidationException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionRender {

    /* Execption de Validação */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestException> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(new RestException(e.getBody().getStatus(), e.getMessage()));
    }

    /* Execption de Violação de Integridade dos Dados (Uniques) */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<RestException> DataIntegrityViolationExceptionHandler(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body(new RestException(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    /* Execption de Violação de Constraint (Not Null, etc) */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RestValidationException> ConstraintViolationExceptionHandler(ConstraintViolationException e) {

        List<ValidationException> errors = new ArrayList<>();

        e.getConstraintViolations().forEach((v) -> {
            errors.add(new ValidationException(v.getPropertyPath().toString(), v.getMessage()));
        });

        RestValidationException exception = new RestValidationException(HttpStatus.BAD_REQUEST.value(), errors);

        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(RestNotFoundException.class)
    public ResponseEntity<RestException> RestNotFoundExceptionHandler(RestNotFoundException e) {
        return ResponseEntity.badRequest().body(new RestException(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }
}
