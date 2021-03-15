package org.acme.rest.client;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;
import java.util.concurrent.CompletionStage;


//@Path, @GET, @PathParam are standard JAX-RS annotations used to define HOW to access the service
//@Produces defines the expected content-type

@Path("/v2")
@RegisterRestClient(configKey="country-api") //Interface is meant for CDI (Context Dependency Injection) as a REST Client
@RegisterClientHeaders(RequestUUIDHeaderFactory.class)
public interface CountriesService {

    @GET
    @Path("/name/{name}")
    Set<Country> getByName(@PathParam String name);

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    CompletionStage<Set<Country>> getByNameAsync(@PathParam String name);

}