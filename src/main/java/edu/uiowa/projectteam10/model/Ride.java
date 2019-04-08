package edu.uiowa.projectteam10.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "rides")
public class Ride {
    @Id
    @GeneratedValue
    private Integer rideID;

    private String driver;

    @NotBlank
    private String routeName;

    @NotBlank
    private String startTime;

    @NotBlank
    private String endTime;

    @NotBlank
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }


    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Integer getRideID() {
        return rideID;
    }

    public void setRideID(Integer rideID) {
        this.rideID = rideID;
    }
}
