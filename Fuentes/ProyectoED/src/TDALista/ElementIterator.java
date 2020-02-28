package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase ElementIterator.
 * 
 * @author Mayko Rodríguez.
 *
 */
public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	public ElementIterator(PositionList<E> l){
		list = l;
		try{
		if(list.isEmpty())
			cursor = null;
		else
			cursor = list.first();
		} catch (EmptyListException e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean hasNext(){
		return cursor != null;
	}
	
	public E next() throws NoSuchElementException {
		if(cursor == null)
			throw new NoSuchElementException("Cursor es nulo");
		try{
		E elem = cursor.element();
		if (cursor == list.last())
			cursor = null;
		else
			cursor = list.next(cursor);
		
		
		return elem;
		
		} catch(EmptyListException | BoundaryViolationException | InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

}
