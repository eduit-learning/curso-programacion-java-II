package EJBs.Interfaces;

import jakarta.ejb.Local;

@Local
public interface IServiceEjbLocal {
    String greetings(String nombre);
}
