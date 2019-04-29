package contenedores;

import java.util.ArrayList;

public class Pila<T> {

	private ArrayList<T> pila;
	
	public Pila() {
		
		this.pila = new ArrayList<T>();
	}
	
	public void apilar(T elemento) {
		
		this.pila.add(elemento);
	}
	
	public boolean vacia() {
		
		return (this.pila.isEmpty());
	}
	
	public int size() {
		
		return (this.pila.size());
	}
	
	public T desapilar() {
		
		return (this.pila.remove(size()-1));
	}
}
