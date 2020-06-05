package me.minidigger.hangar.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class TokenService {

    private final String issuer;
    private final String secret;
    private final int expiry;

    private JWTVerifier verifier;
    private Algorithm algo;

    public TokenService(
            @Value("${jwt.issuer}") String issuer,
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiry}") int expiry) {
        this.issuer = issuer;
        this.secret = secret;
        this.expiry = expiry;
    }

    public DecodedJWT verify(String token) {
        return getVerifier().verify(token);
    }

    public String expiring(UUID id) {
        return JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(new Date(Instant.now().plusSeconds(expiry).toEpochMilli()))
                .withSubject(id.toString())
                .sign(getAlgo());
    }

    private JWTVerifier getVerifier() {
        if (verifier == null) {
            verifier = JWT.require(getAlgo())
                    .withIssuer(issuer)
                    .build();
        }
        return verifier;
    }

    private Algorithm getAlgo() {
        if(algo == null) {
            algo = Algorithm.HMAC256(secret);
        }
        return algo;
    }
}
