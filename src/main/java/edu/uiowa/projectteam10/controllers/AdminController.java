package edu.uiowa.projectteam10.controllers;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.services.RidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
public class AdminController extends WebMvcConfigurerAdapter {
    private RidesService ridesService;

    @Autowired
    public void setRidesService(RidesService ridesService) {
        this.ridesService = ridesService;
    }

    @GetMapping("/createride")
    public String createRide(Model model){
        model.addAttribute("createrideForm", new CreateRideForm());
        return "createride";
    }

    @PostMapping("/createride")
    public String postCreate(@Valid CreateRideForm rideForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createride";
        }
        ridesService.saveForm(rideForm);
        return "admin";
    }

}
