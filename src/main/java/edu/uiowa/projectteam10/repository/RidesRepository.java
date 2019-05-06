package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RidesRepository extends JpaRepository<Ride, Integer> {
    //assign driver to ride
    @Transactional
    @Modifying
    @Query("UPDATE rides SET driver = :name where rideid = :rideid")
    void assignDriver(@Param("rideid") Integer rideid, @Param("name") String name);

    //return route with ride id
    @Query("SELECT routeName FROM rides WHERE rideid = :rideid")
    String getRoutebyRideID(@Param("rideid") Integer rideid);

    //set price to ride
    @Transactional
    @Modifying
    @Query("UPDATE rides SET bill = :bill WHERE rideid = :rideid")
    void updatePrice(@Param("bill") String bill, @Param("rideid") Integer rideid);

    //delete driver from ride
    @Transactional
    @Modifying
    @Query("UPDATE rides SET driver = null WHERE rideid = :ride_id")
    void deleteRideFromDriver(@Param("ride_id") Integer ride_id);
}
