package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.model.Ride;

import java.util.List;

public interface RidesService {
    Ride save(Ride ride);

    Ride saveForm(CreateRideForm rideForm);

    List<Ride> getRidesByRoute(String routeName);

    List<Ride> getEmptyRides();

    void assignDriver(Integer id, String name);


}

