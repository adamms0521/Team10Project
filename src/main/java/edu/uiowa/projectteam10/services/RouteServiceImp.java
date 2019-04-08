package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateRouteForm;
import edu.uiowa.projectteam10.model.Route;
import edu.uiowa.projectteam10.repository.RoutesRepository;
import org.springframework.stereotype.Service;

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

    @Override
    public Route saveForm(CreateRouteForm routeForm) {
        Route route = new Route();
        route.setStartPlace(routeForm.getStartPlace());
        route.setEndPlace(routeForm.getEndPlace());
        route.setRouteName(routeForm.getRouteName());
        route.setDistance(routeForm.getDistance());
        return save(route);
    }

    @Override
    public List<String> getRouteInfo() {
       // return routesRepository.RightJoinRidesRoute();
        return null;
    }
}
