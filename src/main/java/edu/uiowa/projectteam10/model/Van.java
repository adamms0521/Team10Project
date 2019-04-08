package edu.uiowa.projectteam10.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "van")
public class Van {

    @Id
    @GeneratedValue
    private Integer vanId;

    private String driverName;

    @ManyToOne
    private Ride ride;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="van",cascade = CascadeType.ALL)
    private List<Passengers> passengers;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public List<Passengers> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passengers> passengers) {
        this.passengers = passengers;
    }
}
