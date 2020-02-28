package TDALista;

import java.util.Iterator;

/**
 * Clase MiLista.
 * 
 * @author Mayko Rodríguez.
 *
 * @param <E> Tipo de elementos de la lista.
 * 
 */
public class MiLista<E> implements PositionList<E> {
	
	protected DNodo<E> header, trailer;
	protected int cant;
	
	/**
	 * Creo una lista vacía.
	 */
	public MiLista(){
		header = new DNodo<E>(null,null,null);
		trailer = new DNodo<E>(header,null,null);
		header.setNext(trailer);
		cant = 0;
	}
	
	public int size(){
		return cant;
	}
	
	public boolean isEmpty(){
		return cant == 0;
	}

	public Position<E> first() throws EmptyListException {
		if(isEmpty())
			throw new EmptyListException("¡ La Lista está vacía !");
		return header.getNext();
	}
	
	public Position<E> last() throws EmptyListException {
		if(isEmpty())
			throw new EmptyListException("La lista está vacía");
		return trailer.getPrev();
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException { 
		DNodo<E> nuevo = checkPosition(p);
		if( nuevo == trailer.getPrev())
			throw new BoundaryViolationException("Violacion de los límites de la lista");
		return nuevo.getNext();
	}
	
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> nuevo = checkPosition(p);
		if(nuevo == header.getNext())
			throw new BoundaryViolationException("Violacion de los limites de la lista");
		return nuevo.getPrev();
	}
	
	protected DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if(p == null)
				throw new InvalidPositionException("Posición nula pasada a la lista");
		if(p == header)
			throw new InvalidPositionException("Nodo header no es una posición válida");
		if(p == trailer)
			throw new InvalidPositionException("Nodo trailer no es una posición válida");
		
		try{
			DNodo<E> temp = (DNodo<E>) p;
			if((temp.getPrev() == null) || (temp.getNext() == null))
				throw new InvalidPositionException("Posición no pertenece a una lista válida");
			return temp;
		} catch (ClassCastException e){
			throw new InvalidPositionException("Posición es de tipo incorrecto para una lista");
		}
	}
	
	public void addFirst(E elem){
		DNodo<E> nuevo = new DNodo<E>(header,header.getNext(),elem);
		nuevo.getNext().setPrev(nuevo);
		header.setNext(nuevo);
		cant++;
	}
	
	public void addLast(E elem){
		DNodo<E> nuevo = new DNodo<E>(trailer.getPrev(),trailer,elem);
		nuevo.getPrev().setNext(nuevo);
		trailer.setPrev(nuevo);
		cant++;
	}
	
	public void addBefore(Position<E> p, E elem) throws InvalidPositionException {
		DNodo<E> v = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(v.getPrev(),v,elem);
		v.getPrev().setNext(nuevo);
		v.setPrev(nuevo);
		cant++;
		
	}
	
	public void addAfter(Position<E> p, E elem) throws InvalidPositionException {
		DNodo<E> v = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(v,v.getNext(),elem);
		v.getNext().setPrev(nuevo);
		v.setNext(nuevo);
		cant++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException {
		DNodo<E> v = checkPosition(p);
		E elem = v.element();
		DNodo<E> anterior = v.getPrev();
		DNodo<E> siguiente = v.getNext();
		anterior.setNext(siguiente);
		siguiente.setPrev(anterior);
		//Corto los enlaces del nodo removido
		v.setNext(null);
		v.setPrev(null);
		cant--;
		return elem;
	}

	public E set(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> v = checkPosition(p);
		E elem = v.element();
		v.setElement(element);
		return elem;
	}
	
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> L = new MiLista<Position<E>>();
		DNodo<E> n = header.getNext();
		while( n != trailer){
			L.addLast(n);
			n = n.getNext();
		}
		return L;
	}
	
	public Iterator<E> iterator(){
		return (new ElementIterator<E>(this));
	}

}
