import ServletsDB.Models.UserDB;
import ServletsDB.Repository.EntityManagerContext;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.core.Response;

public class Main {
    public static void main(String[] args) {
        EntityManager em = EntityManagerContext.getEntityManagerContext();
        var result =  em.createQuery("from UserDB", UserDB.class).getResultList();
        System.out.println(result);
    }
}
