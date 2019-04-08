package edu.uiowa.projectteam10.forms;

import edu.uiowa.projectteam10.model.Ride;
import org.hibernate.validator.constraints.NotBlank;

public class CreateVanForm {
    @NotBlank
    private Ride ride;

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }
}
