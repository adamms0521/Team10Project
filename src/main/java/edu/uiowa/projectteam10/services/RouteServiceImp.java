package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateRouteForm;
import edu.uiowa.projectteam10.model.Route;
import edu.uiowa.projectteam10.repository.RoutesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImp implements RouteService {
    private RoutesRepository routesRepository;

    public RouteServiceImp(RoutesRepository routesRepository){
        this.routesRepository = routesRepository;
    }
    @Override
    public Route save(Route route) {
        routesRepository.save(route);
        return route;
    }
    //save route form
    @Override
    public Route saveForm(CreateRouteForm routeForm) {
        Route route = new Route();
        route.setStartPlace(routeForm.getStartPlace());
        route.setEndPlace(routeForm.getEndPlace());
        route.setRouteName(routeForm.getRouteName());
        route.setDistance(routeForm.getDistance());
        return save(route);
    }

    //return all routes
    @Override
    public List<Route> getRoutes(){
        Iterable<Route> routes = this.routesRepository.findAll();
        List<Route> allroutes = new ArrayList<>();
        for(Route route: routes){
            allroutes.add(route);
        }
        return allroutes;
    }


    @Override
    public Double getDistanceByName(String name) {
        return routesRepository.getDistanceByName(name);
    }
}
