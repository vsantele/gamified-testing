package be.thibber.gamification.building;

import be.thibber.gamification.vehicle.Vehicle;
import be.thibber.gamification.exceptions.FullParkingException;

import java.util.ArrayList;
import java.util.List;

public class Parking extends Building {
    private int capacity;
    private final List<Vehicle> vehicles;

    /**
     * @param name Name of the parking
     * @param surface Surface of the parking
     * @param capacity Capacity of parking
     * @param vehicles Default vehicles in the parking
     */
    public Parking(String name, double surface, int capacity, List<Vehicle> vehicles) {
        super(name, surface, 1);

        this.vehicles = vehicles;
        setCapacity(capacity);
    }

    /**
     * @param name Name of the parking
     * @param surface Surface of the parking
     * @param capacity Capacity of parking
     */
    public Parking(String name, double surface, int capacity){
        this(name, surface, capacity, new ArrayList<>());
    }

    /**
     * @return Parking capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity Parking capacity
     */
    public void setCapacity(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("Capacity must be greater than or equal to 0");
        }
        
        this.capacity = capacity;
    }

    /**
     * @param vehicle Vehicle to add in the parking
     * @return {@code true} if the vehicle is added, {@code false} otherwise
     * @throws FullParkingException when parking is full
     */
    public boolean addVehicle(Vehicle vehicle) throws FullParkingException {
        if(isFull()) {
            throw new FullParkingException("Parking is full");
        }

        return vehicles.add(vehicle);
    }

    /**
     * @param vehicle Vehicle to remove
     * @return {@code true} if the vehicle is added, {@code false} otherwise
     */
    public boolean removeVehicle(Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }

    /**
     * @return {@code true} if the parking is full, {@code false} otherwise
     */
    public boolean isFull(){
        return vehicles.size() >= capacity;
    }

    /**
     * @return {@code true} if the parking is empty, {@code false} otherwise
     */
    public boolean isEmpty(){
        return vehicles.isEmpty();
    }

    /**
     * @return Number of available spots
     */
    public int getAvailableSpots() {
        return capacity - vehicles.size();
    }
}
