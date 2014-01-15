/**
 * Store Objects of Comparabe Type A (extends MyList)
 * @author Georg Hubinger (9947673)
 * @version 0.1
 */
public class MyCompList<A extends Comparable<A>> extends MyList<A> {

	/**
	 * Return the minimal Element in Queue based on what comp provides
	 * @param comp Comparator for A. If null then A's compareTo will be used
	 * @return first minimal element in list
	 */
	public A minimum(java.util.Comparator<A> comp) {
		
		if(this.isEmpty()) {
			return null;
		}

		A min = this.get(0);
		A curr = null;

		for(int i = 1; i < this.size(); i++) {


			curr = this.get(i);
		
			if(comp != null) {
			
				if(comp.compare(min, curr) > 0) {
					min = curr;
				}

			} else {

				if(min.compareTo(curr) > 0) {
					min = curr;
				}

			}
		}

		return min;
		
	}
	
	/**
	 * Return the minimal Element in Queue based on A's compareTo 
	 * @return first minimal element in list
	 */
	public A minimum() {

		return this.minimum(null);
		
		/*
		if(this.isEmpty()) {
			return null;
		}

		A min = this.get(0);
		A curr = null;

		for(int i = 1; i < this.size() - 1; i++) {
			curr = this.get(i);

			if(min.compareTo(curr) > 0) {
				min = curr;
			}
		}

		return min;
		*/
	}

}
