package net.mcilvenna.wd.volume;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cube implements Volume {
	private double edge;
	
	public Cube(double edge) {
		this.edge = edge;
	}

	@Override
	/**
	 * Calculate the volume of a cube to 2 decimal places given its width
	 * @return result
	 */
	public double getVolume() throws IllegalArgumentException {
		if(edge <0 ) {
			throw new IllegalArgumentException("Input must be a postive number : " + edge);
		}
		BigDecimal val = new BigDecimal(edge).pow(3).setScale(2, RoundingMode.CEILING);
		if(val.compareTo(new BigDecimal(Double.MAX_VALUE)) > 0 ){
			throw new IllegalArgumentException("Result exceeds max double");
		}
		return val.doubleValue(); 
	}

}
