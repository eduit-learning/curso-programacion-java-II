package JAX_RS;

import ServletsDB.Models.User;
import ServletsDB.Repository.StaticContext;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@RequestScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class ServiceJAXRS {
    @GET
    @Path("/get-all-users")
    public Response getUsers() {
        try {
            return Response.ok(new StaticContext().users).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/get-user/{userID}")
    public Response getUser(@PathParam("userID") int userID) {
        try {
            StaticContext sc = new StaticContext();
            if (sc.users.stream().anyMatch(u -> u.getUserID() == userID) == true) {
                return Response.ok(sc.users.stream().filter(u -> u.getUserID() == userID).findFirst().get()).build();
            }

            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/create-user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User newUser) {
        try {
            return Response.ok("El usuario se creó correctamente").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/update-user/{userID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userID") int userID, User newUser) {
        try {
            return Response.ok("El usuario se actualizó correctamente").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/delete-user/{userID}")
    public Response deleteUser(@PathParam("userID") int userID) {
        try {
            return Response.ok("El usuario se eliminó correctamente").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}