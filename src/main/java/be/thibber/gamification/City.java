package be.thibber.gamification;

import be.thibber.gamification.building.Building;
import be.thibber.gamification.building.Parking;

import java.util.List;

public class City {
    private final List<Building> buildings;
    private final List<Road> roads;

    public City(List<Building> buildings, List<Road> roads) {
        this.buildings = buildings;
        this.roads = roads;
    }

    /**
     * @param road Road to add
     */
    public void addRoad(Road road) {
        roads.add(road);
    }

    /**
     * @param road Road to remove
     * @return {@code true} if the road is removed, {@code false} otherwise
     */
    public boolean removeRoad(Road road) {
        return roads.remove(road);
    }

    /**
     * @param building Add building to the city
     */
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    /**
     * @param building Building to remove
     * @return {@code true} if the building is removed, {@code false} otherwise
     */
    public boolean removeBuilding(Building building) {
        return buildings.remove(building);
    }

    /**
     * @return Sum all building surfaces of the city
     */
    public double getBuildingsGroundSurface(){
        double totalSurface = 0;

        for (Building building : buildings) {
            totalSurface += building.getGroundSurface();
        }

        return totalSurface;
    }

    /**
     * Count building from the city by type
     * Usage : {@code city.countBuildingByType(Parking.class)} or {@code city.countBuildingByType(Building.class)}
     * @param type the type of building to count
     * @param <T> Type or subtype of {@code Building}
     * @return the count of buildings of the specified type
     */
    public <T extends Building> int countBuildingByType(Class<T> type) {
        int count = 0;

        for (Building building : buildings) {
            if(type.isInstance(building)) {
                count++;
            }
        }

        return count;
    }

    /**
     * @return Count available parking slots in the whole city
     */
    public int getAvailableParkingSlotsCount(){
        int count = 0;

        for (Building building : buildings) {
            if(building instanceof Parking) {
                count += ((Parking) building).getCapacity();
            }
        }

        return count;
    }

    /**
     * @return Count percentage or parkings usage in the whole city
     */
    public double getParkingsUsagePercentage(){
        double totalCapacity = 0;
        double totalUsed = 0;

        for (Building building : buildings) {
            if(building instanceof Parking p) {
                totalCapacity += p.getCapacity();
                totalUsed += p.getCapacity() - p.getAvailableSpots();
            }
        }

        return (totalUsed / totalCapacity) * 100;
    }

    public double getAverageRoadLength(){
        double avg = 0;

        for (Road road : roads) {
            avg += road.getLength();
        }

        return avg / roads.size();
    }
}
