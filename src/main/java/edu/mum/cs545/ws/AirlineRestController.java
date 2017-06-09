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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response find(@PathParam("id") int id) {
        Airline airline = new Airline();
        airline.setId(id);
        airline = airlineService.find(airline);

        if (airline == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(String.format("Airline with id %d doesn't exist.", id)).build();
        }

        return Response.ok(airline).build();
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
