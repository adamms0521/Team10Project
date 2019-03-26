package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, String> {
    @Query("SELECT password FROM user WHERE name = :name")
    String findPasswordbyName(@Param("name") String name);
}
