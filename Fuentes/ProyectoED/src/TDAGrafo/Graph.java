package TDAGrafo;

/**
 * Interface Graph
 */
public interface Graph<V, E> {
	
	/**
	 * Devuelve una colección iterable con todos los vértices del grafo.
	 * @return Una colección iterable con todos los vértices del grafo.
	 */
	public Iterable<Vertex<V>> vertices();
	
	/**
	 * Devuelve una colección iterable con todos los arcos del grafo.
	 * @return Una colección iterable con todos los arcos del grafo.
	 */
	public Iterable<Edge<E>> edges();
	
	/**
	 * Devuelve una colección iterable con todos los arcos incidentes sobre el vértice v.
	 * @param v Vértice a examinar.
	 * @return Una colección iterable con todos los arcos incidentes sobre el vértice v.
	 * @throws InvalidVertexException si el vértice es nula.
	 */
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException;
	
	/**
	 * Devuelve una colección iterable con todos los arcos emergentes sobre el vértice v.
	 * @param v Vértice a examinar.
	 * @return Una colección iterable con todos los arcos incidentes sobre el vértice v.
	 * @throws InvalidVertexException si el vértice es nula.
	 */
	public Iterable<Edge<E>> emergentEdges(Vertex<V> v) throws InvalidVertexException;
	
	/**
	 * Devuelve el otro vértice w del arco e=(v,w).
	 * @param v Vértice a examinar.
	 * @param e Arco a examinar.
	 * @return el otro vértice w del arco e=(v,w).
	 * @throws InvalidVertexException si el vértice es nulo.
	 * @throws InvalidEdgeException si el arco es nulo o si el arco no es incidente o emergente de v.
	 */
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidVertexException, InvalidEdgeException;
	
	/**
	 * Devuelve un arreglo (de 2 componentes) conteniendo los vértices del arco.
	 * @param e Arco a examinar.
	 * @return Un arreglo (de 2 componentes) conteniendo los vértices del arco.
	 * @throws InvalidEdgeException si el arco es nulo.
	 */
	public Vertex<V> [] endVertices(Edge<E> e) throws InvalidEdgeException;
	
	/**
	 * Testea si los vértices v y w son adyacentes.
	 * @param v
	 * @param w
	 * @return True si los vértices v y w son adyacentes, False en caso contrario.
	 * @throws InvalidVertexException si el o los vértices v y w son nulos.
	 */
	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) throws InvalidVertexException;
	
	/**
	 * Reemplaza el rótulo del vértice con x.
	 * @param v Vértice que será reemplazado su rótulo.
	 * @param x Rótulo a reemplazar.
	 * @return El rótulo reemplazado.
	 * @throws InvalidVertexException si el vértice es nulo.
	 */
	public V replace( Vertex<V> v, V x) throws InvalidVertexException;
	
	/**
	 * Reemplaza el rótulo del arco con x.
	 * @param e Arco que será reemplazado su rótulo.
	 * @param x Rótulo a reemplazar.
	 * @return El rótulo reemplazado.
	 * @throws InvalidEdgeException si el arco es nulo.
	 */
	public E replace( Edge<E> e, E x) throws InvalidEdgeException;
	
	/**
	 * Inserta un nuevo vértice con rótulo x.
	 * @param x Rótulo del vértice nuevo.
	 * @return El nuevo vértice.
	 */
	public Vertex<V> insertVertex(V x);
	
	/**
	 * Inserta un nuevo arco con rótulo x.
	 * @param v Vértice predecesor del nuevo arco.
	 * @param w Vértice sucesor del nuevo arco.
	 * @param x Rótulo del nuevo arco.
	 * @return El nuevo arco.
	 * @throws InvalidVertexException si el vértice es nulo.
	 */
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E x) throws InvalidVertexException;
	
	/**
	 * Elimina el vértice v y todos sus arcos adyacentes.
	 * @param v Vértice a eliminar.
	 * @return El rótulo del vértice a eliminar.
	 * @throws InvalidVertexException si el vértice es nulo.
	 */
	public V removeVertex(Vertex<V> v) throws InvalidVertexException;
	
	/**
	 * Elimina el arco e.
	 * @param e Arco a eliminar.
	 * @return El rótulo del arco a eliminar.
	 * @throws InvalidEdgeException si el arco es nulo.
	 */
	public E removeEdge(Edge<E> e) throws InvalidEdgeException;
	
}
