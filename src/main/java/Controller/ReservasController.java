package Controller;

import DAO.ReservasDAO;
import DAO.UserInfoDAO;
import Helpers.ValidatorHelper;
import Models.Reservas;
import Models.UserInfo;
import Security.Secured;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("reservas")
@Secured
@Priority(Priorities.AUTHENTICATION)
public class ReservasController {

    @Inject
    ReservasDAO reservasDAO;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response save(Reservas reserva){
        try{
            ValidatorHelper.validateModel(reserva);
            reservasDAO.create(reserva);
            return Response.ok(reserva).build();        
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Response Update(Reservas reserva){
        try{
            ValidatorHelper.validateModel(reserva);
            reservasDAO.update(reserva);
            return Response.ok(reserva).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    @Path("{idReserva}")
    public Response Delete(@PathParam("idReserva") Integer idReserva){
        try{
            reservasDAO.delete(idReserva);
            return Response.ok().build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("{idReserva}")
    @GET
    public Response get(@PathParam("idReserva") Integer idReserva){
        try{            
            return Response.ok(reservasDAO.get(idReserva)).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAll(){
        try{            
            return Response.ok(reservasDAO.getAll()).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

}
