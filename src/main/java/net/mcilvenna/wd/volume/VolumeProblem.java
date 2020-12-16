package net.mcilvenna.wd.volume;

public class VolumeProblem {

	public static void main(String[] args) {
		System.out.println("Start");

		Sphere sphere =null;
		Cube cube = null;
		Tetrahedron tetrahedron = null;

		try {
			sphere = new Sphere(1d);
			System.out.println("Sphere1:" + sphere.getVolume());
			sphere = new Sphere(5d);
			System.out.println("Sphere5:" + sphere.getVolume());
			System.out.println();
			cube = new Cube(1d);
			System.out.println("cube1:" + cube.getVolume());
			cube = new Cube(5d);
			System.out.println("cube5:" + cube.getVolume());
			System.out.println();
			tetrahedron = new Tetrahedron(1d);
			System.out.println("tetrahedron1:" + tetrahedron.getVolume());
			tetrahedron = new Tetrahedron(5d);
			System.out.println("tetrahedron5:" + tetrahedron.getVolume());

		} catch (IllegalArgumentException e) {
			System.out.println("Error " + e.getMessage());
		}
		System.out.println("Done");
	}

}
