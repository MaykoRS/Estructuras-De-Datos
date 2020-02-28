package TDAMapeo;

/**
 * Interface Entry.
 * 
 * @author [GT] Michael Goodrich &amp; Roberto Tamassia. Data Structures and Algorithms in Java. Fourth Edition. John Wiley and Sons. 2006.
 */
public interface Entry<K,V> {
	
	/**
	 * Devuelve la clave almacenada en esta entrada.
	 * @return Clave de la entrada.
	 */
	public K getKey();
	
	/**
	 * Devuelve el valor almacenado en esta entrada.
	 * @return Valor de la entrada.
	 */
	public V getValue();

}
