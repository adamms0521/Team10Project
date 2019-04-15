package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RidesRepository extends JpaRepository<Ride, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE rides SET driver = :name where rideid = :rideid")
    void assignDriver(@Param("rideid") Integer rideid, @Param("name") String name);
}
