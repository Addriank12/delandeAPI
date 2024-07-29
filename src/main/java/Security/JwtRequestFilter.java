package Security;

import java.io.IOException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class JwtRequestFilter implements ContainerRequestFilter {

    @Inject
    private JwtValidator jwtValidator;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
       String authorizationHeader = requestContext.getHeaderString("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new JwtException("Missing or invalid Authorization header.");
        }
        String token = authorizationHeader.substring(7);
         try {
            Claims claims = jwtValidator.validateToken(token);
            requestContext.setProperty("claims", claims);
        } catch (ExpiredJwtException e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Token expired").build());
        } catch (JwtException e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid token.").build());
        }
    }

}
