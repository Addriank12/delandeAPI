package Controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import DAO.UserDAO;
import Helpers.SecurityHelper;
import Helpers.ValidatorHelper;
import Models.User;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import Security.JwtGenerator;

@Path("/auth")
@Provider
@Priority(Priorities.USER)
public class AuthController  {

    @Inject
    UserDAO userDAO;

    @Inject
    JwtGenerator JwtGenerator;

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response register(User user){        
        try {
            ValidatorHelper.validateModel(user);
            user.setSalt(SecurityHelper.generateSalt());
            user.setPassword(SecurityHelper.hashPassword(user.getPassword(), user.getSalt()));
            userDAO.save(user);
            user.setPassword(null);
            user.setSalt(null);
            return Response.ok("Usuario registrado.").build();
        }
        catch (Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }        
    }

    private boolean authenticate(String username, String password) {
        try {
            Optional<User> optionalUser = userDAO.findByUsername(username);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                String hashedPassword;
                hashedPassword = SecurityHelper.hashPassword(password, user.getSalt());                
                return hashedPassword.equals(user.getPassword());
            }
        }
        catch (NoSuchAlgorithmException e) {
            return false;
        }
        catch (InvalidKeySpecException e) {
            return false;
        }
        return false;
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response Login(User user){
        try{
            ValidatorHelper.validateModel(user);
            if(authenticate(user.getEmail(), user.getPassword())){
                return Response.ok(JwtGenerator.generateToken(user.getEmail())).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid credentials").build();  
        }
        catch (Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
                
    }

}
