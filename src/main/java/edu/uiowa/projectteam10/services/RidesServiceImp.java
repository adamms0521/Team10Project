package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.converter.CreateRideFormtoRide;
import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.model.Rides;
import edu.uiowa.projectteam10.repository.RidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RidesServiceImp implements RidesService {
    private RidesRepository ridesRepository;
    private CreateRideFormtoRide createRideFormtoRide;

    public RidesServiceImp(RidesRepository ridesRepository, CreateRideFormtoRide createRideFormtoRide){
        this.ridesRepository = ridesRepository;
        this.createRideFormtoRide = createRideFormtoRide;
    }

    @Override
    public Rides save(Rides rides) {
        ridesRepository.save(rides);
        return rides;
    }

    @Override
    public Rides saveForm(CreateRideForm rideForm) {
        Rides savedRide = save(createRideFormtoRide.convert(rideForm));
        return savedRide;
    }

    @Override
    public List<Rides> getRides(){
        Iterable<Rides> rides = this.ridesRepository.findAll();
        List<Rides> allrides = new ArrayList<>();
        for(Rides ride: rides){
            allrides.add(ride);
        }
        return allrides;
    }
}
