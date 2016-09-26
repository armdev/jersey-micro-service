package com.project.micro.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class CountryClient {

    private static final String BASE_URI = "http://localhost:9090";

   
    private final WebTarget collect;

    public CountryClient() {
        Client client = ClientBuilder.newClient();
       
        collect = client.target(BASE_URI + "/country");
    }

    public void ping() {
        WebTarget path = collect.path("/ping");
        Response response = path.request().get();
        System.out.print("Country Ping: " + response.readEntity(String.class) + "\n");
    }    
    
    public void findInfo() {
        WebTarget path = collect.path("/info");
        Response response = path.request().get();
        System.out.print("Country info : " + response.readEntity(String.class) + "\n");
    }

    public void exit() {
        try {
            collect.path("/exit").request().get();
        } catch (Throwable t) {
            // swallow
        }
    }

    public static void main(String[] args) {
        CountryClient wc = new CountryClient();
        wc.ping();
        wc.findInfo();
        wc.exit();
        System.out.print("Complete the client");
        System.exit(0);
    }
}
