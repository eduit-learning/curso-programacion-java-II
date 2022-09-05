
package jax_ws.interfaces;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jax_ws.interfaces package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUsers_QNAME = new QName("http://Interfaces.JAX_WS/", "getUsers");
    private final static QName _GetUsersResponse_QNAME = new QName("http://Interfaces.JAX_WS/", "getUsersResponse");
    private final static QName _Grettings_QNAME = new QName("http://Interfaces.JAX_WS/", "grettings");
    private final static QName _GrettingsResponse_QNAME = new QName("http://Interfaces.JAX_WS/", "grettingsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jax_ws.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUsers }
     * 
     */
    public GetUsers createGetUsers() {
        return new GetUsers();
    }

    /**
     * Create an instance of {@link GetUsersResponse }
     * 
     */
    public GetUsersResponse createGetUsersResponse() {
        return new GetUsersResponse();
    }

    /**
     * Create an instance of {@link Grettings }
     * 
     */
    public Grettings createGrettings() {
        return new Grettings();
    }

    /**
     * Create an instance of {@link GrettingsResponse }
     * 
     */
    public GrettingsResponse createGrettingsResponse() {
        return new GrettingsResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUsers }{@code >}
     */
    @XmlElementDecl(namespace = "http://Interfaces.JAX_WS/", name = "getUsers")
    public JAXBElement<GetUsers> createGetUsers(GetUsers value) {
        return new JAXBElement<GetUsers>(_GetUsers_QNAME, GetUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUsersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Interfaces.JAX_WS/", name = "getUsersResponse")
    public JAXBElement<GetUsersResponse> createGetUsersResponse(GetUsersResponse value) {
        return new JAXBElement<GetUsersResponse>(_GetUsersResponse_QNAME, GetUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Grettings }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Grettings }{@code >}
     */
    @XmlElementDecl(namespace = "http://Interfaces.JAX_WS/", name = "grettings")
    public JAXBElement<Grettings> createGrettings(Grettings value) {
        return new JAXBElement<Grettings>(_Grettings_QNAME, Grettings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GrettingsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GrettingsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Interfaces.JAX_WS/", name = "grettingsResponse")
    public JAXBElement<GrettingsResponse> createGrettingsResponse(GrettingsResponse value) {
        return new JAXBElement<GrettingsResponse>(_GrettingsResponse_QNAME, GrettingsResponse.class, null, value);
    }

}
