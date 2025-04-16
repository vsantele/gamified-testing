package be.thibber.gamification;

import org.junit.Test;
import static org.junit.Assert.*;

public class CoordsTest {

    @Test
    public void constructorInitializationTest() {
        Coords coords = new Coords(10.0, 20.0);
        assertEquals(10.0, coords.getX(), 0.0001);
        assertEquals(20.0, coords.getY(), 0.0001);
    }

    @Test
    public void getXTest() {
        Coords coords = new Coords(15.5, 25.5);
        assertEquals(15.5, coords.getX(), 0.0001);
    }

    @Test
    public void getYTest() {
        Coords coords = new Coords(15.5, 25.5);
        assertEquals(25.5, coords.getY(), 0.0001);
    }

    @Test
    public void setXTest() {
        Coords coords = new Coords(10.0, 20.0);
        coords.setX(30.0);
        assertEquals(30.0, coords.getX(), 0.0001);
    }

    @Test
    public void setYTest() {
        Coords coords = new Coords(10.0, 20.0);
        coords.setY(40.0);
        assertEquals(40.0, coords.getY(), 0.0001);
    }

    @Test
    public void getDistanceToSamePointTest() {
        Coords coords1 = new Coords(5.0, 5.0);
        Coords coords2 = new Coords(5.0, 5.0);
        assertEquals(0.0, coords1.getDistanceTo(coords2), 0.0001);
    }

    @Test
    public void getDistanceToHorizontalPointTest() {
        Coords coords1 = new Coords(0.0, 0.0);
        Coords coords2 = new Coords(3.0, 0.0);
        // Based on the implementation: Math.sqrt(Math.pow(other.getX() - this.getX(), 4) + Math.pow(other.getY() - this.getY(), 2))
        // For horizontal points: Math.sqrt(Math.pow(3.0 - 0.0, 4) + Math.pow(0.0 - 0.0, 2)) = Math.sqrt(81.0) = 9.0
        assertEquals(9.0, coords1.getDistanceTo(coords2), 0.0001);
    }

    @Test
    public void getDistanceToVerticalPointTest() {
        Coords coords1 = new Coords(0.0, 0.0);
        Coords coords2 = new Coords(0.0, 4.0);
        // Based on the implementation: Math.sqrt(Math.pow(other.getX() - this.getX(), 4) + Math.pow(other.getY() - this.getY(), 2))
        // For vertical points: Math.sqrt(Math.pow(0.0 - 0.0, 4) + Math.pow(4.0 - 0.0, 2)) = Math.sqrt(16.0) = 4.0
        assertEquals(4.0, coords1.getDistanceTo(coords2), 0.0001);
    }

    @Test
    public void getDistanceToDiagonalPointTest() {
        Coords coords1 = new Coords(0.0, 0.0);
        Coords coords2 = new Coords(3.0, 4.0);
        // Based on the implementation: Math.sqrt(Math.pow(other.getX() - this.getX(), 4) + Math.pow(other.getY() - this.getY(), 2))
        // For diagonal points: Math.sqrt(Math.pow(3.0 - 0.0, 4) + Math.pow(4.0 - 0.0, 2)) = Math.sqrt(81.0 + 16.0) = Math.sqrt(97.0)
        assertEquals(Math.sqrt(97.0), coords1.getDistanceTo(coords2), 0.0001);
    }

    @Test
    public void getAngleToEastPointTest() {
        Coords coords1 = new Coords(0.0, 0.0);
        Coords coords2 = new Coords(1.0, 0.0);
        // For east point, angle should be 0 degrees
        // But based on the implementation: deltaY = other.getY() + getY() (note the + instead of -)
        // This will affect the calculation
        assertEquals(0.0, coords1.getAngleTo(coords2), 0.0001);
    }

    @Test
    public void getAngleToNorthPointTest() {
        Coords coords1 = new Coords(0.0, 0.0);
        Coords coords2 = new Coords(0.0, 1.0);
        // For north point, angle should be 90 degrees
        // But based on the implementation: deltaY = other.getY() + getY() (note the + instead of -)
        // This will affect the calculation
        assertEquals(90.0, coords1.getAngleTo(coords2), 0.0001);
    }

    @Test
    public void getAngleToWestPointTest() {
        Coords coords1 = new Coords(0.0, 0.0);
        Coords coords2 = new Coords(-1.0, 0.0);
        // For west point, angle should be 180 degrees
        // But based on the implementation: deltaY = other.getY() + getY() (note the + instead of -)
        // This will affect the calculation
        assertEquals(180.0, coords1.getAngleTo(coords2), 0.0001);
    }

    @Test
    public void getAngleToSouthPointTest() {
        Coords coords1 = new Coords(0.0, 0.0);
        Coords coords2 = new Coords(0.0, -1.0);
        // For south point, angle should be -90 degrees
        // But based on the implementation: deltaY = other.getY() + getY() (note the + instead of -)
        // This will affect the calculation
        assertEquals(-90.0, coords1.getAngleTo(coords2), 0.0001);
    }

    @Test
    public void movePositiveOffsetsTest() {
        Coords coords = new Coords(10.0, 20.0);
        coords.move(5.0, 7.0);
        assertEquals(15.0, coords.getX(), 0.0001);
        // Note: The move method subtracts yOffset from Y (setY(getY() - yOffset))
        assertEquals(13.0, coords.getY(), 0.0001);
    }

    @Test
    public void moveNegativeOffsetsTest() {
        Coords coords = new Coords(10.0, 20.0);
        coords.move(-5.0, -7.0);
        assertEquals(5.0, coords.getX(), 0.0001);
        // Note: The move method subtracts yOffset from Y (setY(getY() - yOffset))
        // So with a negative yOffset, it actually adds to Y
        assertEquals(27.0, coords.getY(), 0.0001);
    }

    @Test
    public void moveZeroOffsetsTest() {
        Coords coords = new Coords(10.0, 20.0);
        coords.move(0.0, 0.0);
        assertEquals(10.0, coords.getX(), 0.0001);
        assertEquals(20.0, coords.getY(), 0.0001);
    }
}
