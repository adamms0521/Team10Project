package edu.uiowa.projectteam10.forms;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class CreateRideForm {

    @NotBlank
    private String startTime;

    @NotBlank
    private String endTime;

    @NotNull
    private String routeName;


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
