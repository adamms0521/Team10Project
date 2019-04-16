package edu.uiowa.projectteam10.controllers;

import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.model.Route;
import edu.uiowa.projectteam10.services.RidesService;
import edu.uiowa.projectteam10.services.RouteService;
import edu.uiowa.projectteam10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    private RidesService rideService;
    @Autowired
    private UserService userService;
    @Autowired
    private RouteService routeService;

    @GetMapping("/passenger/routes/rides")
    public String ridesPage(@RequestParam("Selection") String routeName, Model model){
        if(!checkAccess()){
            return "redirect:/login";
        }
        List<Ride> rides = this.rideService.getRidesByRoute(routeName);
        model.addAttribute("availableRides", rides);
        return "rides";
    }
    @GetMapping("/passenger")
    public String passengerPage() {
        if(!checkAccess()){
            return "redirect:/login";
        }
        return "passenger";
    }

    @GetMapping("/passenger/routes")
    public String routesPage(Model model){
        if(!checkAccess()){
            return "redirect:/login";
        }
        List<Route> availableRoutes = this.routeService.getRoutes();
        model.addAttribute("availableRoutes", availableRoutes);
        return "routes";
    }
    private boolean checkAccess(){
        try {
            String currentUser = userService.getCurrentUser().getUserName();
            if (userService.getRole(currentUser).equals("Passenger")) {
                return true;
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
