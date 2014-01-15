/**
 * Reverts the Comparision Operator of a Comparable Object
 * @author Georg Hubinger (9947673)
 * @version 0.1
 */
public class ReverseComparator<A extends Comparable<A>> implements java.util.Comparator<A> {

	/**
	 * Revert outoup of A's compareTo
	 * @param n1 First Object to Compare
	 * @param n2 Second Object to Compare
	 * @return Inverted output of n1.compareTo(n2)
	 */
	public int compare(A n1, A n2) {
		return n1.compareTo(n2) * -1;
	}

}
