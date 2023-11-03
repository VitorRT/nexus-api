package br.com.ninus.rest.api.dto.auth;

public record AuthRequest(
    String email,
    String password
) {
    
}
