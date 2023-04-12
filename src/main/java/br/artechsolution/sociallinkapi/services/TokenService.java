package br.artechsolution.sociallinkapi.services;

import br.artechsolution.sociallinkapi.models.UserAdminModel;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {


    //Método para criar um token JWT
    public String generateToken(UserAdminModel user) {
        //Create Token JWT
        return JWT.create()
                .withIssuer("Messages")
                .withSubject(user.getUsername())
                .withClaim("uuid", String.valueOf(user.getUuid()))
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("secret"));

    }

    //Método para pegar o subject do token após verificar
    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secret"))
                .withIssuer("Messages")
                .build().verify(token).getSubject();
    }
}
