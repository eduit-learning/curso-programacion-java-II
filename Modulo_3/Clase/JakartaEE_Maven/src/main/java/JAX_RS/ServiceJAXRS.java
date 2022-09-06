package JAX_RS;

import ServletsDB.Models.User;
import ServletsDB.Models.UserDB;
import ServletsDB.Repository.EntityManagerContext;
import ServletsDB.Repository.StaticContext;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
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
            EntityManager em = EntityManagerContext.getEntityManagerContext();
            return Response.ok(em.createQuery("select u from UserDB u left outer join fetch u.role", UserDB.class).getResultList()).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/get-user/{userID}")
    public Response getUser(@PathParam("userID") int userID) {
        try {
            StaticContext sc = new StaticContext();
            EntityManager em = EntityManagerContext.getEntityManagerContext();
            return Response.ok(em.find(UserDB.class, userID)).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/create-user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User newUser) {
        try {
            EntityManager em = EntityManagerContext.getEntityManagerContext();
            if (newUser.getUserID() > 0) {
                em.merge(newUser);
            } else {
                em.persist(newUser);
            }
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
            EntityManager em = EntityManagerContext.getEntityManagerContext();
            if (newUser.getUserID() > 0) {
                em.merge(newUser);
            } else {
                em.persist(newUser);
            }
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