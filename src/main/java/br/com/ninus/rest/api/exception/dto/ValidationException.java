package br.com.ninus.rest.api.exception.dto;

public record ValidationException(String field, String message) {
}
