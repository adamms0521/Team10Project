package edu.uiowa.projectteam10.controllers;

import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.model.Route;
import edu.uiowa.projectteam10.services.RidesService;
import edu.uiowa.projectteam10.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    private RidesService rideService;

    @Autowired
    private RouteService routeService;

    @GetMapping("/passenger/rides")
    public String ridesPage(Model model){
        List<Ride> rides = this.rideService.getRides();
        model.addAttribute("availableRides", rides);
        return "rides";
    }
    @GetMapping("/passenger")
    public String passengerPage(){
        return "passenger";
    }

    @GetMapping("/passenger/routes")
    public String routesPage(Model model){
        List<Route> availableRoutes = this.routeService.getRoutes();
        model.addAttribute("availableRoutes", availableRoutes);
        return "routes";
    }
}
