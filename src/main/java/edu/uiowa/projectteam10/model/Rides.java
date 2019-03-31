package edu.uiowa.projectteam10.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "rides")
public class Rides {
    @Id
    @NotNull
    @GeneratedValue
    private int rideID;

    @NotNull
    private String startPlace;

    @NotNull
    private String endPlace;

    @NotNull
    private String startTime;

    @NotNull
    private String endTime;

    @NotNull
    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(@NotNull String startPlace) {
        this.startPlace = startPlace;
    }

    @NotNull
    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(@NotNull String endPlace) {
        this.endPlace = endPlace;
    }

    @NotNull
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(@NotNull String startTime) {
        this.startTime = startTime;
    }

    @NotNull
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(@NotNull String endTime) {
        this.endTime = endTime;
    }

    public int getRideID() {
        return rideID;
    }

    public void setRideID(int rideID) {
        this.rideID = rideID;
    }
}
