import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<A> {

	private class MyListIterator implements Iterator<A> {

		MyList<A> list = null;

		Node next = null;
		Node curr = null;
		Node prev = null;

		MyListIterator(MyList<A> list) {

			this.list = list;
			this.next = list.head;

		}
	
		public boolean hasNext() {
			return (this.next != null);

		}

		public A next() {

			if(this.next == null) throw new NoSuchElementException();		
	
			if(this.curr != null) this.prev = this.curr;
			this.curr = this.next;
			this.next = this.next.next;
			
			return this.curr.value;
		}

		public void remove() {
			if(this.prev == null) {
				this.list.head = this.curr.next;
			} else {
				this.prev.next = this.curr.next;
			}
			this.curr = null;
		}
	
	}

	private class Node {

		A value;
		Node next;
	
		Node(A value, Node next) {
			this.value = value;
			this.next = next;
		}

		public String toString() {
			return this.value.toString();
		}
	}

	private Node head = null;
	
	public void add(A a) {
		this.head = new Node(a, this.head);
	}

	public void remove(A val) {

		A curr = null; 
		MyListIterator it = new MyListIterator(this);
	
		while(it.hasNext()) {
			curr = it.next();
			if(curr.equals(val)) {
				it.remove();
			}
		}
		

	}

	public String toString() {

		MyListIterator it = new MyListIterator(this);

		String s ="[";
		while(it.hasNext()) {
			s += it.next().toString();
			if(it.hasNext()) s += " " ;
		}
		
		return s += "]";
	}

	public static void main(String args[]) {
	
		MyList<String> l = new MyList<String>();

		l.add("A");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("B");
		l.add("C");
		l.add("D");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("E");
		l.add("F");
		l.add("G");
		l.add("H");
		l.add("I");
		l.add("J");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("G");
		l.add("G");

		System.out.println(l);
		l.remove("G");
		System.out.println(l);
				

	}
	

}

