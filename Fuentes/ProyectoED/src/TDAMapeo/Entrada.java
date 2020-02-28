package TDAMapeo;

/**
 * Clase Entrada.
 * 
 * @author Mayko Rodríguez.
 *
 */
public class Entrada<K, V> implements Entry<K,V> {
	private K key;
	private V value;
	
	/**
	 * Creo una entrada.
	 * @param key Clave de la entrada.
	 * @param value Valor de la entrada.
	 */
	public Entrada(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey(){
		return this.key;
	}
	
	/**
	 * Establece una nueva clave.
	 * @param key Clave a establecer.
	 */
	public void setKey(K key){
		this.key = key;
	}
	
	public V getValue(){
		return this.value;
	}
	
	/**
	 * Establece un nuevo valor.
	 * @param value Valor a establecer.
	 */
	public void setValue(V value){
		this.value = value;
	}

}
