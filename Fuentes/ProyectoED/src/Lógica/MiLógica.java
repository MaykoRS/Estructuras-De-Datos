package Lógica;

import TDAGrafo.*;
import TDAMapeo.*;
import TDALista.*;
import TDACola.*;

/**
 * Clase MiLógica.
 * 
 * @author Mayko Rodríguez.
 *
 */
public class MiLógica {
	
	Graph<Integer,Integer> graf;	
	
	/**
	 * Carga un grafo.
	 */
	public void cargarGrafo(){
		graf = new MiGrafo<Integer,Integer>();
	}
	
	
	/**
	 * Agrega un vértice con rótulo n en el grafo.
	 * @param n El rótulo del vértice.
	 */
	public void agregarVertice(int n){
		graf.insertVertex(n);
	}
	
	
	/**
	 * Agrega un arco entre el vértice con rótulo n y el vértice con rótulo m.
	 * @param n Vértice predecesor del arco creado.
	 * @param m Vértice sucesor del arco creado.
	 */
	public boolean agregarArco(int n, int m){
		try{
			Vertex<Integer> origen = buscarVertice(n);
			Vertex<Integer> destino = buscarVertice(m);
			if( origen != null && destino != null){
				graf.insertEdge(origen, destino, null);
				return true;
			}
		} catch(InvalidVertexException exc){
			System.out.println(exc.getMessage());
		}
		return false;
	}
	
	
	/**
	 * Elimina un vértice con rótulo n.
	 * @param n Rótulo del vértice a eliminar.
	 */
	public boolean eliminarVertice(int n){
		try{
			Vertex<Integer> v = buscarVertice(n);
			if( v != null){
				graf.removeVertex(v);
				return true;
			}
			
		} catch(InvalidVertexException exc){
			System.out.println(exc.getMessage());
		}
		return false;
	}
	
	private Vertex<Integer> buscarVertice(int n){
		for(Vertex<Integer> h : graf.vertices())
			if(h.element().equals(n))
				return h;
		return null;
	}
	
	
	/**
	 * Muestra los rótulos de los vértices al recorrer el grafo en profundidad (Depth-first search).
	 */
	public String DFSShell(){
		Map<Vertex<Integer>,Boolean> M = new MiMapeo<Vertex<Integer>,Boolean>();
		PositionList<Vertex<Integer>> L = new MiLista<Vertex<Integer>>();
		String str = "";
		try {
			for(Vertex<Integer> h : graf.vertices())
				M.put(h, false);
			
			for(Vertex<Integer> h : graf.vertices())
				if(!M.get(h))
					DFS(h,M,L);
			if(!L.isEmpty()){
				str+="{ ";
				for(Vertex<Integer> h : L)
					str+=h.element()+" ";
				str+="}";
			}
			
			return str;
		} catch (InvalidKeyException exc) {
			System.out.println(exc.getMessage());
		}
		return "";
	}
	
	private void DFS(Vertex<Integer> origen, Map<Vertex<Integer>,Boolean> M, PositionList<Vertex<Integer>> L){
		L.addLast(origen);
		try {
			M.put(origen, true);
			for(Edge<Integer> e : graf.emergentEdges(origen))
				if(!M.get(graf.opposite(origen, e)))
					DFS(graf.opposite(origen, e),M,L);
		} catch (InvalidKeyException | InvalidEdgeException | InvalidVertexException exc) {
			System.out.println(exc.getMessage());
		}
	
	}
	
	
	/**
	 * Muestra los rótulo de los vértices al recorrer el grafo en anchura (Breadth-first search).
	 */
	public String BFSShell(){
		Map<Vertex<Integer>,Boolean> M = new MiMapeo<Vertex<Integer>,Boolean>();
		String str = "";
		
		try {
			for(Vertex<Integer> v : graf.vertices())
				M.put(v, false);
				
			str+="{ ";
			for(Vertex<Integer> h : graf.vertices())
				if(!M.get(h)){
					str = BFS(h,M,str);
				}
			str+="}";
			
		} catch (InvalidKeyException exc) {
			System.out.println(exc.getMessage());
		}
		return str;
	}
	
	private String BFS(Vertex<Integer> origen, Map<Vertex<Integer>,Boolean> M, String str){
		try {
			Queue<Vertex<Integer>> C = new LinkedQueue<Vertex<Integer>>();
			C.enqueue(origen);
			M.put(origen,true);
			while(!C.isEmpty()){
				Vertex<Integer> aux = C.dequeue();
				str+=aux.element()+" ";
				
				for(Edge<Integer> h : graf.emergentEdges(aux))
					if(!M.get(graf.opposite(aux, h))){
							C.enqueue(graf.opposite(aux, h));
							M.put(graf.opposite(aux, h), true);
					}
			}
			
		} catch (InvalidKeyException | InvalidEdgeException | InvalidVertexException | EmptyQueueException exc) {
			System.out.println(exc.getMessage());
		}
		return str;
	}
	

	/**
	 * Muestra el camino más corto del vértice con rótulo A al vértice con rótulo B
	 * @param A Rótulo del vértice origen.
	 * @param B Rótulo del vértice destino.
	 */
	public String caminoMasCorto(int A, int B){
		Vertex<Integer> origen = buscarVertice(A);
		Vertex<Integer> destino = buscarVertice(B);
		
		if(origen != null && destino != null)
			return caminoMasCorto(origen,destino);
		return "";
	}
	
