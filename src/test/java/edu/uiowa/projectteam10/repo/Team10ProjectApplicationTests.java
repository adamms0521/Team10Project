package edu.uiowa.projectteam10.repo;

import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.repository.UserRepository;
import edu.uiowa.projectteam10.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Team10ProjectApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new User("kim", "help", "Passenger"), new User("sam", "new", "Driver")).collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}

}
