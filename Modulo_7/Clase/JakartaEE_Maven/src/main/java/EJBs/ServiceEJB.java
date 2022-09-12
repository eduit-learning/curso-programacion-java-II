package EJBs;

import EJBs.Interfaces.IServiceEjbLocal;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

@Stateless
//@Stateful
//@RequestScoped //El contexto solo es funcional con los stateful
//@SessionScoped //El contexto solo es funcional con los stateful
public class ServiceEJB implements IServiceEjbLocal {

    public int requests = 0;

    public ServiceEJB(){
        requests = 0;
    }

    public String greetings(String nombre) {
        requests += 1;
        System.out.println("Instancia del EJB: " + this + " - Peticiones: " + requests);
        return "Hola " + nombre + " desde EJB - Peticiones: " + requests;
    }
}