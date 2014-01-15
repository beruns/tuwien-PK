/**
 * Interface for FIFO Data Queue
 * Data needs to be of type A
 * @author Georg Hubingeri (9947673)
 * @version 0.1
 */
public interface QueueI<A> {

	/**
	 * Add Element of Type A to queue
	 * @param n Element of type A to append to Queue
	 */
	public void enqueue(A n);

	/**
	 * Give back first Element in Queue and remove it
	 * @return first Elemen in Queue. Shall return null if Queue is empty
	 */
	public A dequeue();

	
}
