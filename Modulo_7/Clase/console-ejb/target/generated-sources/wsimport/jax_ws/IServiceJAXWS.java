
package jax_ws;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;
import jax_ws.interfaces.ObjectFactory;
import jax_ws.interfaces.User;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.2
 * Generated source version: 3.0
 * 
 */
@WebService(name = "IServiceJAXWS", targetNamespace = "http://Interfaces.JAX_WS/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IServiceJAXWS {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "grettings", targetNamespace = "http://Interfaces.JAX_WS/", className = "jax_ws.interfaces.Grettings")
    @ResponseWrapper(localName = "grettingsResponse", targetNamespace = "http://Interfaces.JAX_WS/", className = "jax_ws.interfaces.GrettingsResponse")
    public String grettings(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<jax_ws.interfaces.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUsers", targetNamespace = "http://Interfaces.JAX_WS/", className = "jax_ws.interfaces.GetUsers")
    @ResponseWrapper(localName = "getUsersResponse", targetNamespace = "http://Interfaces.JAX_WS/", className = "jax_ws.interfaces.GetUsersResponse")
    public List<User> getUsers();

}
