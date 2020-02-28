package TDAGrafo;

/**
 * Interface Graph
 */
public interface Graph<V, E> {
	
	/**
	 * Devuelve una colecci�n iterable con todos los v�rtices del grafo.
	 * @return Una colecci�n iterable con todos los v�rtices del grafo.
	 */
	public Iterable<Vertex<V>> vertices();
	
	/**
	 * Devuelve una colecci�n iterable con todos los arcos del grafo.
	 * @return Una colecci�n iterable con todos los arcos del grafo.
	 */
	public Iterable<Edge<E>> edges();
	
	/**
	 * Devuelve una colecci�n iterable con todos los arcos incidentes sobre el v�rtice v.
	 * @param v V�rtice a examinar.
	 * @return Una colecci�n iterable con todos los arcos incidentes sobre el v�rtice v.
	 * @throws InvalidVertexException si el v�rtice es nula.
	 */
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException;
	
	/**
	 * Devuelve una colecci�n iterable con todos los arcos emergentes sobre el v�rtice v.
	 * @param v V�rtice a examinar.
	 * @return Una colecci�n iterable con todos los arcos incidentes sobre el v�rtice v.
	 * @throws InvalidVertexException si el v�rtice es nula.
	 */
	public Iterable<Edge<E>> emergentEdges(Vertex<V> v) throws InvalidVertexException;
	
	/**
	 * Devuelve el otro v�rtice w del arco e=(v,w).
	 * @param v V�rtice a examinar.
	 * @param e Arco a examinar.
	 * @return el otro v�rtice w del arco e=(v,w).
	 * @throws InvalidVertexException si el v�rtice es nulo.
	 * @throws InvalidEdgeException si el arco es nulo o si el arco no es incidente o emergente de v.
	 */
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidVertexException, InvalidEdgeException;
	
	/**
	 * Devuelve un arreglo (de 2 componentes) conteniendo los v�rtices del arco.
	 * @param e Arco a examinar.
	 * @return Un arreglo (de 2 componentes) conteniendo los v�rtices del arco.
	 * @throws InvalidEdgeException si el arco es nulo.
	 */
	public Vertex<V> [] endVertices(Edge<E> e) throws InvalidEdgeException;
	
	/**
	 * Testea si los v�rtices v y w son adyacentes.
	 * @param v
	 * @param w
	 * @return True si los v�rtices v y w son adyacentes, False en caso contrario.
	 * @throws InvalidVertexException si el o los v�rtices v y w son nulos.
	 */
	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) throws InvalidVertexException;
	
	/**
	 * Reemplaza el r�tulo del v�rtice con x.
	 * @param v V�rtice que ser� reemplazado su r�tulo.
	 * @param x R�tulo a reemplazar.
	 * @return El r�tulo reemplazado.
	 * @throws InvalidVertexException si el v�rtice es nulo.
	 */
	public V replace( Vertex<V> v, V x) throws InvalidVertexException;
	
	/**
	 * Reemplaza el r�tulo del arco con x.
	 * @param e Arco que ser� reemplazado su r�tulo.
	 * @param x R�tulo a reemplazar.
	 * @return El r�tulo reemplazado.
	 * @throws InvalidEdgeException si el arco es nulo.
	 */
	public E replace( Edge<E> e, E x) throws InvalidEdgeException;
	
	/**
	 * Inserta un nuevo v�rtice con r�tulo x.
	 * @param x R�tulo del v�rtice nuevo.
	 * @return El nuevo v�rtice.
	 */
	public Vertex<V> insertVertex(V x);
	
	/**
	 * Inserta un nuevo arco con r�tulo x.
	 * @param v V�rtice predecesor del nuevo arco.
	 * @param w V�rtice sucesor del nuevo arco.
	 * @param x R�tulo del nuevo arco.
	 * @return El nuevo arco.
	 * @throws InvalidVertexException si el v�rtice es nulo.
	 */
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E x) throws InvalidVertexException;
	
	/**
	 * Elimina el v�rtice v y todos sus arcos adyacentes.
	 * @param v V�rtice a eliminar.
	 * @return El r�tulo del v�rtice a eliminar.
	 * @throws InvalidVertexException si el v�rtice es nulo.
	 */
	public V removeVertex(Vertex<V> v) throws InvalidVertexException;
	
	/**
	 * Elimina el arco e.
	 * @param e Arco a eliminar.
	 * @return El r�tulo del arco a eliminar.
	 * @throws InvalidEdgeException si el arco es nulo.
	 */
	public E removeEdge(Edge<E> e) throws InvalidEdgeException;
	
}
