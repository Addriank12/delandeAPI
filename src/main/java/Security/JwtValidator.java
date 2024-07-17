package Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@ApplicationScoped
public class JwtValidator {

    private final String SECRET_KEY = "HsWZmT@uv7|(|L[Ilwf`M18`AG1I/&UlIN8~_o=G[Td8zEraE";
    private final Key key = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());

    public Claims validateToken(String token) throws JwtException  {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
