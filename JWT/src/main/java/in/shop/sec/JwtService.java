package in.shop.sec;

import in.shop.entity.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;
    private final long jwtExpiration=new Date(System.currentTimeMillis()+ 1000L *60*60*1000).getTime();


    public long getExpirationTime() {
        return jwtExpiration;
    }


    public String generateToken(UserInfo user) {
        return Jwts
                .builder()
                .subject(user.getUsername())
                .claims()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() +jwtExpiration))
                .and()
                .signWith(getSecretInKey())
                .compact();
    }



    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, (Function<String, Date>) expiration -> Date.from(LocalDateTime.parse(expiration).atZone(ZoneId.systemDefault()).toInstant()));
    }
    public <T> T extractClaim(String token, Function<String, T> claimsResolver) {
        final String claims = String.valueOf(extractAllClaims(token));
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
      return Jwts
                .parser()
                .verifyWith((SecretKey) getSecretInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    private SecretKey getSecretInKey() {

        return  Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String getUsernameFromToken(String token) {
          Claims claims=  Jwts.parser()
                    .verifyWith(getSecretInKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
          return claims.getSubject();
    }


}
