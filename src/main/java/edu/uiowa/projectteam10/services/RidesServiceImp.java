package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.repository.RidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

@Service
public class RidesServiceImp implements RidesService {
    private RidesRepository ridesRepository;
    @Autowired
    private RouteService routeService;

    public RidesServiceImp(RidesRepository ridesRepository){
        this.ridesRepository = ridesRepository;
    }

    @Override
    public Ride save(Ride rides) {
        ridesRepository.save(rides);
        return rides;
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
    public List<Ride> getRidesByRoute(String routeName, Integer currentRide){
        Iterable<Ride> rides = this.ridesRepository.findAll();
        List<Ride> allrides = new ArrayList<>();
        for(Ride ride: rides){
            try {
                if (!ride.getDriver().isEmpty() && ride.getRouteName().matches(routeName) && !ride.getRideID().equals(currentRide)) {
                    allrides.add(ride);
                }
            } catch (NullPointerException e){
                e.getStackTrace();
            }
        }
        return allrides;
    }

    @Override
    public List<Ride> getRidesByID(Integer rideID){
        Iterable<Ride> rides = this.ridesRepository.findAll();
        List<Ride> associatedRideID = new ArrayList<>();
        for(Ride ride: rides){
            try {
                if (ride.getRideID().equals(rideID)) {
                    associatedRideID.add(ride);
                }
            } catch (NullPointerException e){
                e.getStackTrace();
            }
        }
        return associatedRideID;
    }

    @Override
    public List<Ride> getEmptyRides(){
        Iterable<Ride> rides = this.ridesRepository.findAll();
        List<Ride> allrides = new ArrayList<>();
        for(Ride ride: rides){
            try {
                if (ride.getDriver().isEmpty()) {
                    allrides.add(ride);
                }
            } catch (NullPointerException e){
                e.getStackTrace();
                allrides.add(ride);
            }
        }
        return allrides;
    }

    @Override
    public void assignDriver(Integer id, String name) {
        ridesRepository.assignDriver(id, name);
    }

    @Override
    public String getRoutebyRide(Integer id) {
        return ridesRepository.getRoutebyRideID(id);
    }

    @Override
    public void setPrice(String routeName) {
        Double bill = getBilling(routeName);
        String finalBill = "$" + bill;
        ridesRepository.updatePrice(finalBill, routeName);
    }

    @Override
    public Double getBilling(String routename) {
        Double bill = routeService.getDistanceByName(routename);
        return bill*0.25;
    }

}
