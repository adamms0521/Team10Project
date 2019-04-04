package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.Route;
import edu.uiowa.projectteam10.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RidesRepository extends JpaRepository<Ride, Integer> {
//    @Query("SELECT rides.startTime, rides.endTime, rides.driver, routes.startPlace, routes.endPlace, routes.distance, routes.routeName FROM ride rides LEFT JOIN route routes ON ride.routeName = route.routeName")
//    List<String> LeftJoinRidesRoute();
//    @Query("SELECT rides.startTime, rides.endTime, rides.driver, routes.startPlace, routes.endPlace, routes.distance, routes.routeName FROM rides\n" +
//            "RIGHT JOIN routes ON rides.routeId = routes.routeId")
//    List<String> RightJoinRidesRoute();
//    @Query("SELECT startTime, endTime, routeName, driver FROM rides")
//    Iterable<Ride> getRideInfo();

}
