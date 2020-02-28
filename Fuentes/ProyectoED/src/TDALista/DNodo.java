package TDALista;

/**
 * Clase DNodo.
 * 
 * @author Mayko Rodríguez.
 */

public class DNodo<E> implements Position<E>{
	
	private DNodo<E> prev, next;
	private E elem; 
	
	/**
	 * Creo un contructor con 3 parámetros.
	 * @param p DNodo anterior.
	 * @param n DNodo siguiente.
	 * @param e Elemento.
	 */
	public DNodo(DNodo<E> p, DNodo<E> n, E e){
		prev = p;
		next = n;
		elem = e;
	}
	
	
	public E element() { 
		return elem;
	}
	
	/**
	 * Establece un nuevo elemento.
	 * @param e Elemento nuevo a establecer.
	 */
	public void setElement(E e){
		elem = e;
	}
	
	/**
	 * Devuelve un DNodo anterior a la actual.
	 * @return Nodo anterior a la actual.
	 */
	public DNodo<E> getPrev(){
		return prev;
	}
		
	/**
	 * Establece un DNodo anterior.
	 * @param p Nodo anterior a establecer.
	 */
	public void setPrev(DNodo<E> p){
		prev = p;
	}
	
	/**
	 * Devuelve un DNodo siguiente a la actual.
	 * @return Nodo siguiente a la actual.
	 */
	public DNodo<E> getNext(){
		return next;
	}
	
	/**
	 * Establece un DNodo siguiente.
	 * @param n Nodo siguiente a establecer.
	 */
	public void setNext(DNodo<E> n){
		next = n;
	}
	
}
