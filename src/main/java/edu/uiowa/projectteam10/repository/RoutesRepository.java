package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoutesRepository extends JpaRepository<Route, String> {
    @Query("SELECT distance FROM routes WHERE route_name = :route_name")
    Double getDistanceByName(@Param("route_name") String route_name);
}
