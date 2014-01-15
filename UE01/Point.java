
/**
 * Represents a Point based on it's x and y coordinates
 *
 * @author Georg Hubinger (9947673)
 * @version 1.0
 */
public class Point {

	/* Storeage for the coords */
	private double x;
	private double y;

	
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
