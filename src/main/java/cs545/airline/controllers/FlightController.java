package cs545.airline.controllers;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class FlightController {
    @Inject
    private FlightService flightService;
    private Flight flight;
    private List<Flight> flights;
    private String filterBy;
    private String filterValue;

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public void searchTermChanged(ValueChangeEvent event) {
        filterBy = (String) event.getNewValue();
    }

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    @PostConstruct
    private void loadFlights() {
        flights = flightService.findAll();
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void findFlight(int id) {
        Flight flight = new Flight();
        flight.setId(id);
        this.flight = flightService.find(flight);
    }

    public boolean isFilterName() {
        return filterBy.equals("airline") || filterBy.equals("destination");
    }
}
