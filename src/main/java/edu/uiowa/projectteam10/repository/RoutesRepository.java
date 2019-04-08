package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoutesRepository extends JpaRepository<Route, String> {
//    @Query("SELECT startPlace, endPlace, distance FROM routes")
//    Iterable<Route> getRouteInfo();
//    @Query("SELECT rides.startTime, rides.endTime, rides.driver, routes.startPlace, routes.endPlace, routes.distance, routes.routeName " +
//            "FROM Route routes\n" +
//           "RIGHT JOIN routes.rides rides ON rides.routeId = routes.routeId")
//    List<String> RightJoinRidesRoute();

}
