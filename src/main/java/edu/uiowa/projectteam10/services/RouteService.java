package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateRouteForm;
import edu.uiowa.projectteam10.model.Route;

import java.util.List;

public interface RouteService {
    Route save(Route route);

    Route saveForm(CreateRouteForm routeForm);

    List<Route> getRoutes();

    List<String> getRouteInfo();
}
