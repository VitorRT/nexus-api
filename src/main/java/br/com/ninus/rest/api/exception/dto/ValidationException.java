package br.com.ninus.rest.api.exception;

public record RestValidationError(String field, String message) {
}
