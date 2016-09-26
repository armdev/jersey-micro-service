package com.project.micro.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public interface CountryResourceEndpoint {
    //http://localhost:9090/country/info
    //http://localhost:9090/country/ping
    @GET
    @Path("/ping")
    Response ping();
    
    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    Response getCountry();     

    @GET
    @Path("/exit")
    Response exit();
}
