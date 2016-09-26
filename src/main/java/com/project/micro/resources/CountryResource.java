package com.project.micro.resources;

import com.google.gson.Gson;
import com.project.micro.model.Country;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/country")
public class CountryResource implements CountryResourceEndpoint {
    
    public final static Logger LOGGER = Logger.getLogger(CountryResource.class.getName());
    
    public final static Gson gson = new Gson();
    
    @Override
    @GET
    @Path("/ping")
    public Response ping() {
        String message = "Country is alive";
        System.out.println("I am ping and I am called");
        return Response.status(Response.Status.OK).entity(message).build();
    }
    
    @Override
    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountry() {
        Set<Country> retval = new HashSet<>();
        Country country = new Country();
        country.setId(1);
        country.setName("Armenia");
        country.setCapital("Yerevan");
        country.setPopulation(3000000D);
        retval.add(country);
        return Response.status(Response.Status.OK).entity(retval).build();
    }
    
    @Override
    public Response exit() {
        System.exit(0);
        return Response.noContent().build();
    }
    
}
