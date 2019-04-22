package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT password FROM user WHERE username = :username")
    String findPasswordbyName(@Param("username") String username);

    @Query("SELECT role FROM user WHERE username = :username")
    String findRolebyName(@Param("username") String username);

    @Query("SELECT ride_id FROM user WHERE username = :username")
    Integer findRideIDbyName(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("UPDATE user SET ride_id = :rideid where username = :name")
    void assignUsertoRide(@Param("rideid") Integer rideid, @Param("name") String name);
}
