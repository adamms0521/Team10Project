package edu.uiowa.projectteam10.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

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

    @ManyToOne(cascade={CascadeType.ALL})
    private Ride ride;

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
