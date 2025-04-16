package be.thibber.gamification;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

	@Test
	public void constructorWithValidNameTest() {
	    Person person = new Person("John");
	    assertNotNull(person);
	    assertEquals("John", person.getName());
	}

	@Test
	public void setNameWithValidNameTest() {
	    Person person = new Person("John");
	    person.setName("Doe");
	    assertEquals("Doe", person.getName());
	}

	@Test
	public void getNameAfterConstructorInitializationTest() {
	    Person person = new Person("Alice");
	    assertEquals("Alice", person.getName());
	}

	@Test
	public void getNameAfterSetNameTest() {
	    Person person = new Person("Bob");
	    person.setName("Charlie");
	    assertEquals("Charlie", person.getName());
	}

}
