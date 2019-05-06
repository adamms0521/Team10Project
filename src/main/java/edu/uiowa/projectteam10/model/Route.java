package edu.uiowa.projectteam10.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "routes")
public class Route {
    @Id
    @NotNull
    private String routeName;

    @NotNull
    private String startPlace;

    @NotNull
    private String endPlace;

    @NotNull
    private Double distance;
    public Route(){}
    public Route(String routeName, String startPlace, String endPlace, Double distance) {
        this.routeName = routeName;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.distance = distance;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
