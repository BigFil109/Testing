package net.mcilvenna.wd.volume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class SphereTest {

	private Sphere sphere = null;

	@AfterEach
	public void teardown() {
		sphere = null;
	}

	@Test
	// test pass zero
	public void testSphereZero() {
		sphere = new Sphere(0d);
		double actual = sphere.getVolume();
		double expected = 0.0;
		assertTrue(expected == actual, "Value was " + expected + " expected " + expected);
	}

	@Test
	// test neg value throws expected exception
	public void testSphereLtZero() {
		sphere = new Sphere(-1d);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			sphere.getVolume();
		});

		String expectedMessage = "Input must be a postive number : -1.0";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage),
				"Message was " + actualMessage + " expected " + expectedMessage);
	}

	@Test
	// test exceeding max double in the results throws expected exception
	public void testSphereMaxFail() {
		sphere = new Sphere(Double.MAX_VALUE);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			sphere.getVolume();
		});

		String expectedMessage = "Result exceeds max double";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage),
				"Message was " + actualMessage + " expected " + expectedMessage);
	}

	@Test
	// test happy path
	public void testSphereOne() {
		sphere = new Sphere(1d);
		double expected = 4.19;
		double actual = sphere.getVolume();
		assertEquals(expected, actual);
	}

	@Test
	// test happy path
	public void testSphereFive() {
		sphere = new Sphere(5d);
		double expected = 523.6;
		double actual = sphere.getVolume();
		assertEquals(expected, actual);
	}

}
