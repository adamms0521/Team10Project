package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.transaction.annotation.Transactional;

public interface RidesRepository extends JpaRepository<Ride, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE rides SET driver = :name where rideid = :rideid")
    void assignDriver(@Param("rideid") Integer rideid, @Param("name") String name);

    @Query("SELECT routeName FROM rides WHERE rideid = :rideid")
    String getRoutebyRideID(@Param("rideid") Integer rideid);

    @Transactional
    @Modifying
    @Query("UPDATE rides SET bill = :price WHERE route_name = :route_name")
    void updatePrice(@Param("price") String price, @Param("route_name") String route_name);
}
