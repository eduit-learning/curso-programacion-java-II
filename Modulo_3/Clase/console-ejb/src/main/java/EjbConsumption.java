import EJBs.Interfaces.IServiceEjbRemote;
import EJBs.ServiceEjbRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class EjbConsumption {
    public static void main(String[] args) throws NamingException {


        final Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put("jboss.naming.client.ejb.context", true);
        InitialContext remoteContext = new InitialContext(env);
        IServiceEjbRemote service = (IServiceEjbRemote)remoteContext.lookup("ejb:/JakartaEE_Maven/ServiceEjbRemote!EJBs.Interfaces.IServiceEjbRemote");

        for(var item : service.getUsers()){
            System.out.println(item.getName());
        }
    }
}
