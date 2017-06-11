package cs545.airline.controllers;

import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class FlightController implements Serializable {
    private static final long serialVersionUID = -8479722385194982377L;
    @Inject
    private FlightService flightService;
    @Inject
    private AirlineService airlineService;
    @Inject
    private AirportService airportService;
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
        return filterBy != null && (filterBy.equals("airline") || filterBy.equals("destination"));
    }

    public boolean isFilterDate() {
        return filterBy != null && (filterBy.equals("arrival") || filterBy.equals("departure"));
    }

    public void filter() {
        switch (filterBy) {
            case "airline":
                try {
                    flights = flightService.findByAirline(airlineService.findByName(filterValue));
                } catch (NoResultException e) {
                    flights = new ArrayList<>();
                }
                break;
            case "destination":
                List<Airport> airports = airportService.findByName(filterValue);
                if (airports.isEmpty())
                    flights = new ArrayList<>();
                else
                    flights = flightService.findByDestination(airportService.findByName(filterValue).get(0));
                break;
            case "arrival":
                try {
                    flights = flightService.findByArrival(DateFormat.getInstance().parse(filterValue));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "departure":
                try {
                    flights = flightService.findByDeparture(DateFormat.getInstance().parse(filterValue));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            default:
                loadFlights();
        }
    }

    public void resetFilter() {
        loadFlights();
        filterBy = null;
        filterValue = null;
        flight = null;
    }
}
