package net.mcilvenna.wd.volume;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SphereTest {

	private Sphere sphere = null;

	@AfterEach
	public void eardown() {
		sphere = null;
	}

	@Test
	public void testSphereZero() {
		sphere = new Sphere(0d);
		double actual = sphere.getVolume();
		double expected = 0.0;
		assertTrue("Value was "+ expected + " expected "+expected,expected ==actual);
	}

	@Test
	public void testSphereLtZero() {
		sphere = new Sphere(-1d);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			sphere.getVolume();
		});

		String expectedMessage = "Input must be a postive number : -1.0";
		String actualMessage = exception.getMessage();

		assertTrue("Message was " + actualMessage + " expected " + expectedMessage,
				actualMessage.contains(expectedMessage));
	}

	@Test
	public void testSphereMaxFail() {
		sphere = new Sphere(Double.MAX_VALUE);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			sphere.getVolume();
		});

		String expectedMessage = "Result exceeds max double";
		String actualMessage = exception.getMessage();

		assertTrue("Message was " + actualMessage + " expected " + expectedMessage,
				actualMessage.contains(expectedMessage));
	}

	@Test
	public void testSphereOne() {
		sphere = new Sphere(1d);
		double expected = 4.19;
		double actual = sphere.getVolume();
		assertEquals(expected, actual);
	}

	@Test
	public void testSphereFive() {
		sphere = new Sphere(5d);
		double expected = 523.6;
		double actual = sphere.getVolume();
		assertEquals(expected, actual);
	}

}
