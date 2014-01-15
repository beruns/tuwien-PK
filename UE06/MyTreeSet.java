import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyTreeSet<A extends Comparable<A>> {

	private MyTreeSetNode head = null;
	private int nodeCount = 0;
	
	public MyTreeSet() {
	}

	/**
	 * worst case O(n), average case O(log(n))
	 */

	public boolean add(A value) {

		if(this.head == null) {
			this.head = new MyTreeSetNode(null, value);
			this.nodeCount = 1;
			return true;
		}

		if(this.head.add(value)) {
			this.nodeCount++;
			return true;
		}
		
		return false;

	}

	/**
	 * worst case O(n), average case O(log(n))
	 */
	public boolean remove(A value) {

		if(this.head == null) return false;

		if(this.head.remove(value)) {
			this.nodeCount--;
			return true;
		}

		return false;

	}

	/**
	 * worst case O(n), average case O(log(n))
	 */
	public boolean contains(A value) {

		if(this.head == null) return false;
		return this.head.contains(value);

	}

	public Iterator<A> iterator() {
		return new MyTreeIterator();
	}

	/**
	 * O(1)
	 */
	public int size() {

		return this.nodeCount;

	}

	public String toString() {
		if(this.head == null) {
			return "Empty Aree";
		}
		return this.head.toString();
	}

	/**
	 * avg O(n * log(n)). worst O(n*n)
	 */
	private class MyTreeIterator implements Iterator<A> {
	
		private MyTreeSetNode current = null;

		/**
		 * avg O(log(n)). worst O(n)
		 */ 
		public MyTreeIterator() {
			if(MyTreeSet.this.head != null) this.current = MyTreeSet.this.head.findRightMostNode();
		}
		
		/**
		 * O(1)
		 */
		public boolean hasNext() {
			return (this.current != null);
		}
	
		/**
		 * avg O(log(n)). worst O(n)
		 */
		public A next() {

			if(!this.hasNext()) throw new NoSuchElementException();

			MyTreeSetNode ret = this.current;

			if(current.left != null) {
				this.current = current.left.findRightMostNode();
			} else if(current.parent != null) {
				if(current.parent.right != null && current.parent.right == current) {
					this.current = current.parent;
				} else {
					while(this.current.parent != null && this.current.parent.left == this.current) {
						this.current = this.current.parent;
					}
					this.current = this.current.parent;
				}
			} else {
				this.current = null;
			}
		
			return ret.value;

		}

		public void remove() {
		}
		
	}

	
	private class MyTreeSetNode {

		private A value = null;

		private MyTreeSetNode parent = null;
		private MyTreeSetNode left = null;
		private MyTreeSetNode right = null;

		private MyTreeSetNode(MyTreeSetNode parent, A value) {

			this.parent = parent;
			this.value = value;
			
		}

		private boolean add(A value) {

			 if(this.value.compareTo(value) < 0) {

				if(this.right == null) {

					this.right = new MyTreeSetNode(this, value);
					return true;

				}

				return this.right.add(value);

			} else if(this.value.compareTo(value) > 0) {

				if(this.left == null) {

					this.left = new MyTreeSetNode(this, value);
					return true;

				}

				return this.left.add(value);

			}

			return false;

		}

		private boolean remove(A value) {

			if(this.value.compareTo(value) < 0) {

				if(this.right == null) return false;
				return this.right.remove(value);

			} else if(this.value.compareTo(value) > 0) {

				if(this.left == null) return false;
				return this.left.remove(value);

			} else {

				if(this.left == null && this.right == null) {
					
					if(this.parent == null) {

						MyTreeSet.this.head = null;

					} else if(this.parent.value.compareTo(this.value) > 0) {

						this.parent.left = null;

					} else {

						this.parent.right = null;

					}
					return true;

				} else if(this.left != null && this.right != null) {


					MyTreeSetNode smallestNode = this.right.findLeftMostNode();


					this.value = smallestNode.value;
					smallestNode.remove(this.value);

					return true;

				} else {


					if(this.parent == null) {

						MyTreeSet.this.head = ((this.right != null)?this.right:this.left);
						MyTreeSet.this.head.parent = null;
	
					} else if(this.parent.value.compareTo(this.value) > 0) {

						this.parent.left = ((this.right != null)?this.right:this.left);
						this.parent.left.parent = this.parent;

					} else {

						this.parent.right = ((this.right != null)?this.right:this.left);
						this.parent.right.parent = this.parent;

					}

					return true;

				
				}
			}

			
		}

		private boolean contains(A value) {

			 if(this.value.compareTo(value) < 0) {

				if(this.right == null) return false;
				return this.right.contains(value);

			} else if(this.value.compareTo(value) > 0) {

				if(this.left == null) return false;
				return this.left.contains(value);

			}

			return true;

		}


		private MyTreeSetNode findLeftMostNode() {

			if(this.left == null) return this;
			return this.left.findLeftMostNode();

		}

		private MyTreeSetNode findRightMostNode() {

			if(this.right == null) return this;
			return this.right.findRightMostNode();

		}

		public String printNode(String spacer) {

			String ret = "[" + this.value + "]\n";
			if(this.right != null) ret += spacer + "right:  " + this.right.printNode(spacer + "\t");
			if(this.left != null) ret += spacer + "left:   " + this.left.printNode(spacer + "\t");
			return ret;

		}


		public String toString() {
			return this.printNode("");
		}
	
	}

	public static void main(String args[]) throws InterruptedException, java.io.IOException {

		MyTreeSet<Integer> ts1 = new MyTreeSet<Integer>();

		ts1.add(new Integer("40"));
		ts1.add(new Integer("20"));
		ts1.add(new Integer("10"));
		ts1.add(new Integer("30"));
		ts1.add(new Integer("5"));
		ts1.add(new Integer("15"));
		ts1.add(new Integer("25"));
		ts1.add(new Integer("35"));
		ts1.add(new Integer("2"));
		ts1.add(new Integer("7"));
		ts1.add(new Integer("12"));
		ts1.add(new Integer("17"));
		ts1.add(new Integer("22"));
		ts1.add(new Integer("27"));
		ts1.add(new Integer("32"));
		ts1.add(new Integer("37"));
		ts1.add(new Integer("1"));
		ts1.add(new Integer("4"));
		ts1.add(new Integer("6"));
		ts1.add(new Integer("9"));
		ts1.add(new Integer("11"));
		ts1.add(new Integer("14"));
		ts1.add(new Integer("16"));
		ts1.add(new Integer("19"));
		ts1.add(new Integer("21"));
		ts1.add(new Integer("24"));
		ts1.add(new Integer("26"));
		ts1.add(new Integer("29"));
		ts1.add(new Integer("31"));
		ts1.add(new Integer("34"));
		ts1.add(new Integer("36"));
		ts1.add(new Integer("39"));
		ts1.add(new Integer("3"));
		ts1.add(new Integer("8"));
		ts1.add(new Integer("13"));
		ts1.add(new Integer("18"));
		ts1.add(new Integer("23"));
		ts1.add(new Integer("28"));
		ts1.add(new Integer("33"));
		ts1.add(new Integer("38"));

		System.out.println("BEFORE REMOVE -----------------------------------------------------------------------------------------------------------------");
		System.out.println(ts1);
		System.out.println("Size is " + ts1.size());
		System.out.println();
		Thread.sleep(3000);
		ts1.remove(new Integer("20"));
		System.out.println("AFTER REMOVE 20----------------------------------------------------------------------------------------------------------------");
		System.out.println(ts1);
		System.out.println("Size is " + ts1.size());
		System.out.println();
		Thread.sleep(3000);
		ts1.remove(new Integer("21"));
		System.out.println("AFTER REMOVE 21----------------------------------------------------------------------------------------------------------------");
		System.out.println(ts1);
		System.out.println("Size is " + ts1.size());
		System.out.println();
		Thread.sleep(3000);
		ts1.remove(new Integer("22"));
		System.out.println("AFTER REMOVE 22----------------------------------------------------------------------------------------------------------------");
		System.out.println(ts1);
		System.out.println("Size is " + ts1.size());
		System.out.println();
		Thread.sleep(3000);
		ts1.remove(new Integer("23"));
		System.out.println("AFTER REMOVE 23----------------------------------------------------------------------------------------------------------------");
		System.out.println(ts1);
		System.out.println("Size is " + ts1.size());
		System.out.println();
		Thread.sleep(3000);
		ts1.remove(new Integer("24"));
		System.out.println("AFTER REMOVE 24----------------------------------------------------------------------------------------------------------------");
		System.out.println(ts1);
		System.out.println("Size is " + ts1.size());
		System.out.println();
		Thread.sleep(3000);
		ts1.remove(new Integer("40"));
		System.out.println("AFTER REMOVE 40----------------------------------------------------------------------------------------------------------------");
		System.out.println(ts1);
		System.out.println("Size is " + ts1.size());
		System.out.println();
		Thread.sleep(3000);
		ts1.remove(new Integer("10"));
		System.out.println("AFTER REMOVE 10----------------------------------------------------------------------------------------------------------------");
		System.out.println(ts1);
		System.out.println("Size is " + ts1.size());
		System.out.println();

		System.out.println("Contains 100");
		System.out.println(ts1.contains(new Integer(100)));

		System.out.println("Contains 10");
		System.out.println(ts1.contains(new Integer(10)));

		System.out.println("Contains 18");
		System.out.println(ts1.contains(new Integer(18)));

		System.out.println("Contains 11");
		System.out.println(ts1.contains(new Integer(11)));

		System.out.println("Contains 11");
		System.out.println(ts1.contains(new Integer(11)));

		System.out.println("Contains 300");
		System.out.println(ts1.contains(new Integer(300)));
	
		System.out.println();
		System.out.println("Iterating Tree ----------------------------------------------------------------------------------------------------------------");
		
		Iterator<Integer> it = ts1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		MyTreeSet<Integer> ts2 = new MyTreeSet<Integer>();

		for(int i = 1; i <= 40; i++) {
			ts2.add(new Integer(i));
		}

		System.out.println();
		System.out.println("Unbalanced Tree ---------------------------------------------------------------------------------------------------------------");
		System.out.println(ts2);

		System.out.println();
		System.out.println("Iterating Tree ----------------------------------------------------------------------------------------------------------------");
		it = ts2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

