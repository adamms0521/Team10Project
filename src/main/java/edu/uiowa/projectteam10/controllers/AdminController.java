package edu.uiowa.projectteam10.controllers;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.forms.CreateRouteForm;
import edu.uiowa.projectteam10.forms.CreateVanForm;
import edu.uiowa.projectteam10.services.RidesService;
import edu.uiowa.projectteam10.services.RouteService;
import edu.uiowa.projectteam10.services.VanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
public class AdminController extends WebMvcConfigurerAdapter {
    @Autowired
    private RidesService ridesService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private VanService vanService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin");
    }
<<<<<<< HEAD

    @GetMapping("/createride")

>>>>>>> 03371e11802899f776a1151e0714f6f795c81b87
    public String createRide(Model model){
        model.addAttribute("createRideForm", new CreateRideForm());
        return "createride";
    }

    @PostMapping("/admin/createride")
    public String postCreateRide(@Valid CreateRideForm rideForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createride";
        }
        ridesService.saveForm(rideForm);
        return "redirect:/admin";
    }

    @GetMapping("/admin/createroute")
    private String createRoute(Model model){
        model.addAttribute("createRouteForm", new CreateRouteForm());
        return "createroute";
    }

    @PostMapping("/admin/createroute")
    public String postCreateRoute(@Valid CreateRouteForm routeForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createroute";
        }
        routeService.saveForm(routeForm);
        return "redirect:/admin";
    }

    @GetMapping("/admin/createvan")
    public String createVan(Model model){
        model.addAttribute("createVanForm", new CreateVanForm());
        return "createvan";
    }

    @PostMapping("/admin/createvan")
    public String postCreateVan(@Valid CreateVanForm vanForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createvan";
        }
        vanService.saveForm(vanForm);
        return "redirect:/admin";
    }
}
