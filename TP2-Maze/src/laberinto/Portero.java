package laberinto;

import ubicacion.Coordenada;
import excepciones.ExcepcionSentido;
import movimientos.Abajo;
import movimientos.Arriba;
import movimientos.Derecha;
import movimientos.Izquierda;
import movimientos.Sentido;

public class Portero {

	private static int ARRIBA = 0;
	private static int ABAJO = 1;
	private static int IZQUIERDA = 2;
	private static int DERECHA = 3;
	
	private boolean[] puertas;
	
	public Portero() {
		
		this.puertas = new boolean[4];

	}
	
	public void abrir(Arriba puerta) {
		
		this.puertas[ARRIBA] = true;
	}
	
	public void abrir(Abajo puerta) {
		
		this.puertas[ABAJO] = true;
	}
	
	public void abrir(Izquierda puerta) {
		
		this.puertas[IZQUIERDA] = true;
	}
	
	public void abrir(Derecha puerta) {
		
		this.puertas[DERECHA] = true;
	}

	public boolean estaAbierta(Arriba puerta) {
		
		return (this.puertas[ARRIBA]);
	}
	
	public boolean estaAbierta(Abajo puerta) {
		
		return (this.puertas[ABAJO]);
	}
	
	public boolean estaAbierta(Izquierda puerta) {
		
		return (this.puertas[IZQUIERDA]);
	}
	
	public boolean estaAbierta(Derecha puerta) {
		
		return (this.puertas[DERECHA]);
	}

	public void abrirPuerta(Coordenada origen, Coordenada destino) throws ExcepcionSentido {
		
		Sentido sentido = Sentido.sentidoDesdeHasta(origen, destino);
		
		sentido.cualPuertaAbro(this);
	}

	public boolean estaAbierta(Sentido sentido) {
		
		return sentido.estaAbiertaLaPuerta(this);
		
	}
}
