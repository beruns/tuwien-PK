class myTest {


	public static void main(String[] args) {

		Point p1 = new Point(2, 4);
		Point p2 = new Point(4, 2);
		Point p3 = new Point(1, 1);
		
		Point p4 = new Point(5, 5);

		Triangle t1 = new Triangle(p1, p2, p3);
		System.out.println("Tr 1 before Transform: " + t1);
		Triangle t2 = (Triangle) t1.rotate2(Math.PI / 2);
		System.out.println("Tr 1 after ransform: " + t1);
		System.out.println("Tr 2: " + t2);
		
		Circle c1 = new Circle(p4, 20);
		System.out.println("C1 before Transform: " + c1);
		Circle c2 = (Circle) c1.scale2(10, 20);
		System.out.println("C1 after Transform: " + c1);
		System.out.println("C2: " + c2);
		
		

	}

}
