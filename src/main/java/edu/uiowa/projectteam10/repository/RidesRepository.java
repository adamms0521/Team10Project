package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.Route;
import edu.uiowa.projectteam10.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface RidesRepository extends JpaRepository<Ride, Integer> {

}
