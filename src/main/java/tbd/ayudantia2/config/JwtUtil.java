package tbd.ayudantia2.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
public class JwtUtil {

    private static String SECRET = "yo";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    public String create(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("tbd")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5))
                ).sign(ALGORITHM);

    }

    public boolean isValid(String jwt){
        try {
            JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String getUsername(String jwt){
        return JWT.require(ALGORITHM)
                .build()
                .verify(jwt)
                .getSubject();
    }
}
