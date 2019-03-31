package edu.uiowa.projectteam10.forms;

import org.hibernate.validator.constraints.NotBlank;

public class CreateRideForm {
    @NotBlank
    private String startPlace;

    @NotBlank
    private String endPlace;

    @NotBlank
    private String startTime;

    @NotBlank
    private String endTime;

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
}
