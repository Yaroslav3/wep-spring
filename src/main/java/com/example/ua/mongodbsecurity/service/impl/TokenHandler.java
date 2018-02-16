package com.example.ua.mongodbsecurity.service.impl;

import com.google.common.io.BaseEncoding;
import com.sun.istack.internal.NotNull;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Component
public class TokenHandler {

    private final SecretKey secretKey;

    public TokenHandler() {

        String jxtKey = "jwtkey1234567890";

        byte[] decodeKey = BaseEncoding.base64().decode(jxtKey);
        secretKey = new SecretKeySpec(decodeKey, 0, decodeKey.length, "AES");
    }

    /**
     *  @jsonwebtoken  (расшифровка) позволяет создавать web-token
     **/
    public Optional<ObjectId> extractUserId(@NotNull String token) {

        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            return Optional.ofNullable(body.getId())
                    .map(ObjectId::new);

        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public String generateAccessToken(@NonNull ObjectId id, LocalDateTime expires) {
        return Jwts.builder()
                .setId(id.toString())
                .setExpiration(Date.from(expires.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512,secretKey)
                .compact();
    }
}
