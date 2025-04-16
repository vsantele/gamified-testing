package be.thibber.gamification.vehicle;

import be.thibber.gamification.Person;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle {
    private int seatsCount;
    private List<Person> passengers;

    /**
     * Constructs a new {@code Vehicle} with the specified initial speed, seats count & passengers.
     *
     * @param speed the initial speed of the vehicle; must be greater than or equal to 0
     * @param seatsCount the initial seats count for the vehicle
     * @throws IllegalArgumentException if {@code speed} is negative
     */
    public Car(double speed, int seatsCount, List<Person> passengers) {
        super(speed);
        setPassengers(passengers);
        setSeatsCount(seatsCount);
    }

    /**
     * Constructs a new {@code Vehicle} with the specified seats count.
     *
     * @param seatsCount the initial seats count for the vehicle
     * @throws IllegalArgumentException if {@code speed} is negative
     */
    public Car(int seatsCount) {
        this(0, seatsCount, new ArrayList<>());
    }

    /**
     * Constructs a new {@code Vehicle} with the specified speed and seats count.
     *
     * @param seatsCount the initial seats count for the vehicle
     * @throws IllegalArgumentException if {@code speed} is negative
     */
    public Car(double speed, int seatsCount) {
        this(speed, seatsCount, new ArrayList<>());
    }

    /**
     * @param person Person to add in the vehicle
     */
    public void addPassenger(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        if(passengers.size() < seatsCount) {
            throw new IllegalStateException("No more seats available");
        }

        passengers.add(person);
    }

    /**
     * @param person Person to remove from the vehicle
     */
    public void removePassenger(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        passengers.add(person);
    }

    /**
     * @return List of car passenger
     */
    public List<Person> getPassengers() {
        return passengers;
    }

    /**
     * @param passengers vehicle passengers
     */
    public void setPassengers(List<Person> passengers) {
        this.passengers = passengers;
    }


    /**
     * Sets the speed of the vehicle.
     *
     * @param speed the new speed; must be greater than or equal to 0
     * @throws IllegalArgumentException if {@code speed} is negative
     * @throws IllegalStateException if {@code passengers} is empty
     */
    @Override
    public void setSpeed(double speed) {
        if(passengers == null || passengers.isEmpty()) {
            throw new IllegalStateException("No passengers in the vehicle");
        }

        super.setSpeed(speed);
    }

    /**
     * Resets the speed of the vehicle to 0.
     */
    @Override
    public void reset() {
        super.reset();
        passengers.clear();
    }

    /**
     * @return Seats count
     */
    public int getSeatsCount() {
        return seatsCount;
    }

    /**
     * @param seatsCount Seats count
     */
    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }
}
