package net.mcilvenna.wandisco.aera;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VolumeProblem {

	public static void main(String[] args) {
		System.out.println("Start");
		
		try {
			System.out.println(Double.MAX_VALUE);
			
			System.out.println(Math.cbrt(Double.MAX_VALUE));
			System.out.println("Sphere1:" + sphereVolume(1d));
			System.out.println("Sphere5:" + sphereVolume(5d));
			System.out.println();
			System.out.println("cube1:" + cubeVolume(1d));
			System.out.println("cube5:" + cubeVolume(5d));
			System.out.println();
			System.out.println("tetrahedron1:" + tetrahedronVolume(1));
			System.out.println("tetrahedron5:" + tetrahedronVolume(5));
			
			
		} catch (IllegalArgumentException e) {
				System.out.println("Error " + e.getMessage());
		}
		System.out.println("Done");
	}

	/**
	 * Calculate the volume of a cube to 2 decimal places given its width
	 * 
	 * @param radius of a sphere
	 * @return result
	 */
	public static double cubeVolume(Double edge) throws IllegalArgumentException {
		if(edge <=0 ) {
			throw new IllegalArgumentException("Input must be a postive number : " + edge);
		}
		BigDecimal calc = powerThree(new BigDecimal(edge));
		return twoDP(calc.doubleValue());
	}

	/**
	 * Calculate the volume of a sphere to 2 decimal places
	 * 
	 * @param radius of a sphere
	 * @return result
	 */
	public static double sphereVolume(double radius)  throws IllegalArgumentException{
		if(radius <=0) {
			throw new IllegalArgumentException("Input must be a postive number : " + radius);
		}
		BigDecimal a = new BigDecimal(4.0 / 3.0);
		BigDecimal b = new BigDecimal(Math.PI);
		BigDecimal c = new BigDecimal(cubeVolume(radius));
		BigDecimal calc =a.multiply(b).multiply(c);
	
		return twoDP(calc.doubleValue());
	}

	/**
	 * Calculate the volume of a tetrahedron to 2 decimal places given the length of
	 * its edge
	 * 
	 * @param radius of a sphere
	 * @return result
	 */
	public static double tetrahedronVolume(double side) throws IllegalArgumentException {
		if(side <=0) {
			throw new IllegalArgumentException("Input must be a postive number : " + side);
		}
		BigDecimal a = new BigDecimal(cubeVolume(side));
		BigDecimal b = new BigDecimal(6).multiply(new BigDecimal(Math.sqrt(2)));
		BigDecimal calc =a.divide(b,2, RoundingMode.HALF_UP );
		return twoDP(calc.doubleValue());
	}

	/**
	 * Round val to 2 decimal places
	 * 
	 * @param val
	 * @return
	 */
	private static double twoDP(double val) {
		double result = Math.round(val * 100.0) / 100.0;
		return result;

	}

	/**
	 * Raise val to the power of 3
	 * 
	 * @param val
	 * @return
	 */
	private static BigDecimal powerThree(BigDecimal val) {
		return new BigDecimal(Math.pow(val.doubleValue(), 3));
	}

}
