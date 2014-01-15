
public class MyTree<A extends Comparable<A>> {

	private MyTreeNode head = null;
	
	public MyTree() {
	}

	public boolean add(A value) {
		if(this.head == null) {
			this.head = new MyTreeNode(value);
			return true;
		}

		return this.head.add(value);

	}

	public String toString() {
		if(this.head != null) return this.head.toString();
		return "";
	}

	private class MyTreeNode {

		private A value;
		private MyTreeNode left = null;
		private MyTreeNode right = null;

		private MyTreeNode(A value) {
			this.value = value;
		}

		private boolean add(A value) {

			if(this.value.compareTo(value) < 0) {
				if(this.right == null) {
					this.right = new MyTreeNode(value);
					return true;
				}
				return this.right.add(value);
			} else if(this.value.compareTo(value) > 0) {
				if(this.left == null) {
					this.left = new MyTreeNode(value);
					return true;
				}
				return this.left.add(value);
			}
			return false;
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

	public static void main(String args[]) {

		MyTree<String> t = new MyTree<String>();
		t.add(new String("H"));
		t.add(new String("J"));
		t.add(new String("K"));
		t.add(new String("G"));
		t.add(new String("B"));
		t.add(new String("C"));
		t.add(new String("A"));
		t.add(new String("I"));
		t.add(new String("Z"));
		t.add(new String("Z"));
		t.add(new String("N"));
		t.add(new String("M"));
		t.add(new String("O"));
		t.add(new String("Q"));
		t.add(new String("R"));
		t.add(new String("D"));
		t.add(new String("E"));
		t.add(new String("L"));
		t.add(new String("Y"));
		t.add(new String("P"));
		t.add(new String("U"));
		t.add(new String("F"));
		t.add(new String("T"));
		t.add(new String("X"));
		t.add(new String("W"));
		t.add(new String("V"));

		MyTree<String> t2 = new MyTree<String>();
		t2.add(new String("M"));
		t2.add(new String("N"));
		t2.add(new String("O"));
		t2.add(new String("P"));
		t2.add(new String("Q"));
		t2.add(new String("R"));
		t2.add(new String("S"));
		t2.add(new String("T"));
		t2.add(new String("U"));
		t2.add(new String("V"));
		t2.add(new String("W"));
		t2.add(new String("X"));
		t2.add(new String("Y"));
		t2.add(new String("Z"));
		
		t2.add(new String("L"));
		t2.add(new String("K"));
		t2.add(new String("J"));
		t2.add(new String("I"));
		t2.add(new String("H"));
		t2.add(new String("G"));
		t2.add(new String("F"));
		t2.add(new String("E"));
		t2.add(new String("D"));
		t2.add(new String("C"));
		t2.add(new String("B"));
		t2.add(new String("A"));

		MyTree<String> t3 = new MyTree<String>();
		t3.add(new String("A"));
		t3.add(new String("B"));
		t3.add(new String("C"));
		t3.add(new String("D"));
		t3.add(new String("E"));
		t3.add(new String("F"));
		t3.add(new String("G"));
		t3.add(new String("H"));
		t3.add(new String("I"));
		t3.add(new String("J"));
		t3.add(new String("K"));
		t3.add(new String("L"));
		t3.add(new String("M"));
		t3.add(new String("N"));
		t3.add(new String("O"));
		t3.add(new String("P"));
		t3.add(new String("Q"));
		t3.add(new String("R"));
		t3.add(new String("S"));
		t3.add(new String("T"));
		t3.add(new String("U"));
		t3.add(new String("V"));
		t3.add(new String("W"));
		t3.add(new String("X"));
		t3.add(new String("Y"));
		t3.add(new String("Z"));
		t3.add(new String("Z"));
		t3.add(new String("Z"));
		t3.add(new String("Z"));
		t3.add(new String("Z"));


		System.out.println("------------------------------------------------------------------------------------------------------------------ Tree 1\n");	
		System.out.println(t);		
		System.out.println("------------------------------------------------------------------------------------------------------------------ Tree 2\n");	
		System.out.println(t2);		
		System.out.println("------------------------------------------------------------------------------------------------------------------ Tree 3\n");	
		System.out.println(t3);		
	
	

	}

}
