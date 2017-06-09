package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("flight")
public class FightRestController {
    @Inject
    private FlightService flightService;
    @Inject
    private AirportService airportService;
    @Inject
    private AirlineService airlineService;
    @Inject
    private AirplaneService airplaneService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> index() {
        return flightService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response find(@PathParam("id") int id) {
        Flight flight = new Flight();
        flight.setId(id);
        flight = flightService.find(flight);

        if (flight == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Message.error(String.format("Flight with id %d doesn't exist.", id)))
                    .build();
        }

        return Response.ok(flight).build();
    }

    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Flight flight) {
        try {
            flightService.create(flight);
            return Response.ok(flight).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity(Message.error("Cannot create flight")).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(Flight flight, @PathParam("id") int id) {
        try {
            flight.setId(id);

            if (flightService.find(flight) == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(Message.error(String.format("Flight with id %d doesn't exist.", id)))
                        .build();
            }

            flightService.update(flight);
            return Response.status(Response.Status.OK).entity(flight).build();
        } catch (Exception e) {
            return Response.serverError().entity(Message.error("Update failed.")).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            Flight flight = new Flight();
            flight.setId(id);
            flight = flightService.find(flight);

            if (flight == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(Message.error(String.format("Flight with id %d doesn't exist.", id)))
                        .build();
            }

            flightService.delete(flight);
            return Response.ok(Message.success(String.format("Successfully deleted flight with id: %d", id)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                    .entity(Message.error(String.format("Unable to delete flight with id: %d", id))).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{flightId}/origin/{originId}")
    public Response addOrigin(@PathParam("flightId") int flightId, @PathParam("originId") int originId) {
        Flight flight = new Flight();
        flight.setId(flightId);
        Airport airport = new Airport();
        airport.setId(originId);

        flight = flightService.find(flight);
        airport = airportService.find(airport);

        if (flight == null || airport == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Message.error("Flight or origin airport not found")).build();
        }

        flight.setOrigin(airport);

        flightService.update(flight);

        return Response.ok(flight).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{flightId}/destination/{destinationId}")
    public Response addDestination(@PathParam("flightId") int flightId, @PathParam("destinationId") int destinationId) {
        Flight flight = new Flight();
        flight.setId(flightId);
        Airport airport = new Airport();
        airport.setId(destinationId);

        flight = flightService.find(flight);
        airport = airportService.find(airport);

        if (flight == null || airport == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Message.error("Flight or destination airport not found")).build();
        }

        flight.setDestination(airport);

        flightService.update(flight);

        return Response.ok(flight).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{flightId}/airline/{airlineId}")
    public Response addAirline(@PathParam("flightId") int flightId, @PathParam("airlineId") int airlineId) {
        Flight flight = new Flight();
        flight.setId(flightId);
        Airline airline = new Airline();
        airline.setId(airlineId);

        flight = flightService.find(flight);
        airline = airlineService.find(airline);

        if (flight == null || airline == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Message.error("Flight or airline not found")).build();
        }

        flight.setAirline(airline);

        flightService.update(flight);

        return Response.ok(flight).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{flightId}/airplane/{airplaneId}")
    public Response addAirplane(@PathParam("flightId") int flightId, @PathParam("airplaneId") int airplaneId) {
        Flight flight = new Flight();
        flight.setId(flightId);
        Airplane airplane = new Airplane();
        airplane.setId(airplaneId);

        flight = flightService.find(flight);
        airplane = airplaneService.find(airplane);

        if (flight == null || airplane == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Message.error("Flight or airplane not found")).build();
        }

        flight.setAirplane(airplane);

        flightService.update(flight);

        return Response.ok(flight).build();
    }
}
