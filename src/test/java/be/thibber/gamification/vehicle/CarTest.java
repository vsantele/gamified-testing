package be.thibber.gamification.vehicle;

import be.thibber.gamification.Coords;
import be.thibber.gamification.Road;
import be.thibber.gamification.vehicle.Car;
import be.thibber.gamification.vehicle.Vehicle;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarTest {

	@Test
	public void constructorValidArgumentsTest() {
	    Coords point1 = new Coords(0, 0);
	    Coords point2 = new Coords(10, 10);
	    List<Coords> points = new ArrayList<>();
	    points.add(point1);
	    points.add(point2);
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("MainRoad", points, vehicles);
	    assertEquals("MainRoad", road.getName());
	    assertEquals(points, road.getPoints());
	    assertEquals(vehicles, road.getVehicles());
	}

	@Test
	public void getNameValidScenarioTest() {
	    List<Coords> points = new ArrayList<>();
	    points.add(new Coords(0, 0));
	    points.add(new Coords(10, 10));
	    Road road = new Road("MainRoad", points, new ArrayList<>());
	    assertEquals("MainRoad", road.getName());
	}

	@Test
	public void setNameValidScenarioTest() {
	    List<Coords> points = new ArrayList<>();
	    points.add(new Coords(0, 0));
	    points.add(new Coords(10, 10));
	    Road road = new Road("MainRoad", points, new ArrayList<>());
	    road.setName("NewRoad");
	    assertEquals("NewRoad", road.getName());
	}

	@Test
	public void getVehiclesEmptyListTest() {
	    List<Coords> points = new ArrayList<>();
	    points.add(new Coords(0, 0));
	    points.add(new Coords(10, 10));
	    Road road = new Road("MainRoad", points, new ArrayList<>());
	    assertTrue(road.getVehicles().isEmpty());
	}



}
