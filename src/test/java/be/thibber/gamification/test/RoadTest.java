package be.thibber.gamification.test;

import be.thibber.gamification.Coords;
import be.thibber.gamification.Road;
import be.thibber.gamification.vehicle.Car;
import be.thibber.gamification.vehicle.Vehicle;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class RoadTest {

	@Test
	public void constructorValidParametersTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(1, 1));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Test Road", coords, vehicles);
	    assertNotNull(road);
	    assertEquals("Test Road", road.getName());
	    assertEquals(vehicles, road.getVehicles());
	    assertEquals(coords, road.getPoints());
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorInvalidCoordsTest() {
	    List<Coords> coords = new ArrayList<>();
	    List<Vehicle> vehicles = new ArrayList<>();
	    new Road("Invalid Road", coords, vehicles);
	}

	@Test
	public void getNameValidScenarioTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(1, 1));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Main Road", coords, vehicles);
	    assertEquals("Main Road", road.getName());
	}

	@Test
	public void setNameValidScenarioTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(1, 1));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Old Name", coords, vehicles);
	    road.setName("New Name");
	    assertEquals("New Name", road.getName());
	}

	@Test
	public void getVehiclesValidScenarioTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(1, 1));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Vehicle Road", coords, vehicles);
	    assertEquals(vehicles, road.getVehicles());
	}

	@Test
	public void addVehicleValidScenarioTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(1, 1));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Add Vehicle Road", coords, vehicles);
	    Vehicle vehicle = new Car(50);
	    road.addVehicle(vehicle);
	    assertTrue(road.getVehicles().contains(vehicle));
	    assertEquals(1, road.getVehicles().size());
	}

	@Test
	public void removeVehicleValidScenarioTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(1, 1));
	    Vehicle vehicle = new Car(30);
	    List<Vehicle> vehicles = new ArrayList<>(Arrays.asList(vehicle));
	    Road road = new Road("Remove Vehicle Road", coords, vehicles);
	    road.removeVehicle(vehicle);
	    assertFalse(road.getVehicles().contains(vehicle));
	    assertEquals(0, road.getVehicles().size());
	}

	@Test
	public void removeVehicleNotPresentScenarioTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(1, 1));
	    Vehicle vehicle = new Car(30);
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Remove Non-Present Vehicle Road", coords, vehicles);
	    road.removeVehicle(vehicle);
	    assertFalse(road.getVehicles().contains(vehicle));
	    assertEquals(0, road.getVehicles().size());
	}

	@Test
	public void getPointsValidScenarioTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(1, 1));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Point Road", coords, vehicles);
	    assertEquals(coords, road.getPoints());
	}

	@Test
	public void appendPointValidScenarioTest() {
	    List<Coords> coords = new ArrayList<>(Arrays.asList(new Coords(0, 0), new Coords(1, 1)));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Append Point Road", coords, vehicles);
	    Coords newPoint = new Coords(2, 2);
	    road.appendPoint(newPoint);
	    assertEquals(3, road.getPoints().size());
	    assertTrue(road.getPoints().contains(newPoint));
	}

	@Test(expected = IllegalArgumentException.class)
	public void appendPointNullScenarioTest() {
	    List<Coords> coords = new ArrayList<>(Arrays.asList(new Coords(0, 0), new Coords(1, 1)));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Append Null Point Road", coords, vehicles);
	    road.appendPoint(null);
	}

	@Test
	public void getLengthValidScenarioTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(3, 4));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Length Road", coords, vehicles);
	    assertEquals(5.0, road.getLength(), 0.0001);
	}

	@Test
	public void getMaximumSegmentLengthValidScenarioTest() {
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(3, 4), new Coords(6, 8));
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Max Segment Road", coords, vehicles);
	    assertEquals(5.0, road.getMaximumSegmentLength(), 0.0001);
	}

	@Test
	public void moveValidOffsetsTest() {
	    Coords point1 = new Coords(0, 0);
	    Coords point2 = new Coords(3, 4);
	    List<Coords> coords = Arrays.asList(point1, point2);
	    List<Vehicle> vehicles = new ArrayList<>();
	    Road road = new Road("Move Road", coords, vehicles);
	    road.move(1.0, 2.0);
	    assertEquals(1.0, point1.getX(), 0.0001);
	    assertEquals(2.0, point1.getY(), 0.0001);
	    assertEquals(4.0, point2.getX(), 0.0001);
	    assertEquals(6.0, point2.getY(), 0.0001);
	}

}
