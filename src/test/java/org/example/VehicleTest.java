package org.example;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class VehicleTest {
    @Test
    public void testGetSpeed() {
        Vehicle vehicle = new Vehicle(100);
        assertEquals(100, vehicle.getSpeed(), 0);
    }

    @Test
    public void testSetSpeedIllegalArgument() {
        Vehicle vehicle = new Vehicle(100);
        assertThrows(IllegalArgumentException.class, () -> vehicle.setSpeed(-1));
    }

    @Test
    public void testSetSpeed() {
        final int speed = 10;
        Vehicle vehicle = new Vehicle(speed);
        assertEquals(speed, vehicle.getSpeed(), 0);
    }

    @Test
    public void testSetSpeedZero() {
        Vehicle vehicle = new Vehicle(0);
        assertEquals(0, vehicle.getSpeed(), 0);
    }

    @Test
    public void testReset(){
        Vehicle vehicle = new Vehicle(100);
        vehicle.reset();
        assertEquals(0, vehicle.getSpeed(), 0);
    }
}