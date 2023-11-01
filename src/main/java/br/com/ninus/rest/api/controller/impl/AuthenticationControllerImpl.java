package br.com.ninus.rest.api.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ninus.rest.api.controller.IAuthenticationController;
import br.com.ninus.rest.api.dto.auth.AuthRequest;
import br.com.ninus.rest.api.dto.auth.AuthResponse;
import br.com.ninus.rest.api.service.impl.TokenService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class AuthenticationControllerImpl implements IAuthenticationController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;
    
    @PostMapping
    public ResponseEntity<AuthResponse> authentication(AuthRequest request) {
        Authentication usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        manager.authenticate(usernamePassword);
        var response = tokenService.generateToken(request);
        return ResponseEntity.ok(response);
    }
    
}
