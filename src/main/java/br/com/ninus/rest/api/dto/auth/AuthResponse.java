package br.com.ninus.rest.api.dto.auth;

public record AuthResponse(
    String token,
    String type,
    String prefix,
    Long accountId
) {
    
}
