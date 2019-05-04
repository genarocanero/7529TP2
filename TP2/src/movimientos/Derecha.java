package movimientos;

import laberinto.Portero;
import ubicacion.Coordenada;

public class Derecha extends Sentido{

	public boolean esPosibleMoverseDesde(Coordenada actual) {
		
		return (actual.columna + 1 < actual.columnaMaxima);
	}
	
	public Coordenada moverse(Coordenada coordenada) {
		
		Coordenada nueva = new Coordenada(coordenada.fila, coordenada.columna + 1, coordenada.filaMaxima, coordenada.columnaMaxima);
	
		return nueva;
	}

	@Override
	public void cualPuertaAbro(Portero portero) {
		
		portero.abrir(this);
	}
	
	@Override
	public boolean estaAbiertaLaPuerta(Portero portero) {
		
		return portero.estaAbierta(this);
	}

	@Override
	public boolean fueElMovimiento(Coordenada inicio, Coordenada fin) {
		
		boolean esPosible = false;
		
		if(esPosibleMoverseDesde(inicio) && Coordenada.sonIguales(this.moverse(inicio),fin)) esPosible = true;
		
		return esPosible;
	}
}
