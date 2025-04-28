package be.thibber.gamification.test.example;

import be.thibber.gamification.example.Example;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Example test class, demonstrating how to use JUnit for unit testing.
 * sumTest & divisionTest succeeds and differenceTest fails due to implementation error.
 */
public class ExampleTest {
    @Test
    public void sumTest() {
        Example example = new Example();
        assertEquals(15, example.sum(10, 5));
        assertEquals(0, example.sum(0, 0));
    }

    @Test
    public void divisionTest() {
        Example example = new Example();

        assertEquals(5, example.division(10, 2));
        assertEquals(-2, example.division(-10, 5));
        assertEquals(0, example.division(0, 5));

        assertThrows(IllegalArgumentException.class, () -> example.division(10, 0));
    }

    @Test
    public void differenceTest() {
        Example example = new Example();
        assertEquals(5, example.difference(10, 5));
    }
}
