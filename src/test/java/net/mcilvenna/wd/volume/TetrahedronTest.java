package net.mcilvenna.wd.volume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TetrahedronTest {
	
	Tetrahedron tetrahedron = null;
	
	
	@AfterEach
	public void teardown() {
		tetrahedron = null;
	}
	
	
	@Test
	//test pass zero
	public void testTetrahedronZero() {
		tetrahedron = new Tetrahedron(0d);
		double actual = tetrahedron.getVolume();
		double expected = 0.0;
		assertTrue(expected ==actual,"Value was "+ expected + " expected "+expected);
	}

	@Test
	//test neg value throws expected exception
	public void testTetrahedronNeg() {
		tetrahedron = new Tetrahedron(-1d);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			tetrahedron.getVolume();
		});

		String expectedMessage = "Input must be a postive number : -1";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage),"Message was "+ actualMessage + " expected "+expectedMessage);
	}
	
	

	@Test
	//test exceeding max double in the results throws expected exception
	public void testTetrahedroMaxFail() {
		tetrahedron = new Tetrahedron(Double.MAX_VALUE);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			tetrahedron.getVolume();
		});

		String expectedMessage = "Result exceeds max double";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage),"Message was "+ actualMessage + " expected "+expectedMessage);
	}

	@Test
	//test happy path
	public void testTetrahedronOne() {
		tetrahedron = new Tetrahedron(1d);
		double expected = 0.12;
		double actual = tetrahedron.getVolume();
		assertEquals(expected, actual);
	}

	@Test
	//test happy path
	public void testTetrahedronFive() {
		tetrahedron = new Tetrahedron(5d);
		double expected = 14.73;
		double actual =tetrahedron.getVolume();
		assertEquals(expected, actual);
	}

}
