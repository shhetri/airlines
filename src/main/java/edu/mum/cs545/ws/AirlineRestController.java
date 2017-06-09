package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("airline")
public class AirlineRestController {
    @Inject
    private AirlineService airlineService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Airline> index() {
        return airlineService.findAll();
    }

    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Airline airline) {
        try {
            airlineService.create(airline);
            return Response.ok(airline).build();
        } catch (Exception e) {
            return Response.serverError().entity("Cannot create airline.").build();
        }
    }
}
