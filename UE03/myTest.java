/**
 * Test Implimentation of all Classes
 * @author Georg HUbinger (9947673)
 * @version 0.1
 */
public class myTest {

	public static void main(String args[]) {


		MyCompList<Integer> cl1 = new MyCompList<Integer>();
		MyList<Integer> l1 = new MyList<Integer>();
		MyList<Integer> l2 = new MyList<Integer>();
		MyList<Integer> l3 = new MyList<Integer>();
	
		Integer n;

		int test = (args.length == 0?1:Integer.parseInt(args[0]));

		switch(test) {		

			/**
			 * Tests addFirst and removeFirst on MyList	
			 */
			case 1:
	
				for(int i = 0; i < 10; i++) {

					n = new Integer(i);			

					l1.addFirst(n);
					l2.addLast(n);
					l3.addLast(n);
				
				}	

				System.out.println("Before " + l1.size() + " " + l1.get(9));
	
				System.out.println("First List: " + l1);
				System.out.println("F1[3]: " + l1.get(3));
				System.out.println("F1[0]: " + l1.removeFirst());
				System.out.println("F1 after Remove: " + l1);

				System.out.println("Second List: " + l2);
				System.out.println("F2[5]: " + l2.get(5));
				System.out.println("F2[9]: " + l2.removeLast());
				System.out.println("F3[9]: " + l3.get(l3.size() - 1));
				System.out.println("F2 after Remove: " + l2);
			
				try {
					System.out.println("After" + l1.size() + " " + l1.get(9));
				} catch( Exception e) {
					System.out.println("Exception " + e.getClass() + " caught while trying to access elemnt 9 on List 1");
				}
			
			break;
		
			case 2:

				/**
				 * Tests enqueue and dequeue on MyList
				 */
				System.out.println("List start: " + l1);

				for(int i = 0; i < 10; i++) {
	
					n = new Integer(i);
					l1.enqueue(n);
					System.out.println("Enqueued " + n);
					System.out.println("List now: " + l1);
				}


				while((n = l1.dequeue()) != null) {
					System.out.println("Dequeued " + n);
					System.out.println("List now: " + l1);
					
				}

			break;
	
			case 3:

				/**
				 * Tests minimum implementation on MyCompList
				 */
				ReverseComparator<Integer> comp = new ReverseComparator<Integer>();
		
				for(int i = 30; i < 40; i++) {

					n = new Integer(i);
					cl1.enqueue(n);
				}

				System.out.println("Minimum: " + cl1.minimum());
				System.out.println("Maximum: " + cl1.minimum(comp));
			break;

		}
		
	
	}

}
