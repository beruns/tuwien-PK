/**
 * Represents a Circle based on a Point and a radius
 *
 * @author Georg Hubinger (9947673)
 * @version 1.1
 */

public class Circle implements Rotate, Moveable, Scaleable, Shape, Cloneable, Transformable {

	private Point center;
	private double radius;

	/**
	 * Constructor
	 * @param center - Center Point
	 * @param radius - Circle's Radius
	 */
	public Circle(Point center, double radius) {

		this.center = center;
		this.radius = radius;

	}

	/**
	 * Return perimeter of Circle
	 * Required by Interface Shape
	 */
	public double perimeter() {
		return 2 * this.radius * Math.PI;
	}

	/**
	 * Return area of Circle
	 * Required by Interface Shape
	 */
	public double area() {
		return Math.pow(this.radius, 2) * Math.PI;
	}

	/**
	 * Rotate Circle counterclockwise against the origin by alpha
	 * Required by Interface Rotate
	 * @para, alpha Rotation Angle in radians
	 */
	public void rotate(double alpha) {
		this.center.rotate(alpha);
	}

	/**
	 * Scale Circle.
	 * Required by Interface Scaleable
	 * @param sx scale center point's x-choord and radius
	 * @param sy scale center point's y-choord
	 */
	public void scale(double sx, double sy) {
		this.center.scale(sx, sy);
		this.radius *= sx;
	}
	
	/**
	 * Move Circle
	 * Reuquired by Interface Moveable
	 * @param tx move center point's x-choord
	 * @param ty move center point's y-choord
	 */
	public void move(double tx, double ty) {
		this.center.move(tx, ty);
	}

	/** 
	 * Rotate Clone of Circle
	 * Required by Transformable
	 * @para, alpha Rotation Angle in radians
	 */
	public Transformable rotate2(double alpha) {
	        Circle c = (Circle) this.clone();
	        c.rotate(alpha);
	        return c;
	}

	/** 
	 * Move Circle 
	 * Required by Transformable
	 * @param tx move center point's x-choord
	 * @param ty move center point's y-choord
	 */
	public Transformable move2(double tx, double ty) {
	        Circle c = (Circle) this.clone();
	        c.move(tx, ty);
	        return c;
	}

	/**
	 * Scale Circle.
	 * Required by Interface Transformable
	 * @param sx scale center point's x-choord and radius
	 * @param sy scale center point's y-choord
	 */
	public Transformable scale2(double sx, double sy) {
	        Circle c = (Circle) this.clone();
	        c.scale(sx, sy);
	        return c;
	}


	/**
         * Clone Object
         * required by Iface Cloneable
         * @return new Object of type Circle with same center and radius
         */
	public Cloneable clone() {
		return new Circle((Point) this.center.clone(), this.radius);
	}

	/** Format Circle for printing
	  * @return Formatted String
	  */
	public String toString() {
		return "#Circle {c: " + this.center + ", r: " + this.radius + "}";
	}

}
