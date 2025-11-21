package br.com.psantanna1990.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.annotation.security.RolesAllowed;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.PermitAll;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Authenticated
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
