
/**
 * Test our Point and Triangle Class
 *
 * @author Georg Hubinger (9947673)
 * @version 1.0
 */
public class myTest {

	/**
	 * Entry Point
	 */
	public static void main(String[] args) {

		/* Create some Points */
		Point p1 = new Point(3, 2);
		Point p2 = new Point(-1.5, 0);
		Point p3 = new Point(-2.5, -2.5);

		Point p4 = new Point(3, 2);
		Point p5 = new Point(-1.5, 0);
		Point p6 = new Point(-2.5, -2.5);

		Point p7 = new Point(4, 3);

		/* and some Triangles */
		/* t1 and t2 share the same Point Objects */
		Triangle t1 = new Triangle(p1, p2, p3);
		Triangle t2 = new Triangle(p1, p2, p3);
		/* t3 holds Points equal tos the ones of t1 and t2 */
		Triangle t3 = new Triangle(p4, p5, p6);
		/* Create a midTriangle */
		Triangle t4 = t3.midTriangle();
	
		try {
			/* This will throw an IllegalArgument Exception. All Three Point shall be different and my not be aligned */
			Triangle t5 = new Triangle(p7, p7, p7);
		} catch (Exception e) {
			System.out.println("Error creating Triangle 5: " + e.getMessage());
		}

		/* Some Info */
		System.out.println("Triangle 1: " + t1);
		System.out.println("Perimeter: " + t1.perimeter());
		System.out.println("Area: " + t1.area());

		System.out.println();

		System.out.println("Triangle 2: " + t2);
		System.out.println("Perimeter: " + t2.perimeter());
		System.out.println("Area: " + t2.area());

		System.out.println();

		System.out.println("Triangle 3: " + t3);
		System.out.println("Perimeter: " + t3.perimeter());
		System.out.println("Area: " + t3.area());

		System.out.println();

		System.out.println("Triangle 4 (Mid Triangle of Tr 3): " + t4);
		System.out.println("Perimeter: " + t4.perimeter());
		System.out.println("Area: " + t4.area());

		System.out.println();

		/* Check for equality */
		System.out.println("Triangle 1 equals Triangle 2?: " + t1.equals(t2));
		System.out.println("Triangle 2 equals Triangle 3?: " + t2.equals(t3));
		System.out.println("Triangle 3 equals Triangle 4?: " + t3.equals(t4));

		/* Done */	

	}

}
