package org.example;

public class Vehicle {
    private double speed;

    public Vehicle(double speed) {
        setSpeed(speed);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if(speed < 0){
            throw new IllegalArgumentException("Speed must be greater than or equal to 0");
        }

        this.speed = speed;
    }

    public void reset(){
        setSpeed(0);
    }
}
