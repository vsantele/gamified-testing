package be.thibber.gamification.test;

import be.thibber.gamification.City;
import be.thibber.gamification.Coords;
import be.thibber.gamification.Road;
import be.thibber.gamification.building.Parking;
import be.thibber.gamification.building.Building;
import be.thibber.gamification.building.House;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class CityTest {

	@Test
	public void constructorInitializationTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    assertNotNull(city);
	}

	@Test
	public void addBuildingValidBuildingTest() {
	    List<Building> buildings = new ArrayList<>();
	    City city = new City(buildings, new ArrayList<>());
	    Building building = new House("123 Street", 100.0, 2);
	    city.addBuilding(building);
	    assertEquals(1, buildings.size());
	    assertEquals(building, buildings.get(0));
	}

	@Test
	public void removeBuildingBuildingExistsTest() {
	    Building building = new House("123 Street", 50.0, 2);
	    List<Building> buildings = new ArrayList<>();
	    buildings.add(building);
	    City city = new City(buildings, new ArrayList<>());
	    boolean result = city.removeBuilding(building);
	    assertTrue(result);
	    assertEquals(0, buildings.size());
	}

	@Test
	public void removeBuildingBuildingDoesNotExistTest() {
	    Building building = new House("123 Fake Street", 50.0, 2);
	    City city = new City(new ArrayList<>(), new ArrayList<>());
	    boolean result = city.removeBuilding(building);
	    assertFalse(result);
	}

	@Test
	public void getBuildingsGroundSurfaceTest() {
	    List<Building> buildings = new ArrayList<>();
	    House house1 = new House("Address1", 20.0, 1);
	    Parking parking1 = new Parking("Address2", 30.0, 2);
	    buildings.add(house1);
	    buildings.add(parking1);
	    City city = new City(buildings, new ArrayList<>());
	    double totalSurface = city.getBuildingsGroundSurface();
	    assertEquals(50.0, totalSurface, 0.0);
	}


	@Test
	public void countBuildingByTypeNoBuildingsPresentTest() {
	    City city = new City(Collections.emptyList(), Collections.emptyList());
	    int result = city.countBuildingByType(Building.class);
	    assertEquals(0, result);
	}

	@Test
	public void countBuildingByTypeNoMatchingTypePresentTest() {
	    Building house1 = new House("House1", 120.5, 200.0);
	    Building house2 = new House("House2", 100.0, 180.0);
	    City city = new City(Arrays.asList(house1, house2), Collections.emptyList());
	    int result = city.countBuildingByType(Parking.class);
	    assertEquals(0, result);
	}

	@Test
	public void countBuildingByTypeOneMatchingTypePresentTest() {
	    Building house = new House("House1", 120.5, 200.0);
	    Building parking = new Parking("Parking1", 300.0, 50);
	    City city = new City(Arrays.asList(house, parking), Collections.emptyList());
	    int result = city.countBuildingByType(Parking.class);
	    assertEquals(1, result);
	}

	@Test
	public void countBuildingByTypeMultipleMatchingTypesPresentTest() {
	    Building house = new House("House1", 120.5, 200.0);
	    Building parking1 = new Parking("Parking1", 300.0, 50);
	    Building parking2 = new Parking("Parking2", 400.0, 60);
	    Building parking3 = new Parking("Parking3", 500.0, 70);
	    City city = new City(Arrays.asList(house, parking1, parking2, parking3), Collections.emptyList());
	    int result = city.countBuildingByType(Parking.class);
	    assertEquals(3, result);
	}

	@Test
	public void countBuildingByTypeAllBuildingsOfSameTypeTest() {
	    Building parking1 = new Parking("Parking1", 300.0, 50);
	    Building parking2 = new Parking("Parking2", 400.0, 60);
	    Building parking3 = new Parking("Parking3", 500.0, 70);
	    City city = new City(Arrays.asList(parking1, parking2, parking3), Collections.emptyList());
	    int result = city.countBuildingByType(Parking.class);
	    assertEquals(3, result);
	}

	@Test
	public void countBuildingByTypeSuperclassTypeGivenTest() {
	    Building house = new House("House1", 120.5, 200.0);
	    Building parking = new Parking("Parking1", 300.0, 50);
	    City city = new City(Arrays.asList(house, parking), Collections.emptyList());
	    int result = city.countBuildingByType(Building.class);
	    assertEquals(2, result);
	}

	@Test
	public void countBuildingByTypeEmptyTypeGivenTest() {
	    City city = new City(Collections.emptyList(), Collections.emptyList());
	    int result = city.countBuildingByType(Building.class);
	    assertEquals(0, result);
	}


	@Test
	public void addRoadWhenRoadIsAddedTest() {
	    List<Road> roads = new ArrayList<>();
	    List<Building> buildings = new ArrayList<>();
	    City city = new City(buildings, roads);
	    List<Coords> coords = Arrays.asList(new Coords(0, 0), new Coords(3, 4));
	    Road road = new Road("Main Road", coords, new ArrayList<>());
	    city.addRoad(road);
	    assertEquals(1, roads.size());
	    assertTrue(roads.contains(road));
	}

	@Test
	public void removeRoadWhenRoadExistsTest() {
	    List<Road> roads = new ArrayList<>();
	    List<Building> buildings = new ArrayList<>();
	    City city = new City(buildings, roads);
	    Road road = new Road("Main Road", Arrays.asList(new Coords(0, 0), new Coords(3, 4)), new ArrayList<>());
	    roads.add(road);
	    boolean result = city.removeRoad(road);
	    assertTrue(result);
	    assertFalse(roads.contains(road));
	}

	@Test
	public void removeRoadWhenRoadDoesNotExistTest() {
	    List<Road> roads = new ArrayList<>();
	    List<Building> buildings = new ArrayList<>();
	    City city = new City(buildings, roads);
	    Road road = new Road("Main Road", Arrays.asList(new Coords(0, 0), new Coords(3, 4)), new ArrayList<>());
	    boolean result = city.removeRoad(road);
	    assertFalse(result);
	}

	@Test
	public void addBuildingWhenBuildingIsAddedTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    Building building = new House("123 Street", 200, 3);
	    city.addBuilding(building);
	    assertEquals(1, buildings.size());
	    assertTrue(buildings.contains(building));
	}

	@Test
	public void removeBuildingWhenBuildingExistsTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    Building building = new House("123 Street", 200, 3);
	    buildings.add(building);
	    boolean result = city.removeBuilding(building);
	    assertTrue(result);
	    assertFalse(buildings.contains(building));
	}

	@Test
	public void removeBuildingWhenBuildingDoesNotExistTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    Building building = new House("123 Street", 200, 3);
	    boolean result = city.removeBuilding(building);
	    assertFalse(result);
	}

	@Test
	public void getBuildingsGroundSurfaceWhenBuildingsExistTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    buildings.add(new House("Building1", 100.5, 2));
	    buildings.add(new House("Building2", 200.3, 3));
	    double result = city.getBuildingsGroundSurface();
	    assertEquals(300.8, result, 0.001);
	}

	@Test
	public void getBuildingsGroundSurfaceWhenNoBuildingsTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    double result = city.getBuildingsGroundSurface();
	    assertEquals(0, result, 0.001);
	}

	@Test
	public void countBuildingByTypeWhenBuildingsOfSameTypeExistTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    buildings.add(new Parking("Parking1", 300, 1));
	    buildings.add(new Parking("Parking2", 400, 1));
	    buildings.add(new House("House1", 200, 2));
	    int result = city.countBuildingByType(Parking.class);
	    assertEquals(2, result);
	}

	@Test
	public void countBuildingByTypeWhenNoBuildingsOfTypeExistTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    buildings.add(new House("House1", 200, 2));
	    buildings.add(new House("House2", 250, 3));
	    int result = city.countBuildingByType(Parking.class);
	    assertEquals(0, result);
	}

	@Test
	public void getAvailableParkingSlotsCountWhenParkingExistsTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    buildings.add(new Parking("Parking1", 300, 50));
	    buildings.add(new Parking("Parking2", 400, 150));
	    int result = city.getAvailableParkingSlotsCount();
	    assertEquals(-200, result);
	}

	@Test
	public void getParkingsUsagePercentageWhenParkingExistsTest() {
	    List<Building> buildings = new ArrayList<>();
	    List<Road> roads = new ArrayList<>();
	    City city = new City(buildings, roads);
	    buildings.add(new Parking("Parking1", 300, 100));
	    buildings.add(new Parking("Parking2", 400, 150));
	    double result = city.getParkingsUsagePercentage();
	    // Assuming full usage
	    assertEquals(100, result, 0.001);
	}

	@Test
	public void getAverageRoadLengthWhenRoadsExistTest() {
	    List<Road> roads = new ArrayList<>();
	    List<Building> buildings = new ArrayList<>();
	    City city = new City(buildings, roads);
	    roads.add(new Road("Road1", Arrays.asList(new Coords(0, 0), new Coords(3, 4)), new ArrayList<>()) {

	        @Override
	        public double getLength() {
	            return 100;
	        }
	    });
	    roads.add(new Road("Road2", Arrays.asList(new Coords(0, 0), new Coords(3, 4)), new ArrayList<>()) {

	        @Override
	        public double getLength() {
	            return 200;
	        }
	    });
	    double result = city.getAverageRoadLength();
	    assertEquals(150, result, 0.001);
	}

	@Test
	public void getAverageRoadLengthWhenNoRoadsTest() {
	    List<Road> roads = new ArrayList<>();
	    List<Building> buildings = new ArrayList<>();
	    City city = new City(buildings, roads);
	    Exception exception = null;
	    try {
	        city.getAverageRoadLength();
	    } catch (ArithmeticException e) {
	        exception = e;
	    }
	    assertNotNull(exception);
	}

}
