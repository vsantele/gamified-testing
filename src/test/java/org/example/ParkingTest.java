package org.example;

import org.example.exceptions.FullParkingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ParkingTest {
    @Test
    public void capacityTest() {
        int capacity = 10;
        Parking parking = new Parking(capacity);
        assertEquals(capacity, parking.getCapacity());
    }

    @Test
    public void invalidNegativeCapacityTest() {
        assertThrows(IllegalArgumentException.class, () -> new Parking(-1));
    }

    @Test
    public void invalidZeroCapacityTest() {
        int capacity = 0;
        Parking parking = new Parking(capacity);
        assertEquals(capacity, parking.getCapacity());
    }

    @Test
    public void addVehicleParkingFull(){
        Parking parking = new Parking(1);
        try {
            parking.addVehicle(new Vehicle(0));
            assertThrows(FullParkingException.class, () -> parking.addVehicle(new Vehicle(0)));
        } catch (FullParkingException e) {
            throw new RuntimeException(e);
        }
    }
}
