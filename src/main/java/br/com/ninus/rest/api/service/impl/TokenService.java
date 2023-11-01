package br.com.ninus.rest.api.service.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.ninus.rest.api.dto.auth.AuthRequest;
import br.com.ninus.rest.api.dto.auth.AuthResponse;
import br.com.ninus.rest.api.entity.Client;
import br.com.ninus.rest.api.repository.ClientRepository;

@Service
public class TokenService {
    @Autowired
    private ClientRepository clientRepository;
    @Value("${jwt.secret}")
    private String secret;
    private String JWT_ISSUER = "NinusRestIssuer";

    public AuthResponse generateToken(AuthRequest request) {
        Client client = clientRepository.getClientByEmail(request.email()).get();
        
        Algorithm alg = Algorithm.HMAC256(secret);
        var token = JWT.create()
            .withSubject(client.getEmail())
            .withIssuer(JWT_ISSUER)
            .withExpiresAt(Instant.now().plus(7, ChronoUnit.DAYS))
            .sign(alg);

        var response = new AuthResponse(token, "JWT", "Bearer", client.getId());
        return response;
    }

    public Client getClientByToken(String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var email = JWT.require(alg)
            .withIssuer(JWT_ISSUER)
            .build()
            .verify(token)
            .getSubject();

        var response = clientRepository.getClientByEmail(email).get();
        return response;
    }
}
