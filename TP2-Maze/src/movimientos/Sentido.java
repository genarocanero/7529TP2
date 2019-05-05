package movimientos;

import excepciones.ExcepcionSentido;
import laberinto.Portero;
import ubicacion.Coordenada;

public abstract class Sentido {
	
	private static Arriba ARRIBA = new Arriba();
	private static Abajo ABAJO = new Abajo();
	private static Derecha DERECHA = new Derecha();
	private static Izquierda IZQUIERDA = new Izquierda();

	public abstract boolean esPosibleMoverseDesde(Coordenada actual);
	
	public abstract Coordenada moverse(Coordenada coordenada);
	
	public static Sentido sentidoDesdeHasta(Coordenada inicio, Coordenada fin) throws ExcepcionSentido {
		
		Sentido sentido;
	
		if(ARRIBA.fueElMovimiento(inicio, fin)) sentido = ARRIBA;
		
		else if(ABAJO.fueElMovimiento(inicio, fin)) sentido = ABAJO;
		
		else if(IZQUIERDA.fueElMovimiento(inicio, fin)) sentido = IZQUIERDA;
		
		else if (DERECHA.fueElMovimiento(inicio, fin)) sentido = DERECHA;
		
		else throw (new ExcepcionSentido("Sentido del movimiento desconocido"));
		
		return sentido;
	}
	
	public abstract void cualPuertaAbro(Portero portero);

	public abstract boolean estaAbiertaLaPuerta(Portero portero);
	
	public abstract boolean fueElMovimiento(Coordenada inicio, Coordenada fin);
	
	public static Derecha derecha() {
		
		return (DERECHA);
	}
	
	public static Izquierda izquierda() {
		
		return (IZQUIERDA);
	}

	public static Arriba arriba() {
		
		return (ARRIBA);
	}

	public static Abajo abajo() {
		
		return (ABAJO);
	}
}
