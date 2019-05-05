package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface UserRepository extends JpaRepository<User, String> {
    //return password by username
    @Query("SELECT password FROM user WHERE username = :username")
    String findPasswordbyName(@Param("username") String username);
    //return role by username
    @Query("SELECT role FROM user WHERE username = :username")
    String findRolebyName(@Param("username") String username);
    //return rideid by username
    @Query("SELECT ride_id FROM user WHERE username = :username")
    Integer findRideIDbyName(@Param("username") String username);
    //assign user to ride
    @Transactional
    @Modifying
    @Query("UPDATE user SET ride_id = :rideid where username = :name")
    void assignUsertoRide(@Param("rideid") Integer rideid, @Param("name") String name);
    //assign start date to ride
    @Transactional
    @Modifying
    @Query("UPDATE user set ride_date = :rideDate where username = :name")
    void assignRideStartDate(@Param("rideDate") Date rideDate, @Param("name") String name);
    //delete ride from user
    @Transactional
    @Modifying
    @Query("UPDATE user SET ride_id = 0 where username = :name")
    void deleteRideFromUser(@Param("name") String username);
    //return name by username
    @Query("SELECT name FROM user WHERE username = :username")
    String getNameByUserName(@Param("username") String username);
    //get ridedate by username
    @Query("SELECT ride_date FROM user WHERE username = :username")
    Date getUserRideDate(@Param("username") String username);
    //reset password to username
    @Transactional
    @Modifying
    @Query("UPDATE user SET password = :password where username = :username")
    void updatePassword(@Param("username") String username, @Param("password") String password);
}
