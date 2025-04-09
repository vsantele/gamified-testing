package be.thibber.gamification;

/**
 * The {@code Vehicle} class represents a vehicle with a modifiable speed.
 * It provides methods to accelerate, brake, and reset the vehicle's speed,
 * as well as to check if the vehicle is stopped.
 */
public class Vehicle {
    /**
     * The current speed of the vehicle. Must be greater than or equal to 0.
     */
    private double speed;

    /**
     * Constructs a new {@code Vehicle} with the specified initial speed.
     *
     * @param speed the initial speed of the vehicle; must be greater than or equal to 0
     * @throws IllegalArgumentException if {@code speed} is negative
     */
    public Vehicle(double speed) {
        setSpeed(speed);
    }

    /**
     * Returns the current speed of the vehicle.
     *
     * @return the speed of the vehicle
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the vehicle.
     *
     * @param speed the new speed; must be greater than or equal to 0
     * @throws IllegalArgumentException if {@code speed} is negative
     */
    public void setSpeed(double speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed must be greater than or equal to 0");
        }

        this.speed = speed;
    }

    /**
     * Increases the speed of the vehicle by the specified increment.
     *
     * @param increment the amount to increase the speed; must be positive
     * @throws IllegalArgumentException if {@code increment} is negative
     */
    public void accelerate(double increment) {
        if (increment < 0) {
            throw new IllegalArgumentException("Increment must be positive");
        }

        setSpeed(this.speed + increment);
    }

    /**
     * Decreases the speed of the vehicle by the specified decrement.
     * The speed will not go below 0.
     *
     * @param decrement the amount to decrease the speed; must be positive
     * @throws IllegalArgumentException if {@code decrement} is negative
     */
    public void brake(double decrement) {
        if (decrement < 0) {
            throw new IllegalArgumentException("Decrement must be positive");
        }

        setSpeed(Math.max(0, this.speed - decrement));
    }

    /**
     * Returns whether the vehicle is currently stopped (speed is 0).
     *
     * @return {@code true} if the speed is 0; {@code false} otherwise
     */
    public boolean isStopped() {
        return speed == 0;
    }

    /**
     * Resets the speed of the vehicle to 0.
     */
    public void reset() {
        setSpeed(0);
    }
}