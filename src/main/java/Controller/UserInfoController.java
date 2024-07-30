package Controller;

import DAO.UserInfoDAO;
import Helpers.ValidatorHelper;
import Models.UserInfo;
import Security.Secured;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("userInfo")
@Secured
@Priority(Priorities.AUTHENTICATION)
public class UserInfoController {

    @Inject
    UserInfoDAO userInfoDAO;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response save(UserInfo userInfo){
        try{
            ValidatorHelper.validateModel(userInfo);
            userInfoDAO.create(userInfo);
            return Response.ok(userInfo).build();        
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("togleAdmin/{idUser}")
    public Response togleAdmin(@PathParam("idUser") String idUser){
        try{
            UserInfo userInfo = userInfoDAO.get(idUser);
            userInfo.setAdmin(!userInfo.getIsAdmin());
            userInfoDAO.update(userInfo);
            return Response.ok(userInfo).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Response Update(UserInfo userInfo){
        try{
            ValidatorHelper.validateModel(userInfo);
            userInfoDAO.update(userInfo);
            return Response.ok(userInfo).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    @Path("{idUser}")
    public Response Delete(@PathParam("idUser") String idUser){
        try{
            userInfoDAO.delete(idUser);
            return Response.ok().build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("{email}")
    @GET
    public Response get(@PathParam("email") String email){
        try{            
            return Response.ok(userInfoDAO.get(email)).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAll(){
        try{            
            return Response.ok(userInfoDAO.getAll()).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
}
