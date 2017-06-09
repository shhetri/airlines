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
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Message.error(String.format("Airline with id %d doesn't exist.", id)))
                    .build();
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
            e.printStackTrace();
            return Response.serverError().entity(Message.error("Cannot create airline")).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(Airline airline, @PathParam("id") int id) {
        try {
            airline.setId(id);

            if (airlineService.find(airline) == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(Message.error(String.format("Airline with id %d doesn't exist.", id)))
                        .build();
            }

            airlineService.update(airline);
            return Response.status(Response.Status.OK).entity(airline).build();
        } catch (Exception e) {
            return Response.serverError().entity(Message.error("Update failed.")).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            Airline airline = new Airline();
            airline.setId(id);
            airline = airlineService.find(airline);

            if (airline == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(Message.error(String.format("Airline with id %d doesn't exist.", id)))
                        .build();
            }

            airlineService.delete(airline);
            return Response.ok(Message.success(String.format("Successfully deleted airline with id: %d", id)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                    .entity(Message.error(String.format("Unable to delete airline with id: %d", id))).build();
        }
    }
}
