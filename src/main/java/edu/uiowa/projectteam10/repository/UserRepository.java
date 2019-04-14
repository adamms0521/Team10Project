package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT password FROM user WHERE name = :name")
    String findPasswordbyName(@Param("name") String name);

    @Query("SELECT role FROM user WHERE name = :name")
    String findRolebyName(@Param("name") String name);
}
