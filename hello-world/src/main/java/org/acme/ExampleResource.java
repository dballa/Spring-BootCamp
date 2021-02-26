package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/")
public class ExampleResource {
	@ConfigProperty(name="TARGET", defaultValue="World")
	String target;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello " +target+ "!";
    }
}