	private String caminoMasCorto(Vertex<Integer> o, Vertex<Integer> d){
		Map<Vertex<Integer>,Boolean> M = new MiMapeo<Vertex<Integer>,Boolean>();
		String str = "";
		try {
			for(Vertex<Integer> h : graf.vertices())
				M.put(h, false);
		} catch (InvalidKeyException exc) {
			System.out.println(exc.getLocalizedMessage());
		}
		PositionList<Vertex<Integer>> camino = new MiLista<Vertex<Integer>>();
		PositionList<PositionList<Vertex<Integer>>> S = new MiLista<PositionList<Vertex<Integer>>>();
		
		buscarCamino(o,d,camino,S,M);
		
		camino = caminoCorto(S);
		if( camino != null){
			str+="{ ";
			for(Vertex<Integer> h : camino)
				str += (h.element() + " ");
			str+="}";
		}
		
		return str;
		
	}
	
	private void buscarCamino(Vertex<Integer> origen, Vertex<Integer> destino, PositionList<Vertex<Integer>> cam,
			PositionList<PositionList<Vertex<Integer>>> S, Map<Vertex<Integer>,Boolean> M){
		try {
			cam.addLast(origen);
			M.put(origen,true);
			
			if(origen == destino){
				PositionList<Vertex<Integer>> aux = new MiLista<Vertex<Integer>>();
				for(Vertex<Integer> h : cam)
					aux.addLast(h);
				S.addLast(aux);
			}
			else{
				for(Edge<Integer> e : graf.emergentEdges(origen))
					if(!M.get(graf.opposite(origen, e)))
						buscarCamino(graf.opposite(origen, e), destino,cam,S,M);
			}
			
			M.put(origen, false);
			cam.remove(cam.last());
		} catch (InvalidKeyException | InvalidVertexException | InvalidEdgeException | InvalidPositionException | EmptyListException exc) {
			System.out.println(exc.getMessage());
		}
	}
	
	private PositionList<Vertex<Integer>> caminoCorto(PositionList<PositionList<Vertex<Integer>>> S){
		PositionList<Vertex<Integer>> corto = new MiLista<Vertex<Integer>>();
		try{
			if(!S.isEmpty())
				corto = S.first().element();
			
			for(PositionList<Vertex<Integer>> h : S)
				if(h.size() < corto.size())
					corto = h;
			
			if(corto.size() != 0)
				return corto;
			
		} catch ( EmptyListException exc){
			System.out.println(exc.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Muestra todos los caminos del vértice con rótulo A al vértice con rótulo B.
	 * @param A Rótulo del vértice origen.
	 * @param B Rótulo del vértice destino.
	 */
	public String todosLosCaminos(int A, int B){
		Vertex<Integer> origen = buscarVertice(A);
		Vertex<Integer> destino = buscarVertice(B);
		if(origen != null && destino != null)
			return todosLosCaminos(origen,destino);
		return "";
	}
	
	private String  todosLosCaminos(Vertex<Integer> o, Vertex<Integer> d){
		Map<Vertex<Integer>,Boolean> M = new MiMapeo<Vertex<Integer>,Boolean>();
		String str = "";
		
		PositionList<Vertex<Integer>> camino = new MiLista<Vertex<Integer>>();
		PositionList<PositionList<Vertex<Integer>>> todos = new MiLista<PositionList<Vertex<Integer>>>();
		try {
			for(Vertex<Integer> h : graf.vertices())
				M.put(h, false);
		
			buscarCamino(o,d,camino,todos,M);
			
			while( !todos.isEmpty()){
				PositionList<Vertex<Integer>> list = new MiLista<Vertex<Integer>>();
				list = todos.first().element();
				todos.remove(todos.first());
				str+="{ ";
				for(Vertex<Integer> h : list)
					str += (h.element() + " ");
				str+="}";
				str+= "\n";
			}
			
		} catch (InvalidKeyException | EmptyListException | InvalidPositionException exc) {
			System.out.println(exc.getLocalizedMessage());
		}
		return str;
	}
	

	/**
	 * Elimina del grafo todos los vértices que forman el camino más corto desde el vértice con rótulo A al vértice con rótulo B
	 * ( sin eliminar los vértices con rótulos A y B ).
	 * @param A Rótulo del vértice origen.
	 * @param B Rótulo del vértice destino.
	 */
	public boolean eliminarVertices(int A, int B){
		Vertex<Integer> origen = buscarVertice(A);
		Vertex<Integer> destino = buscarVertice(B);
		if(origen == null || destino == null)
			return false;
		else{
			return eliminarVertices(origen,destino);
		}
	}

	private boolean eliminarVertices(Vertex<Integer> o, Vertex<Integer> d) {
		Map<Vertex<Integer>,Boolean> M = new MiMapeo<Vertex<Integer>,Boolean>();
		PositionList<Vertex<Integer>> camino = new MiLista<Vertex<Integer>>();
		PositionList<PositionList<Vertex<Integer>>> todos = new MiLista<PositionList<Vertex<Integer>>>();
		
		try {
			for(Vertex<Integer> h : graf.vertices())
				M.put(h, false);
		
			buscarCamino(o,d,camino,todos,M);
			camino = caminoCorto(todos);
			
			if(camino != null){
				eliminar(camino);
				return true;
			}
			
		} catch (InvalidKeyException exc) {
			System.out.println(exc.getLocalizedMessage());
		}
		return false;
		
	}
	
	private void eliminar(PositionList<Vertex<Integer>> lista){
		try{ 
			if( !lista.isEmpty()){
				Position<Vertex<Integer>> pos = lista.first();
				
				while( pos != null ){
					if( pos != lista.first() && pos != lista.last())
						graf.removeVertex(pos.element());
					if( pos == lista.last())
						pos = null;
					else
						pos = lista.next(pos);	
				}
			}
			
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException | InvalidVertexException exc) {
			System.out.println(exc.getMessage());
		}
	}
	
}
