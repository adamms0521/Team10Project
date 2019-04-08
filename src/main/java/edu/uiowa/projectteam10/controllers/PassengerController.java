package edu.uiowa.projectteam10.controllers;

import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.services.RidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    private RidesService rideService;

    @GetMapping("/rides")
    public String ridesPage(Model model){
        List<Ride> rides = this.rideService.getRides();
        model.addAttribute("availableRides", rides);
        return "rides";
    }
    @GetMapping("/passenger")
    public String passengerPage(){
        return "passenger";
    }

}
