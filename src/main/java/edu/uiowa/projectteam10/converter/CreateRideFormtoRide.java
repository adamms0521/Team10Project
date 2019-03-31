package edu.uiowa.projectteam10.converter;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.model.Rides;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateRideFormtoRide implements Converter<CreateRideForm, Rides> {
    @Override
    public Rides convert(CreateRideForm rideForm) {
        Rides ride = new Rides();
        ride.setStartPlace(rideForm.getStartPlace());
        ride.setEndPlace(rideForm.getEndPlace());
        ride.setStartTime(rideForm.getStartTime());
        ride.setEndTime(rideForm.getEndTime());
        return ride;
    }
}
