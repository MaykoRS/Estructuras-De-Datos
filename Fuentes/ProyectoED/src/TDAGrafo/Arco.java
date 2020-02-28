package TDAGrafo;

import TDALista.Position;

/**
 * Clase Arco
 */
public class Arco<V, E> implements Edge<E> {

	private E rotulo;
	private Vertice<V,E> sucesor, predecesor;
	private Position<Arco<V,E>> posEntrante, posSaliente;
	private Position<Arco<V,E>> posicion;
	
	/**
	 * Crea un arco con un rótulo, un vértice predecesor y un vértice sucesor.
	 * @param rotulo Rótulo del Arco.
	 * @param predecesor Vértice predecesor del arco.
	 * @param sucesor Vértice sucesor del arco.
	 */
	public Arco(E rotulo, Vertice<V,E> predecesor, Vertice<V,E> sucesor){
		this.rotulo = rotulo;
		this.predecesor = predecesor;
		this.sucesor =  sucesor;
	}
	
	public E element(){
		return rotulo;
	}
	
	/**
	 * Establece un nuevo rótulo para un arco.
	 * @param x Rótulo a establecer.
	 */
	public void setElement(E x){
		rotulo = x;
	}
	
	/**
	 * Devuelve el vértice predecesor.
	 * @return El vértice predecesor.
	 */
	public Vertice<V,E> getPredecesor(){
		return predecesor;
	}
	
	/**
	 * Devuelve el vértice sucesor.
	 * @return El vértice sucesor.
	 */
	public Vertice<V,E> getSucesor(){
		return sucesor;
	}
	
	/**
	 * Devuelve la posición de un arco del vértice sucesor.
	 * @return La posición de un arco del vértice sucesor.
	 */
	public Position<Arco<V,E>> getPosicionEntrante(){
		return posEntrante;
	}
	
	/**
	 * Establece la posición de un arco del vértice sucesor.
	 * @param p Posición de un arco del vértice sucesor a establecer.
	 */
	public void setPosicionEntrante(Position<Arco<V,E>> p){
		posEntrante = p;
	}
	
	/**
	 * Devuelve la posición de un arco del vértice predecesor.
	 * @return Posición de un arco del vértice predecesor.
	 */
	public Position<Arco<V,E>> getPosicionSaliente(){
		return posSaliente;
	}
	
	/**
	 * Establece la posición de un arco del vértice predecesor.
	 * @param p Posición de un arco del vértice predecesor a establecer.
	 */
	public void setPosicionSaliente(Position<Arco<V,E>> p){
		posSaliente = p;
	}
	
	/**
	 * Devuelve la posición del arco.
	 * @return La posición de arco.
	 */
	public Position<Arco<V,E>> getPosicionArco(){
		return posicion;
	}
	
	/**
	 * Establece la nueva posición del arco.
	 * @param p Posición de arco a establecer.
	 */
	public void setPosicionArco(Position<Arco<V,E>> p){
		posicion = p;
	}
	
}
