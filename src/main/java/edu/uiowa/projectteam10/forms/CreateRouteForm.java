package edu.uiowa.projectteam10.forms;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

//route form
public class CreateRouteForm {
    @NotBlank
    private String startPlace;

    @NotBlank
    private String endPlace;

    @NotBlank
    private String routeName;

    @NotNull
    private Double distance;

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

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
