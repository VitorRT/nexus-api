package br.com.ninus.rest.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ninus.rest.api.dto.auth.AuthRequest;
import br.com.ninus.rest.api.dto.auth.AuthResponse;

public interface IAuthenticationController {
    ResponseEntity<AuthResponse> authentication(@RequestBody AuthRequest request);
}
