package org.acme.rest.client;

import io.smallrye.mutiny.Uni;
import org.acme.rest.client.CountriesService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.concurrent.CompletionStage;

@Path("/country")
public class CountriesResource {

    @Inject
    @RestClient
    CountriesService countriesService;


    @GET
    @Path("/name/{name}")
    public Set<Country> name(@PathParam String name) {
        return countriesService.getByName(name);
    }

//    @GET
//    @Path("/name-async/{name}")
//    public CompletionStage<Set<Country>> nameAsync(@PathParam String name) {
//        return countriesService.getByNameAsync(name);
//    }

    @GET
    @Path("/name-uni/{name}")
    public Uni<Set<Country>> nameAsync(@PathParam String name) {
        return countriesService.getByNameAsUni(name);
    }
}