import java.util.ArrayDeque;

/**
 * A queue created using the ArrayDeque
 * 
 * @author mahmoud
 *
 * @param <E> The type of the data to store in the Queue
 */
public class MyQ<E> implements DataStructure<E> {
	ArrayDeque<E> deque;
	
	public MyQ() {
		deque = new ArrayDeque<E>();
	}
	
	@Override
	public void add(E item) {
		deque.add(item);
	}

	@Override
	public E remove() {
		if (isEmpty())
			return null;
		return deque.removeFirst();
	}

	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

}
