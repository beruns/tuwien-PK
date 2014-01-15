import java.util.Iterator;

public class MyStringArrayIterator implements Iterator<String> {

	private String[] storage = null;
	private int current = -1;

	public MyStringArrayIterator(String[] array) {
		this.storage = array;
	}

	public boolean hasNext() {
		return (this.current + 1 < storage.length);
	}

	public String next() {
		return this.storage[++current];
	}

	public void remove() {

		/*	
		for(int i = this.current; i < this.storage.length - 1 ; i++) {
			this.storage[i] = this.storage[i+1];
		}
	
		this.storage[this.storage.length - 1] = null;
		
		this.current--;
		*/
	
		String[] newArray = new String[this.storage.length - 1];
		int i;

		for(i = 0; i < this.current; i++) {
			newArray[i] = this.storage[i];
		}
	
		for(i = this.current; i < newArray.length; i++) {
			newArray[i] = this.storage[i + 1];
		}
	
		this.current--;	
		this.storage = newArray;
	}

	public static void main(String args[]) {

		String[] ar = {"a", "b", "d", "j", "a"}; //{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		String s;

		MyStringArrayIterator it = new MyStringArrayIterator(ar);

		System.out.println(printarr(it.storage));

		while(it.hasNext()) {
			s = it.next();
			if(s != null) {
				if(s.equals("a") || s.equals("d") || s.equals("j")) {
					it.remove();
				}
			}
		}

		System.out.println(printarr(ar));
		

	}

	private static String printarr(String[] ar) {
		String s = "[";
		for(int i = 0; i < ar.length; i++) {
			if( ar[i] != null ) {
				s += ar[i];
				if(i < ar.length - 1 && ar[i+1] != null) s += " ";
			}
		}
		return s + "]";
	}

}
