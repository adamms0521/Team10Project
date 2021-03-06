package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.repository.RidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    //save ride info
    @Override
    public Ride saveForm(CreateRideForm rideForm) {
        Ride ride = new Ride();
        ride.setStartTime(rideForm.getStartTime());
        ride.setEndTime(rideForm.getEndTime());
        ride.setRouteName(rideForm.getRouteName());
        save(ride);
        return ride;
    }

    //get all rides with same rideid
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

    //return all rides by ridesid
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

    //get all rides without driver
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

    //assign driver
    @Override
    public void assignDriver(Integer id, String name) {
        ridesRepository.assignDriver(id, name);
    }

    //get route by ride
    @Override
    public String getRoutebyRide(Integer id) {
        return ridesRepository.getRoutebyRideID(id);
    }

    //set price to route
    @Override
    public void setPrice(String routeName) {
        Double bill = getBilling(routeName);
        String finalBill = "$" + bill;
        Iterable<Ride> rides = this.ridesRepository.findAll();
        for(Ride ride: rides){
            if (ride.getRouteName().equals(routeName)) {
                ridesRepository.updatePrice(finalBill, ride.getRideID());
            }
        }
    }

    //billing
    @Override
    public Double getBilling(String routename) {
        Double bill = routeService.getDistanceByName(routename);
        return bill*0.25;
    }
    //return rides with driver usename
    @Override
    public List<Ride> getRidesForDriver(String username) {
        Iterable<Ride> rides = ridesRepository.findAll();
        List<Ride> allrides = new ArrayList<>();
        for (Ride ride : rides) {
            try {
                if (ride.getDriver().equals(username)) {
                    allrides.add(ride);
                }
            } catch (NullPointerException e) {
                e.getStackTrace();
            }
        }
        return allrides;

    }

    @Override
    public void deleteRideFromDriver(Integer RideID) {
        ridesRepository.deleteRideFromDriver(RideID);
    }

    @Override
    public List<Ride> getRides() {
        Iterable<Ride> rides = this.ridesRepository.findAll();
        List<Ride> allrides = new ArrayList<>();
        for(Ride ride: rides){
            allrides.add(ride);
        }
        return allrides;
    }

}
