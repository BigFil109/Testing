package net.mcilvenna.wd.volume;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class VolumeProblemTest {
	
	@Test
	public void testCubeZero() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			VolumeProblem.cubeVolume(0d);
		});
		String expectedMessage = "Input must be a postive number : 0.0";
		String actualMessage = exception.getMessage();

		assertTrue("Message was "+ actualMessage + " expected "+expectedMessage,actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testCubeLtZero() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			VolumeProblem.cubeVolume(-1d);
		});

		String expectedMessage = "Input must be a postive number : -1.0";
		String actualMessage = exception.getMessage();

		assertTrue("Message was "+ actualMessage + " expected "+expectedMessage,actualMessage.contains(expectedMessage));
	}


	@Test
	public void testCubeMaxFail() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			VolumeProblem.cubeVolume(Double.MAX_VALUE);
		});

		String expectedMessage = "Infinite or NaN";
		String actualMessage = exception.getMessage();
		
		assertTrue("Message was "+ actualMessage + " expected "+expectedMessage,actualMessage.contains(expectedMessage));
	}

	@Test
	public void testCubeOne() {
		double expected = 1;
		double actual = VolumeProblem.cubeVolume(1d);
		assertEquals(expected, actual);
	}

	@Test
	public void testCubeOneHundredTwentyFive() {
		double expected = 125;
		double actual = VolumeProblem.cubeVolume(5d);
		assertEquals(expected, actual);
	}


	@Test
	public void testSphereZero() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			VolumeProblem.sphereVolume(0);
		});

		String expectedMessage = "Input must be a postive number : 0.0";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	@Test
	public void testSphereLtZero() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			VolumeProblem.sphereVolume(-1d);
		});

		String expectedMessage = "Input must be a postive number : -1.0";
		String actualMessage = exception.getMessage();

		assertTrue("Message was "+ actualMessage + " expected "+expectedMessage,actualMessage.contains(expectedMessage));
	}


	@Test
	public void testSphereMaxFail() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			VolumeProblem.sphereVolume(Double.MAX_VALUE);
		});

		String expectedMessage = "Infinite or NaN";
		String actualMessage = exception.getMessage();
		
		assertTrue("Message was "+ actualMessage + " expected "+expectedMessage,actualMessage.contains(expectedMessage));
	}

	@Test
	public void testSphereOne() {
		double expected = 4.19;
		double actual = VolumeProblem.sphereVolume(1);
		assertEquals(expected, actual);
	}

	@Test
	public void testSphereFive() {
		double expected = 523.6;
		double actual = VolumeProblem.sphereVolume(5);
		assertEquals(expected, actual);
	}

	
	@Test
	public void testTetrahedronZero() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			VolumeProblem.tetrahedronVolume(0);
		});

		String expectedMessage = "Input must be a postive number : 0";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testTetrahedronNeg() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			VolumeProblem.tetrahedronVolume(-1);
		});

		String expectedMessage = "Input must be a postive number : -1";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	

	@Test
	public void testTetrahedroMaxFail() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			VolumeProblem.tetrahedronVolume(Double.MAX_VALUE);
		});

		String expectedMessage = "Infinite or NaN";
		String actualMessage = exception.getMessage();
		
		assertTrue("Message was "+ actualMessage + " expected "+expectedMessage,actualMessage.contains(expectedMessage));
	}

	@Test
	public void testTetrahedronOne() {
		double expected = 0.12;
		double actual = VolumeProblem.tetrahedronVolume(1);
		assertEquals(expected, actual);
	}

	@Test
	public void testTetrahedronFive() {
		double expected = 14.73;
		double actual = VolumeProblem.tetrahedronVolume(5);
		assertEquals(expected, actual);
	}

}
