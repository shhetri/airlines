package edu.mum.cs545.ws;

import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("airport")
public class AirportRestController {
    @Inject
    private AirportService airportService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Airport> index() {
        return airportService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response find(@PathParam("id") int id) {
        Airport airport = new Airport();
        airport.setId(id);
        airport = airportService.find(airport);

        if (airport == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Message.error(String.format("Airport with id %d doesn't exist.", id)))
                    .build();
        }

        return Response.ok(airport).build();
    }

    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Airport airport) {
        try {
            airportService.create(airport);
            return Response.ok(airport).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity(Message.error("Cannot create airport")).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(Airport airport, @PathParam("id") int id) {
        try {
            airport.setId(id);

            if (airportService.find(airport) == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(Message.error(String.format("Airport with id %d doesn't exist.", id)))
                        .build();
            }

            airportService.update(airport);
            return Response.status(Response.Status.OK).entity(airport).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity(Message.error("Update failed.")).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            Airport airport = new Airport();
            airport.setId(id);
            airport = airportService.find(airport);

            if (airport == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(Message.error(String.format("Airport with id %d doesn't exist.", id)))
                        .build();
            }

            airportService.delete(airport);
            return Response.ok(Message.success(String.format("Successfully deleted airport with id: %d", id)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                    .entity(Message.error(String.format("Unable to delete airport with id: %d", id))).build();
        }
    }
}
