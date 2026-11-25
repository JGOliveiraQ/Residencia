package br.com.stockmanager.security;
import br.com.stockmanager.entity.User; import io.jsonwebtoken.*; import io.jsonwebtoken.security.Keys; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import javax.crypto.SecretKey; import java.nio.charset.StandardCharsets; import java.time.*; import java.util.*;
@Service public class JwtService{
 private final SecretKey key; private final long expiration; public JwtService(@Value("${app.jwt.secret}") String secret,@Value("${app.jwt.expiration-seconds}") long expiration){if(secret.length()<32)throw new IllegalArgumentException("JWT_SECRET deve possuir ao menos 32 caracteres.");key=Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));this.expiration=expiration;}
 public String generate(User u){Instant now=Instant.now();return Jwts.builder().subject(u.getEmail()).claim("role",u.getRole().name()).issuedAt(Date.from(now)).expiration(Date.from(now.plusSeconds(expiration))).signWith(key).compact();}
 public String subject(String token){return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();} public long expiration(){return expiration;}
}
