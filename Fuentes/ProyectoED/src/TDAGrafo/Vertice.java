package TDAGrafo;

import TDALista.MiLista;
import TDALista.Position;
import TDALista.PositionList;

/**
 * Clase Vértice
 */
public class Vertice<V, E> implements Vertex<V> {

	private V rotulo;
	private PositionList<Arco<V,E>> entrantes, salientes;
	private Position<Vertice<V,E>> posicionEnNodos;
	
	/**
	 * Creo un constructor con un rótulo.
	 * @param rotulo Rótulo del vértice.
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
	 * Establece un rótulo para un vértice.
	 * @param x Rótulo de un vértice a establecer.
	 */
	public void setElement(V x){
		rotulo = x;
	}
	
	/**
	 * Devuelve una lista de arcos salientes de un vértice.
	 * @return Una lista de arcos salientes de un vértice.
	 */
	public PositionList<Arco<V,E>> getArcosSalientes(){
		return salientes;
	}
	
	/**
	 * Devuelve una lista de arcos entrantes de un vértice.
	 * @return Una lista de arcos entrantes de un vértice.
	 */
	public PositionList<Arco<V,E>> getArcosEntrantes(){
		return entrantes;
	}
	
	/**
	 * Devuelve la posición del vértice.
	 * @return La posición del vértice.
	 */
	public Position<Vertice<V,E>> getPosicionEnNodos(){
		return posicionEnNodos;
	}
	
	/**
	 * Establece la nueva posición del vértice.
	 * @param p Posición nueva a establecer.
	 */
	public void setPosicionEnNodos(Position<Vertice<V,E>> p){
		posicionEnNodos = p;
	}
	
}
