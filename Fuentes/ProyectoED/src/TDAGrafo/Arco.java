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
	 * Crea un arco con un r�tulo, un v�rtice predecesor y un v�rtice sucesor.
	 * @param rotulo R�tulo del Arco.
	 * @param predecesor V�rtice predecesor del arco.
	 * @param sucesor V�rtice sucesor del arco.
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
	 * Establece un nuevo r�tulo para un arco.
	 * @param x R�tulo a establecer.
	 */
	public void setElement(E x){
		rotulo = x;
	}
	
	/**
	 * Devuelve el v�rtice predecesor.
	 * @return El v�rtice predecesor.
	 */
	public Vertice<V,E> getPredecesor(){
		return predecesor;
	}
	
	/**
	 * Devuelve el v�rtice sucesor.
	 * @return El v�rtice sucesor.
	 */
	public Vertice<V,E> getSucesor(){
		return sucesor;
	}
	
	/**
	 * Devuelve la posici�n de un arco del v�rtice sucesor.
	 * @return La posici�n de un arco del v�rtice sucesor.
	 */
	public Position<Arco<V,E>> getPosicionEntrante(){
		return posEntrante;
	}
	
	/**
	 * Establece la posici�n de un arco del v�rtice sucesor.
	 * @param p Posici�n de un arco del v�rtice sucesor a establecer.
	 */
	public void setPosicionEntrante(Position<Arco<V,E>> p){
		posEntrante = p;
	}
	
	/**
	 * Devuelve la posici�n de un arco del v�rtice predecesor.
	 * @return Posici�n de un arco del v�rtice predecesor.
	 */
	public Position<Arco<V,E>> getPosicionSaliente(){
		return posSaliente;
	}
	
	/**
	 * Establece la posici�n de un arco del v�rtice predecesor.
	 * @param p Posici�n de un arco del v�rtice predecesor a establecer.
	 */
	public void setPosicionSaliente(Position<Arco<V,E>> p){
		posSaliente = p;
	}
	
	/**
	 * Devuelve la posici�n del arco.
	 * @return La posici�n de arco.
	 */
	public Position<Arco<V,E>> getPosicionArco(){
		return posicion;
	}
	
	/**
	 * Establece la nueva posici�n del arco.
	 * @param p Posici�n de arco a establecer.
	 */
	public void setPosicionArco(Position<Arco<V,E>> p){
		posicion = p;
	}
	
}
