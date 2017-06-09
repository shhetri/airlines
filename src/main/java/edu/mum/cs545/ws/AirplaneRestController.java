package edu.mum.cs545.ws;

import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("airplane")
public class AirplaneRestController {
    @Inject
    private AirplaneService airplaneService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Airplane> index() {
        return airplaneService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response find(@PathParam("id") int id) {
        Airplane airplane = new Airplane();
        airplane.setId(id);
        airplane = airplaneService.find(airplane);

        if (airplane == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Message.error(String.format("Airplane with id %d doesn't exist.", id)))
                    .build();
        }

        return Response.ok(airplane).build();
    }

    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Airplane airplane) {
        try {
            airplaneService.create(airplane);
            return Response.ok(airplane).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity(Message.error("Cannot create airplane")).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(Airplane airplane, @PathParam("id") int id) {
        try {
            airplane.setId(id);

            if (airplaneService.find(airplane) == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(Message.error(String.format("Airplane with id %d doesn't exist.", id)))
                        .build();
            }

            airplaneService.update(airplane);
            return Response.status(Response.Status.OK).entity(airplane).build();
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
            Airplane airplane = new Airplane();
            airplane.setId(id);
            airplane = airplaneService.find(airplane);

            if (airplane == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(Message.error(String.format("Airplane with id %d doesn't exist.", id)))
                        .build();
            }

            airplaneService.delete(airplane);
            return Response.ok(Message.success(String.format("Successfully deleted airplane with id: %d", id)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                    .entity(Message.error(String.format("Unable to delete airplane with id: %d", id))).build();
        }
    }
}
