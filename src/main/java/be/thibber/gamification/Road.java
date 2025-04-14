package be.thibber.gamification;

import be.thibber.gamification.vehicle.Vehicle;

import java.util.List;

public class Road extends PolyLine {
    public String name;
    public List<Vehicle> vehicles;

    public Road(String name, List<Coords> points, List<Vehicle> vehicles) {
        super(points);

        this.vehicles = vehicles;
        setName(name);
    }

    /**
     * @return list of vehicles on the road
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * @param vehicle Vehicle to add on the road
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * @param vehicle vehicle to remove from the road
     */
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    /**
     * @return the name of the road
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the new road name
     */
    public void setName(String name) {
        this.name = name;
    }
}
