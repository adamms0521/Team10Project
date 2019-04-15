package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT password FROM user WHERE username = :username")
    String findPasswordbyName(@Param("username") String username);

    @Query("SELECT role FROM user WHERE username = :username")
    String findRolebyName(@Param("username") String username);
}
