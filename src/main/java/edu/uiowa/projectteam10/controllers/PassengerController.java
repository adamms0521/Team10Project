package edu.uiowa.projectteam10.controllers;

import edu.uiowa.projectteam10.forms.BillingForm;
import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.model.Route;
import edu.uiowa.projectteam10.services.RidesService;
import edu.uiowa.projectteam10.services.RouteService;
import edu.uiowa.projectteam10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
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
        Integer rideID = userService.getRideIdFromUser(userService.getCurrentUser().getUserName());
        List<Ride> rides = this.rideService.getRidesByRoute(routeName, rideID);
        model.addAttribute("availableRides", rides);
        return "rides";
    }

    @PostMapping("/passenger/routes/rides")
    public String updatePassenger(@RequestParam("RideSelection") Integer rideID){
        userService.assignRideToUser(rideID, userService.getCurrentUser().getUserName());
        return "redirect:/passenger";
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

    @GetMapping("/passenger/myRides")
    public String myRidesPage(Model model){
        if(!checkAccess()){
            return "redirect:/login";
        }
        Integer rideID = userService.getRideIdFromUser(userService.getCurrentUser().getUserName());
        List<Ride> passengerRides = this.rideService.getRidesByID(rideID);
        model.addAttribute("passengerRides", passengerRides);
        return "myRides";
    }

    @GetMapping("/passenger/billing")
    public String processBilling(@RequestParam("RideRemoval") Integer rideID, Model model){
        List<Ride> currentRide = rideService.getRidesByID(rideID);
        String dayPriceString = currentRide.get(0).getBill();

        float dayPrice = Float.parseFloat(dayPriceString.substring(1));
        Date pastDate = userService.getRideDateFromCurrentUser(userService.getCurrentUser().getUserName());
        Date currentDate = new Date();
        int days = currentDate.getDay() - pastDate.getDay();
        float totalPrice = dayPrice*(days+1);

        BillingForm billingForm = new BillingForm(pastDate, currentDate, dayPrice, totalPrice);
        model.addAttribute("billingInfo", billingForm);

        return "billing";
    }

    @PostMapping("/passenger/billing")
    public String unassignRide(){
        if(!checkAccess()){
            return "redirect:/login";
        }
        userService.deleteRideFromUser(userService.getCurrentUser().getUserName());
        return "redirect:/passenger";
    }

    private boolean checkAccess(){
        try {
            String currentUser = userService.getCurrentUser().getUserName();
            if (userService.getRole(currentUser).equals("Passenger")) {
                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }
}
