package TDAGrafo;

import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.MiLista;
import TDALista.PositionList;

/**
 * Clase MiGrafo, implementa los métodos de la interface Graph.
 * 
 * @author Mayko Rodríguez
 *
 * @param <V> Tipo de los rótulos del Vértice.
 * @param <E> Tipo de los rótulos del Arco.
 */
public class MiGrafo<V,E> implements Graph<V,E> {

	protected PositionList<Vertice<V,E>> nodos;
	protected PositionList<Arco<V,E>> arcos;
	
	public MiGrafo(){
		nodos = new MiLista<Vertice<V,E>>();
		arcos = new MiLista<Arco<V,E>>();
	}
	
	public Iterable<Vertex<V>> vertices(){
		PositionList<Vertex<V>> L = new MiLista<Vertex<V>>();
		for(Vertex<V> h : nodos)
			L.addLast(h);
		return L;
	}
	
	public Iterable<Edge<E>> edges(){
		PositionList<Edge<E>> L = new MiLista<Edge<E>>();
		for(Edge<E> h : arcos)
			L.addLast(h);
		return L;
	}
	
	private Vertice<V,E> checkVertex(Vertex<V> v) throws InvalidVertexException {
		try {
			if(v == null)
				throw new InvalidVertexException("Vértice nula");
			Vertice<V,E> vv = (Vertice<V,E>) v;
			return vv;
		} catch (ClassCastException e) {
			throw new InvalidVertexException("Vértice inválido");
		}
	}
	
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException {
		Vertice<V,E> vv = checkVertex(v);
		PositionList<Edge<E>> L = new MiLista<Edge<E>>();
		for(Edge<E> h : vv.getArcosEntrantes())
			L.addLast(h);
		return L;
	}
	
	public Iterable<Edge<E>> emergentEdges(Vertex<V> v) throws InvalidVertexException {
		Vertice<V,E> vv = checkVertex(v);
		PositionList<Edge<E>> L = new MiLista<Edge<E>>();
		for(Edge<E> h : vv.getArcosSalientes())
			L.addLast(h);
		return L;
	}
	
	private Arco<V,E> checkEdge(Edge<E> e) throws InvalidEdgeException {
		try {
			if(e == null)
				throw new InvalidEdgeException("Arco inválido");
			Arco<V,E> ee = (Arco<V,E>)e;
			return ee;
		} catch (ClassCastException e2) {
			throw new InvalidEdgeException("Arco inválido");
		}
	}
	
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidEdgeException, InvalidVertexException {
		Vertice<V,E> vv = checkVertex(v);
		Arco<V,E> ee = checkEdge(e);
		if( vv != ee.getPredecesor() && vv != ee.getSucesor())
			throw new InvalidEdgeException("Vertice v y Arco e no tienen alguna relación");
		
		if(ee.getPredecesor() == vv)
			return ee.getSucesor();
		else
			return ee.getPredecesor();
		
	}
	
	public Vertex<V> [] endVertices(Edge<E> e) throws InvalidEdgeException {
		Arco<V,E> ee = checkEdge(e);
		Vertex<V> [] S = (Vertex<V> []) new Vertice[2];
		S[0] = ee.getPredecesor();
		S[1] = ee.getSucesor();
		return S;
	}
	
	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) throws InvalidVertexException {
		Vertice<V,E> vv = checkVertex(v);
		Vertice<V,E> ww = checkVertex(w);
		for( Arco<V,E> h : vv.getArcosSalientes())
			if( h.getSucesor() == ww )
				return true;
		for( Arco<V,E> h : vv.getArcosEntrantes())
			if( h.getPredecesor() == ww )
				return true;
		
		return false;
	}
	
	public V replace(Vertex<V> v , V x) throws InvalidVertexException {
		Vertice<V,E> vv = checkVertex(v);
		V aux = vv.element();
		vv.setElement(x);
		return aux;
	}
	
	public E replace(Edge<E> e, E x) throws InvalidEdgeException {
		Arco<V,E> ee = checkEdge(e);
		E aux = ee.element();
		ee.setElement(x);
		return aux;
	}
	
	public Vertex<V> insertVertex(V x){
		Vertice<V,E> vv = new Vertice<V,E>(x);
		try {
			nodos.addLast(vv);
			vv.setPosicionEnNodos(nodos.last());
		} catch (EmptyListException exc) {
			System.out.println(exc.getMessage());
		}
		return vv;
	}	
	
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E x) throws InvalidVertexException {
		Vertice<V,E> vv = checkVertex(v);
		Vertice<V,E> ww = checkVertex(w);
		Arco<V,E> ee = new Arco<V,E>(x,vv,ww);
		try {
			arcos.addLast(ee);
			ee.setPosicionArco(arcos.last());
			ee.getPredecesor().getArcosSalientes().addLast(ee);
			ee.setPosicionSaliente(ee.getPredecesor().getArcosSalientes().last());
			ee.getSucesor().getArcosEntrantes().addLast(ee);
			ee.setPosicionEntrante(ee.getSucesor().getArcosEntrantes().last());
		} catch (EmptyListException exc) {
			System.out.println(exc.getMessage());
		}
		return ee;
	}
	
	public V removeVertex(Vertex<V> v) throws InvalidVertexException {
		Vertice<V,E> vv = checkVertex(v);
		V aux = vv.element();
		try {
			for(Arco<V,E> h : vv.getArcosSalientes()){
				vv.getArcosSalientes().remove(h.getPosicionSaliente());
				arcos.remove(h.getPosicionArco());
				h.getSucesor().getArcosEntrantes().remove(h.getPosicionEntrante());
			}
			for(Arco<V,E> h : vv.getArcosEntrantes()){
				vv.getArcosEntrantes().remove(h.getPosicionEntrante());
				arcos.remove(h.getPosicionArco());
				h.getPredecesor().getArcosSalientes().remove(h.getPosicionSaliente());
			}
			nodos.remove(vv.getPosicionEnNodos());
			return aux;
			
		} catch (InvalidPositionException exc) {
			System.out.println(exc.getMessage());
		}
		return null;
	}
	
	public E removeEdge(Edge<E> e) throws InvalidEdgeException {
		Arco<V,E> ee = checkEdge(e);
		E aux = ee.element();
		try {
			ee.getPredecesor().getArcosSalientes().remove(ee.getPosicionSaliente());
			ee.getSucesor().getArcosEntrantes().remove(ee.getPosicionEntrante());
			arcos.remove(ee.getPosicionArco());
			
			return aux;
		} catch (InvalidPositionException exc) {
			System.out.println(exc.getMessage());
		}
		return null;
	}
	
}
