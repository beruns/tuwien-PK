
/**
 * Represents a Point based on it's x and y coordinates
 *
 * @author Georg Hubinger (9947673)
 * @version 1.1
 */
public class Point implements Scaleable, Moveable, Rotate, Cloneable, Transformable {

	/* Storeage for the coords */
	private double x;
	private double y;

	/* This is used for calculations on rotation. It seems that cutting off everything from the 4'th decimal place lets'
	   you calculate nicely with Math.PI based values.
	*/
	private static final long precision = 10000;

	/**
	 * Constructor
	 * @param x double value x coord
	 * @param y double value y coord
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Calculate distance between two points (a^2 + b^2 = c^2)
	 * @param p Point to calculate the distance from this Point
	 * @return scalar distance as double
	 */
	public double dist(Point p) {
		return Math.sqrt(Math.pow(this.getX() - p.getX(), 2) + Math.pow(this.getY() - p.getY(), 2));
	}

	/**
	 * Create a new Point right in the middle of two others 
	 * @param p Point to calculate the middle from this Point
	 * @return new Point
	 */
	public Point middle(Point p) {
		return new Point(this.getX() - ((this.getX() - p.getX()) / 2), this.getY() - ((this.getY() - p.getY()) / 2));
	}

	/**
	 * Rotate the point counterclockwise through the origin with in the given angle
	 * Required by Interface Rotate
	 * @param alpha Angle in radians
	 */
	public void rotate(double alpha) {

		/* temporarily store out coords */
		double x = this.getX();
		double y = this.getY();
	
		/* Sinus and cosinus of the new angle*/
		double c = Math.cos(alpha);
		double s = Math.sin(alpha);

		/* Here we use the precision we've defined in above. Works nicely with Math.PI and Multiples of it. */
		this.x = ((double) Math.round((x * c - y * s) * precision) / precision);
		this.y = ((double) Math.round((y * c + x * s) * precision) / precision);
		
	}

	/**
	 * Move Point by given Vector
	 * Required by Interface Moveable
	 * @param tx x-choord
	 * @param ty y-choord
	 */
	public void move(double tx, double ty) {
		this.x += tx;
		this.y += ty;
	}

	
	/**
	 * Scale Point relatively to the origin
	 * Required by Interface Scaleable
	 * @param sx Faktor to scale x-choord with
	 * @param sy Faktor to scale y-choord with
	 */
	public void scale(double sx, double sy) {
		this.x *= sx;
		this.y *= sy;
	}

	/**
	 * Rotate point counterclockwise through the origin with in the given angle
	 * Required by Interface Transformable 
	 * @param alpha Angle in radians
	 */
	public Transformable rotate2(double alpha) {
		Point p = (Point) this.clone();
		p.rotate(alpha);
		return p;
	}

	/**
	 * Move Point by given Vector
	 * Required by Interface Transformable
	 * @param tx x-choord
	 * @param ty y-choord
	 */
        public Transformable move2(double tx, double ty) {
		Point p = (Point) this.clone();
		p.move(tx, ty);
		return p;
	}

	/**
	 * Scale Point relatively to the origin
	 * Required by Interface Transformable 
	 * @param sx Faktor to scale x-choord with
	 * @param sy Faktor to scale y-choord with
	 */
        public Transformable scale2(double sx, double sy) {
		Point p = (Point) this.clone();
		p.scale(sx, sy);
		return p;
	}

	/**
	 * Get X coord
	 * @return X Coors as double 
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * Get Y coord
	 * @return Y Coors as double 
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * Clone Object
	 * required by Iface Cloneable
	 * @return new Object of type Point with same choords
	 */
	public Cloneable clone() {
		return new Point(this.getX(), this.getY());
	}

	/**
	 * Check for equality
	 * @param o Object to compare this Point to 
	 * @return boolean. False if o not instanceof Point or o.x != this.x or o.y not this.y. true otherwise 
	 */
	public boolean equals(Object o) {

		Point p;	

		if(!(o instanceof Point)) {
			return false;
		}

		p = (Point) o;
		
		return (p.getX() == this.getX() && p.getY() == this.getY());
	}

	/**
	 * Format Object for Printind 
	 * @return Formatted String. 
	 */
	public String toString() {
		return "#Point {x: " + this.getX() + ", y: " + this.getY() + "}";
	}


}
