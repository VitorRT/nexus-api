package br.com.ninus.rest.api.config;

import br.com.ninus.rest.api.exception.*;
import br.com.ninus.rest.api.exception.dto.ValidationException;
import jakarta.persistence.EntityNotFoundException;
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
public class GlobalExceptionHandler {

    /* Execption de Validação */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestValidationException> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<ValidationException> errors = new ArrayList<>();

        e.getFieldErrors().forEach((v) -> {
            errors.add(new ValidationException(v.getField(), v.getDefaultMessage()));
        });

        RestValidationException exception = new RestValidationException(HttpStatus.BAD_REQUEST.value(), errors);

        return ResponseEntity.badRequest().body(exception);
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

    @ExceptionHandler(IllegalRequestParamException.class)
    public ResponseEntity<RestException> IllegalRequestParamExceptionHandler(IllegalRequestParamException e)  {
        return ResponseEntity.badRequest().body(new RestException(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(IllegalRequestException.class)
    public ResponseEntity<RestException> IllegalRequestExceptionHandler(IllegalRequestException e) {
        return ResponseEntity.badRequest().body(new RestException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }

    @ExceptionHandler(InputModelAlreadyExistsException.class)
    public ResponseEntity<RestException> InputModelAlreadyExistsExceptionHandler(InputModelAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(new RestException(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RestException> EntityNotFoundExceptionHandler(EntityNotFoundException e) {
        return ResponseEntity.badRequest().body(new RestException(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }
}
