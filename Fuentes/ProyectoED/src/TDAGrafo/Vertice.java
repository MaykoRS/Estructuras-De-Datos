package TDAGrafo;

import TDALista.MiLista;
import TDALista.Position;
import TDALista.PositionList;

/**
 * Clase V�rtice
 */
public class Vertice<V, E> implements Vertex<V> {

	private V rotulo;
	private PositionList<Arco<V,E>> entrantes, salientes;
	private Position<Vertice<V,E>> posicionEnNodos;
	
	/**
	 * Creo un constructor con un r�tulo.
	 * @param rotulo R�tulo del v�rtice.
	 */
	public Vertice(V rotulo){
		this.rotulo = rotulo;
		entrantes = new MiLista<Arco<V,E>>();
		salientes = new MiLista<Arco<V,E>>();
	}
	
	public V element() {
		return rotulo;
	}
	
	/**
	 * Establece un r�tulo para un v�rtice.
	 * @param x R�tulo de un v�rtice a establecer.
	 */
	public void setElement(V x){
		rotulo = x;
	}
	
	/**
	 * Devuelve una lista de arcos salientes de un v�rtice.
	 * @return Una lista de arcos salientes de un v�rtice.
	 */
	public PositionList<Arco<V,E>> getArcosSalientes(){
		return salientes;
	}
	
	/**
	 * Devuelve una lista de arcos entrantes de un v�rtice.
	 * @return Una lista de arcos entrantes de un v�rtice.
	 */
	public PositionList<Arco<V,E>> getArcosEntrantes(){
		return entrantes;
	}
	
	/**
	 * Devuelve la posici�n del v�rtice.
	 * @return La posici�n del v�rtice.
	 */
	public Position<Vertice<V,E>> getPosicionEnNodos(){
		return posicionEnNodos;
	}
	
	/**
	 * Establece la nueva posici�n del v�rtice.
	 * @param p Posici�n nueva a establecer.
	 */
	public void setPosicionEnNodos(Position<Vertice<V,E>> p){
		posicionEnNodos = p;
	}
	
}
