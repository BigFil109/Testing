package net.mcilvenna.wd.volume;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tetrahedron extends Cube {
	double side; 
	public Tetrahedron(double side) {
		super(side);
		this.side = side;
	}

	@Override
	/**
	 * Calculate the volume of a tetrahedron to 2 decimal places given the length of
	 * its edge
	 * 
	 * @return result
	 */
	public double getVolume() throws IllegalArgumentException {
		if(side <0) {
			throw new IllegalArgumentException("Input must be a postive number : " + side);
		}
		BigDecimal a = new BigDecimal(super.getVolume());
		BigDecimal b = new BigDecimal(6).multiply(new BigDecimal(Math.sqrt(2)));
		BigDecimal calc =a.divide(b,2, RoundingMode.HALF_UP );
		return calc.setScale(2, RoundingMode.CEILING).doubleValue();
	}

}
