
/**
 * An interface for MyQ
 * 
 * @author mahmoud
 *
 * @param <E> the type to be stored in the DataStructure
 */
public interface DataStructure<E> {
	public void add(E item);
	public E remove();
	public boolean isEmpty();
}