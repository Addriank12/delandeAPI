package Controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import DAO.UserDAO;
import Helper.SecurityHelper;
import Models.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import Security.JwtGenerator;

@Path("/auth")
public class AuthController  {

    @Inject
    UserDAO userDAO;

    @Inject
    JwtGenerator JwtGenerator;

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User user){
        user.setSalt(SecurityHelper.generateSalt());
        try {
            user.setPassword(SecurityHelper.hashPassword(user.getPassword(), user.getSalt()));
            userDAO.save(user);
            user.setPassword(null);
            user.setSalt(null);
            return Response.ok(user).build();
        }
        catch (Exception exception){
            return Response.serverError().build();
        }        
    }

    private boolean authenticate(String username, String password) {
        Optional<User> optionalUser = userDAO.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String hashedPassword;

                try {
                    hashedPassword = SecurityHelper.hashPassword(password, user.getSalt());
                } catch (NoSuchAlgorithmException e) {
                    return false;
                } catch (InvalidKeySpecException e) {
                    return false;
                }
            return hashedPassword.equals(user.getPassword());
        }
        return false;
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response Login(User user){
        if(authenticate(user.getEmail(), user.getPassword())){
            return Response.ok(JwtGenerator.generateToken(user.getEmail())).build();
        }
        return Response.ok("Invalid credentials").build() ;                
    }

}
