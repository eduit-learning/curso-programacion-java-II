import jax_ws.IServiceJAXWS;
import jax_ws.ServiceJAXWSService;

public class Client_JAXWS {
    public static void main(String[] args) {
        IServiceJAXWS service = new ServiceJAXWSService().getServiceJAXWSPort();
        System.out.println("El saludo es: " + service.grettings("Abraham"));
        for (var item : service.getUsers()) {
            System.out.println(item.getName());
        }
    }
}