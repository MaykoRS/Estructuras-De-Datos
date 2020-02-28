package TDAMapeo;


import TDALista.InvalidPositionException;
import TDALista.MiLista;
import TDALista.Position;
import TDALista.PositionList;

/**
 * Clase MiMapeo.
 * 
 * @author Mayko Rodríguez.
 *
 * @param <K> Tipo de las claves.
 * @param <V> Tipo de los valores.
 * 
 */
public class MiMapeo<K, V> implements Map<K, V> {

	protected PositionList<Entrada<K,V>> [] A;
	protected int cant;
	protected int N = 13;
	
	public MiMapeo(){
		cant = 0;
		A = (PositionList<Entrada<K,V>>[]) new MiLista[N];
		for(int i=0; i<N; i++){
			A[i] = new MiLista<Entrada<K,V>>();
		}
	}
	
	public int size() {
		return cant;
	}

	public boolean isEmpty() {
		return cant == 0;
	}
	
	private int h(K key){
		return key.hashCode() % N;
	}
	
	private void checkKey(K key) throws InvalidKeyException {
		if(key == null)
			throw new InvalidKeyException("Clave inválida");
	}
	
	public V get(K key) throws InvalidKeyException {
		checkKey(key);
		int i = h(key);
		for(Position<Entrada<K,V>> p : A[i].positions()){
			if(p.element().getKey().equals(key)){
				return p.element().getValue();
			}
		}
		return null;
	}

	public V put(K key, V value) throws InvalidKeyException {
		checkKey(key);
		if(cant/N > 0.5){
			extender();
		}
		int i = h(key);
		if(!A[i].isEmpty())
			for(Position<Entrada<K,V>> p : A[i].positions()){
			if(p.element().getKey().equals(key)){
				V valor = p.element().getValue();
				p.element().setValue(value);
				return valor;
			}
		}
		A[h(key)].addLast(new Entrada<K,V>(key,value));
		cant++;
		return null;
	}
	
	private void extender(){
		int Nanterior = N;
		N = Nanterior*2;
		PositionList<Entrada<K,V>>[] B = new MiLista[N];
		for(int i=0; i<N; i++)
			B[i] = new MiLista<Entrada<K,V>>();
		
		for(int i=0; i<Nanterior; i++){
			for(Entrada<K,V> e : A[i]){
				int ind = h(e.getKey());
				B[ind].addLast(e);
			}		
		}
		A = B;
	}

	public V remove(K key) throws InvalidKeyException {
		checkKey(key);
		try{
			int  i = h(key);
			for(Position<Entrada<K,V>> p : A[i].positions()){
				if(p.element().getKey().equals(key)){
					V valor = p.element().getValue();
					A[i].remove(p);
					cant--;
					return valor;
				}
			}
			
		} catch(InvalidPositionException e){
			System.out.println(e.getMessage());
		}	
		return null;
	}

	public Iterable<K> keys() {
		PositionList<K> l = new MiLista<K>();
		for(int i=0; i<N; i++){
			for(Position<Entrada<K,V>> p : A[i].positions()){
				l.addLast(p.element().getKey());
			}
		}
		return l;
	}

	public Iterable<V> values() {
		PositionList<V> l = new MiLista<V>();
		for(int i=0; i<N; i++){
			for(Position<Entrada<K,V>> p : A[i].positions()){
				l.addLast(p.element().getValue());
			}
		}
		return l;
	}

	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> l = new MiLista<Entry<K,V>>();
		for(int i=0; i<N; i++){
			for(Position<Entrada<K,V>> p : A[i].positions()){
				l.addLast(p.element());
			}
		}
		return l;
	}

}
