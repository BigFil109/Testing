package net.mcilvenna.wd.volume;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sphere extends Cube {
	
	double radius;
	
	public Sphere(double radius) {
		super(radius);
		this.radius = radius;
	}

	/**
	 * Calculate the volume of a sphere to 2 decimal places
	 * 
	 * @return result
	 */
	public double getVolume()  throws IllegalArgumentException{
		if(radius <0) {
			throw new IllegalArgumentException("Input must be a postive number : " + radius);
		}
		BigDecimal a = new BigDecimal(4.0 / 3.0);
		BigDecimal b = new BigDecimal(Math.PI);
		BigDecimal c = new BigDecimal(super.getVolume());
		BigDecimal calc =a.multiply(b).multiply(c);
	
		return calc.setScale(2, RoundingMode.CEILING).doubleValue();
	}

}
