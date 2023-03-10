package io.xstefank;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/ping")
public class PingResource {

    @Inject
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive " +
            (securityContext.getUserPrincipal() != null ? securityContext.getUserPrincipal().getName() : "anonymous");
    }
}