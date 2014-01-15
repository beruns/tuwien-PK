/**
 * Represents a Triangle based on 3 Points given
 *
 * @author Georg Hubinger (9947673)
 * @version 1.0
 */

public class Triangle implements Rotate, Moveable, Scaleable, Cloneable, Transformable, Shape {

	/* Storage for our 3 Points.*/
	private Point p1;
	private Point p2;
	private Point p3;
	
	/**
	 * Constructor
	 * @param p1 vertex of triangle
	 * @param p2 vertex of triangle
	 * @param p3 vertex of triangle
	 */
	public Triangle(Point p1, Point p2, Point p3) {
	

		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;

		/* If the area is 0 then either all Points are equal or they are aligned. */
		if(!(this.area() > 0)) {
			throw new IllegalArgumentException("All Points must differ and may not be aligned");
		}

	}

	/**
	 * Calculate Perimeter of Triangle
	 * Required by Interface Shape
	 * @return double precise perimeter 
	 */
	public double perimeter() {
		return this.p1.dist(this.p2) + this.p2.dist(this.p3) + this.p3.dist(this.p1);
	}

	/**
	 * Create new Triangle with vertexes right in the middle of our 3 Edges
	 * @return new Triangle
	 */
	public Triangle midTriangle() {
		return new Triangle(this.p1.middle(this.p2), this.p2.middle(this.p3), this.p3.middle(this.p1));
	}

	/** 
	 * Calculate Area of Triangle.
	 * Required by Interface Shape
	 * Uses an algorithm to calculate the area of a triangle based on the points' coordinates: Abs((Ax(By-Cy) + Bx(Cy-Ay) + Cx(Ay-By))/2) 
	 * @return double precise area 
	 * @see http://www.mathopenref.com/coordtrianglearea.html
	 */
	public double area() {
		return Math.abs((this.p1.getX() * (this.p2.getY() - this.p3.getY()) + 
			this.p2.getX() * (this.p3.getY() - this.p1.getY()) + this.p3.getX() * (this.p1.getY() - this.p2.getY())) / 2);
	}

	/**
	 * Move Triangle
	 * Required by Interface Moveable
	 * @param tx move x-choord
	 * @param ty move y-choord
	 */
	public void move(double tx, double ty) {
		this.p1.move(tx, ty);
		this.p2.move(tx, ty);
		this.p3.move(tx, ty);
	}

	/**
	 * Scale Triangle 
	 * Required by Interface Scaleable
	 * @param sx scale x-choord
	 * @param sy scale y-choord
	 */
	public void scale(double sx, double sy) {
		this.p1.scale(sx, sy);
		this.p2.scale(sx, sy);
		this.p3.scale(sx, sy);
	}

	/**
	 * Rotate triangle 
	 * Required by Interface Rotate
	 * @param alpha rotate by alpha (radians)
	 */
	public void rotate(double alpha) {
		this.p1.rotate(alpha);
		this.p2.rotate(alpha);
		this.p3.rotate(alpha);
	}
	
	/**
	 * Move Triangle
	 * Required by Interface Transformable
	 * @param tx move x-choord
	 * @param ty move y-choord
	 */
	public Transformable move2(double tx, double ty) {
		Triangle t = (Triangle) this.clone();
		t.move(tx, ty);	
		return t;
	}

	/**
	 * Scale Triangle 
	 * Required by Interface Transformable
	 * @param sx scale x-choord
	 * @param sy scale y-choord
	 */
	public Transformable scale2(double sx, double sy) {
		Triangle t = (Triangle) this.clone();
		t.scale(sx, sy);	
		return t;
	}

	/**
	 * Rotate triangle 
	 * Required by Interface Transformable
	 * @param alpha rotate by alpha (radians)
	 */
	public Transformable rotate2(double alpha) {
		Triangle t = (Triangle) this.clone();
		t.rotate(alpha);	
		return t;
	}
	
	/** Check if a given Point is equal to one of our vertexes
	 * @param p Point to check for
	 * @return true if p is equal to p1, p2 or p3. False otherwise
	 */
	public boolean hasVertex(Point p) {
		return (p.equals(this.p1) || p.equals(this.p2) || p.equals(this.p3));
	}

	/**
	 * Check for equality
	 * @param o Object to compare this Triangle to
	 * @return boolean. False if o not instanceof Triangle or if it's Points aren't equal to ours. True otherwise
	 */
	public boolean equals(Object o) {

		Triangle t;

		/* We only check Triangles */
		if(!(o instanceof Triangle)) {
			return false;
		}

		/* Cast */
		t = (Triangle) o;
		/* Check if all our vertexes are also vertexes of the given Triangle*/
		return (t.hasVertex(this.p1) && t.hasVertex(this.p2) && t.hasVertex(this.p3));
	}

	/**
         * Clone Object
	 * required by Iface Cloneable
	 * @return new Object of type Triangle with same points
	 */
	public Cloneable clone() {
		return new Triangle((Point) this.p1.clone(), (Point) this.p2.clone(), (Point) this.p3.clone());
	}

	/**
	 * Format for Output
	 * @return Formatted String
	 */
	public String toString() {
		return "#Triangle: {v1: " + this.p1 + ", v2: " + this.p2 + ", v3: " + this.p3 + "}";
	}	

}
