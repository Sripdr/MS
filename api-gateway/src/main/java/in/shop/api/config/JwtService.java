package in.shop.api.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.Function;

public class JwtService {
    @Value("${jwt.secretKey}")
    private String JWT_SECRET;

    public Key getJwtKey() {
        return Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
    }

    public boolean validateToken(String token) {

        return isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, (Function<String, Date>) expiration -> Date.from(LocalDateTime.parse(expiration).atZone(ZoneId.systemDefault()).toInstant()));
    }
    public <T> T extractClaim(String token, Function<String, T> claimsResolver) {
        final String claims = String.valueOf(getUsernameFromToken(token));
        return claimsResolver.apply(claims);
    }


    public String getUsernameFromToken(String token) {
        Claims claims=  Jwts.parser()
                .verifyWith((SecretKey) getJwtKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }



}
