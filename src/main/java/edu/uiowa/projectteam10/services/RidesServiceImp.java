package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.repository.RidesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RidesServiceImp implements RidesService {
    private RidesRepository ridesRepository;

    public RidesServiceImp(RidesRepository ridesRepository){
        this.ridesRepository = ridesRepository;
    }

    @Override
    public Ride save(Ride ride) {
        ridesRepository.save(ride);
        return ride;
    }

    @Override
    public Ride saveForm(CreateRideForm rideForm) {
        Ride ride = new Ride();
        ride.setStartTime(rideForm.getStartTime());
        ride.setEndTime(rideForm.getEndTime());
        ride.setRouteName(rideForm.getRouteName());
        save(ride);
        return ride;
    }

    @Override
    public List<Ride> getRides(){
        Iterable<Ride> rides = this.ridesRepository.findAll();
        List<Ride> allrides = new ArrayList<>();
        for(Ride ride: rides){
            try {
                if (!ride.getDriver().isEmpty()) {
                    allrides.add(ride);
                }
            } catch (NullPointerException e){
                e.getStackTrace();
            }
        }
        return allrides;
    }
}
