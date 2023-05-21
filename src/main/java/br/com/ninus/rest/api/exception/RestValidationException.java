package br.com.ninus.rest.api.exception;

import br.com.ninus.rest.api.exception.dto.ValidationException;

import java.util.List;

public record RestValidationException(Integer status, List<ValidationException> errors) {
}
