package edu.uiowa.projectteam10.repository;

import edu.uiowa.projectteam10.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}