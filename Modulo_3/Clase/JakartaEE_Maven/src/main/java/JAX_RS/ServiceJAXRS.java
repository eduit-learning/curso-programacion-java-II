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

//A los métodos/actions/Operations de un servico REST no se les puede llamar APIs. La API es como tal la clase que los contiene.
//Es decir el servicio REST.
//http://[dominio]/api/[path clase]/[path operacion/método]
//http://localhost:8080/api/users-eduit/
@RequestScoped
@Path("/users-eduit")
@Produces(MediaType.APPLICATION_JSON)
public class ServiceJAXRS {

    @GET
    @Path("/getrole")
    public Response getRole() {
        return null;
    }

    @GET
    @Path("/getrole/{roleID}")
    public Response getRole(@PathParam("roleID") int roleID) {
        return null;
    }

    @GET
    @Path("/getrole/name/{name}")
    public Response getRole(@PathParam("name") String name) {
        return null;
    }

    @GET
    @Path("/x/y/{description}")
    public Response getRoleD(@PathParam("description") String description) {
        return null;
    }

    @GET
    @Path("/getrole/{name}/{description}")
    public Response getRole(@PathParam("name") String name, @PathParam("description") String description) {
        return null;
    }

    //http://localhost:8080/api/users-eduit/get-all-users-eduit
    @GET//Sin Path la petición a esta operación sería: http://localhost:8080/JakartaEE_Maven/api/users-eduit/getUsers
    @Path("/get-all-users")
//Con Path la petición a esta operación sería: http://localhost:8080/JakartaEE_Maven/api/users/get-all-users
    public Response getUsers() {
        try {
            EntityManager em = EntityManagerContext.getEntityManagerContext();
            return Response.ok(em.createQuery("select u from UserDB u left outer join fetch u.role", UserDB.class).getResultList()).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8080/api/users-eduit/get-user/[id del usuario]
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

    //http://localhost:8080/api/users-eduit/create-user
    @POST
    @Path("/create-user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDB newUser) {
        try {
            EntityManager em = EntityManagerContext.getEntityManagerContext();
            if (newUser.getUserID() > 0) {
                em.getTransaction().begin();
                em.merge(newUser);
                em.getTransaction().commit();
            } else {
                em.getTransaction().begin();
                em.persist(newUser);
                em.getTransaction().commit();
            }
            return Response.ok("El usuario se creó correctamente").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8080/api/users-eduit/update-user/[id del usuario]
    @PUT
    @Path("/update-user/{userID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userID") int userID, UserDB newUser) {
        try {
            EntityManager em = EntityManagerContext.getEntityManagerContext();
            if (newUser.getUserID() > 0) {
                em.getTransaction().begin();
                em.merge(newUser);
                em.getTransaction().commit();
            } else {
                em.getTransaction().begin();
                em.persist(newUser);
                em.getTransaction().commit();
            }
            return Response.ok("El usuario se actualizó correctamente").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8080/api/users-eduit/delete-user/[id del usuario]
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