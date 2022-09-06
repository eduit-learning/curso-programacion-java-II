package ServletsDB.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class EntityManagerContext {
    private static final EntityManagerFactory emFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("MSSQLDataContext");
    }

    public static EntityManager getEntityManagerContext(){
        return emFactory.createEntityManager();
    }
}
