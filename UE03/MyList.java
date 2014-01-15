/**
 * Stores Elements of type A
 * @author Georg Hubinger (9947673)
 * @version 0.1
 */
public class MyList<A> implements QueueI<A> {

	/* Node is declared as private Class below*/
	private Node<A> head = null;

	/**
	 * Is List Empty
	 * @return true is List is empty, false otherwise
	 */
	public boolean isEmpty() {
		return this.head == null;
	}

	/**
	 * @return number of Elements currently in List
	 */
	public int size() {

		Node<A> node = this.head;
		int i = 0;

		while(node != null) {
			node = node.next;
			i++;
		}
		return i;
	}

	/**
	 * Retrieve index'th element in queue
	 * @param index Index of  element to be retrieved. If index is out of List Bounds, an IndexOutOfBounds Exception is thrown
	 * @return index'th element in queue
	 */
	public A get(int index) {

		if(index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}

		int i = 0;
		Node<A> n = this.head;

		while(n != null && n.next != null && i < index) {
			n = n.next;
			i++;
		}

		return n.val;
	}

	/**
	 * Add Element at head of list
	 * @param n Element to add
	 */
	public void addFirst(A n) {

		Node<A> node = new Node<A>(n, this.head);
		this.head = node;

	}

	/**
	 * Add Elemenet at tail of list
	 * @param n Element to add
	 */
	public void addLast(A n) {

		if(this.isEmpty()) {
			this.head = new Node<A>(n, null);
			return;
		}

		Node<A> node = this.head;
		
		while(node.next != null) {
			node = node.next;
		}

		node.next = new Node<A>(n, null);

	}

	/**
	 * Remove first element in list and return it
	 * @return firts element in list
	 */
	public A removeFirst() {

		if(this.isEmpty()) {
			return null;
		}

		Node<A> node = this.head;
		this.head = node.next;
		return node.val;

	}

	/**
	 * Remove last element in list and return it
	 * @return last element in list
	 */
	public A removeLast() {
		
		if(this.isEmpty()) {
			return null;
		}

		Node<A> p_node = null;
		Node<A> node = this.head;
		
		while(node.next != null) {
			p_node = node;
			node = node.next;
		}
	
		if(p_node != null) {
			p_node.next = null;
		} else {
			this.head = null;
		}

		return node.val;
	
	}

	/**
	 * Alias for addLast
	 * required by Interface QueueI
	 */
	public void enqueue(A n) {
		this.addLast(n);	
	}

	/**
	 * Alias for removeFirst
	 * required by Interface QueueI
	 */
	public A dequeue() {
		return this.removeFirst();
	}

	/**
	 * Custom toString Formatter
	 */
	public String toString() {

		String s = "[ ";
		Node<A> node = this.head;

		while(node != null) {
			s += node + " ";
			node = node.next;
		}
		return s + "]";
	}

	/**
	 * List Node Type
	 */
	private class Node<A> {

		private A val;
		private Node<A> next = null;
	
		/**
		 * CTOR
		 * @param v Element the Node holds
		 * @param l Child Element to init the node with
		 */	
		Node(A v, Node<A> l) {

			this.val = v;
			this.next = l;

		}

		/**
		 * Custom toString Formatter
		 */
		public String toString() {
			return this.val + "";
		}
	}
}

