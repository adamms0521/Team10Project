package edu.uiowa.projectteam10.controllers;

import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.services.RidesService;
import edu.uiowa.projectteam10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DriverController {
    @Autowired
    private RidesService rideService;
    @Autowired
    private UserService userService;

    @GetMapping("/driver")
    public String driverPage(Model model){
        List<Ride> rides = this.rideService.getEmptyRides();
        model.addAttribute("unselectRides", rides);
        /*UserDetails userLogged = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();*/
        return "driver";
    }
    @PostMapping("/driver")
    public String update(@RequestParam("selection") Integer selection, Model model, HttpServletRequest request){
        rideService.assignDriver(selection, userService.getCurrentUser().getUserName());
        return "rides";
    }
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public  String currentUserName(Authentication authentication){
        return authentication.getName(); }

}
