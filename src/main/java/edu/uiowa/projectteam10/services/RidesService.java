package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.model.Ride;
import java.util.List;

public interface RidesService {
    Ride save(Ride ride);

    Ride saveForm(CreateRideForm rideForm);

    List<Ride> getRidesByRoute(String routeName, Integer currentRide);

    List<Ride> getEmptyRides();

    List<Ride> getRidesByID(Integer rideID);

    void assignDriver(Integer id, String name);

    String getRoutebyRide(Integer id);

    void setPrice(String name);

    Double getBilling(String routename);

    List<Ride> getRidesForDriver(String username);

    void deleteRideFromDriver(Integer RideID);

}

