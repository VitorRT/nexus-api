package br.com.ninus.rest.api.exception;

public record RestException(Integer status, String message) {
}
