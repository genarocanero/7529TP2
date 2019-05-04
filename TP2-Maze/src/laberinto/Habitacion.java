package laberinto;

import java.util.ArrayList;

import ubicacion.Adyacencias;
import ubicacion.Coordenada;
import movimientos.Sentido;

public class Habitacion {

	private Coordenada ubicacion;
	
	private Portero puertas;
	
	private boolean visitado;
	
	private ArrayList<Coordenada> adyacentes;
	
	public Habitacion(Coordenada coordenada) {
		
		this.ubicacion = coordenada;
		
		this.puertas = new Portero();
		
		this.adyacentes = Adyacencias.adyacentesA(ubicacion);
		
		this.visitado = false;
	}
	
	public void visitar() {
		
		this.visitado = true;
	}
	
	public boolean visitada() {
		
		return this.visitado;
	}

	public void abrirPuertaHacia(Coordenada adyacente) {
		
		this.puertas.abrirPuerta(ubicacion, adyacente);
	}

	public boolean estaAbiertaLaPuertaHaciaLa(Sentido sentido) {
		
		return this.puertas.estaAbierta(sentido);
	}

	public Coordenada adyacente() {
		
		return this.adyacentes.remove(0);
	}

	public boolean tieneAdyacentes() {
		
		return (!this.adyacentes.isEmpty());
	}

	public Coordenada coordenada() {
		
		return this.ubicacion;
	}
}
