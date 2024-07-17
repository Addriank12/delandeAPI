package Security;

import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;
import java.security.Key;

@ApplicationScoped
public class JwtGenerator {

    private final String SECRET_KEY = "HsWZmT@uv7|(|L[Ilwf`M18`AG1I/&UlIN8~_o=G[Td8zEraE";
    private final Key key = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día de validez
                .signWith(key)
                .compact();                
    }
}
