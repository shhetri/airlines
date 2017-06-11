package cs545.airline.controllers;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AirlineController implements Serializable {
    private static final long serialVersionUID = -1710778088698521736L;
    @Inject
    private AirlineService airlineService;

    private Airline airline = new Airline();

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public List<Airline> getAirlines() {
        return airlineService.findAll();
    }

    public String edit(Airline airline) {
        this.airline = airline;

        return "edit-airline?faces-redirect=true";
    }

    public String delete(String name) {
        airline = airlineService.findByName(name);
        airlineService.delete(airline);
        return "faces/list-airline?faces-redirect=true";
    }

    public String update(int id) {
        airline.setId(id);
        airlineService.update(airline);
        return "faces/list-airline?faces-redirect=true";
    }

    public String create() {
        airlineService.create(airline);

        return "faces/list-airline?faces-redirect=true";
    }

    public String createView() {
        airline = new Airline();
        return "create-airline";
    }
}
