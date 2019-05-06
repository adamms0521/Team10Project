package edu.uiowa.projectteam10.repo;

import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.model.Route;
import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.repository.RidesRepository;
import edu.uiowa.projectteam10.repository.UserRepository;
import edu.uiowa.projectteam10.services.RidesService;
import edu.uiowa.projectteam10.repository.RoutesRepository;

import edu.uiowa.projectteam10.services.RouteService;
import edu.uiowa.projectteam10.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Team10ProjectApplicationTests {

	@Autowired
	private UserService service;
	@Autowired
	private RidesService ridesService;
	@Autowired
	private RouteService routeService;

	@MockBean
	private UserRepository repository;
	@MockBean
	private RidesRepository ridesRepository;
	@MockBean
	private RoutesRepository routesRepository;
	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new User("kim", "help", "Passenger"), new User("sam", "new", "Driver")).collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}

	@Test
	public void getRidesTest(){
		when(ridesRepository.findAll()).thenReturn(Stream.of(new Ride("route", "13:00", "15:00"), new Ride("otherRoute", "8:00", "8:30")).collect(Collectors.toList()));
		assertEquals(2, ridesService.getRides().size());
	}
	@Test
	public void getRoutesTest(){
		when(routesRepository.findAll()).thenReturn(Stream.of(new Route("route", "Iowa City", "Cedar Rapids", 35.0), new Route("otherRoute", "Cedar Rapids", "Iowa City", 35.0)).collect(Collectors.toList()));
		assertEquals(2, routeService.getRoutes().size());
	}

	@Test
	public void getRidesRoute(){
		when(ridesRepository.getRoutebyRideID(61)).thenReturn("Highway");
		assertEquals("Highway", ridesService.getRoutebyRide(61));
	}

	@Test
	public void getUsersRole(){
		when(repository.findRolebyName("k2")).thenReturn("Passenger");
		assertEquals("Passenger", service.getRole("k2"));
	}

	@Test
	public void getUsersRide(){
		when(repository.findRideIDbyName("k2")).thenReturn(48);
		assertEquals((Integer) 48, service.getRideIdFromUser("k2"));
	}
}
