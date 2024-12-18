package Controller;

import DAO.LibroDAO;
import Helpers.ValidatorHelper;
import Models.Libro;
import Security.Secured;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("libro")
public class LibroController {

    @Inject
    LibroDAO libroDAO;

    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        try{
            return Response.ok(libroDAO.getAll()).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @GET
    @Path("{titulo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("titulo") String titulo){
        try{
            return Response.ok(libroDAO.get(titulo)).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @POST
    @Secured
    @Priority(Priorities.AUTHENTICATION)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Libro libro){
        try {
            ValidatorHelper.validateModel(libro);
            libroDAO.create(libro);
            return Response.ok(libro).build();            
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @PUT
    @Secured
    @Priority(Priorities.AUTHENTICATION)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Libro newLibro){
        try {
            ValidatorHelper.validateModel(newLibro);        
            libroDAO.update(newLibro);
            return Response.ok(newLibro).build();            
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @DELETE
    @Secured
    @Priority(Priorities.AUTHENTICATION)
    @Path("{titulo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("titulo") String titulo){
        try {      
            libroDAO.delete(titulo);
            return Response.ok().build();            
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

}
