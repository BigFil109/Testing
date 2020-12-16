package net.mcilvenna.wd.volume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


class CubeTest {
	
	private Cube cube = null;
	
	
	
	@AfterEach
	public void teardown() {
		cube = null;
	}
	
	@Test
	public void testCubeZero() {	
		cube = new Cube(0d);
		double actual = cube.getVolume();
		double expected = 0.0;
		assertTrue(expected ==actual,"Value was "+ expected + " expected "+expected);
	}
	
	@Test
	public void testCubeLtZero() {
		cube = new Cube(-1d);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			cube.getVolume();
		});

		String expectedMessage = "Input must be a postive number : -1.0";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage),"Message was "+ actualMessage + " expected "+expectedMessage);
	}


	@Test
	public void testCubeMaxFail() {
		cube = new Cube(Double.MAX_VALUE);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			cube.getVolume();
		});

		String expectedMessage = "Result exceeds max double";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage),"Message was "+ actualMessage + " expected "+expectedMessage);
	}

	@Test
	public void testCubeOne() {
		cube = new Cube(1d);
		double expected = 1;
		double actual = cube.getVolume();
		assertEquals(expected, actual);
	}

	@Test
	public void testCubeOneHundredTwentyFive() {
		cube = new Cube(5d);
		double expected = 125;
		double actual = cube.getVolume();
		assertEquals(expected, actual);
	}


}
