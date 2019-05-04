package ubicacion;

import aleatorio.GeneradorDeNumeros;

public class Coordenada {

	public int fila;
	public int columna;
	
	public int filaMaxima;
	public int columnaMaxima;
	
	public Coordenada(int posicionFila, int posicionColumna, int filas, int columnas) {
		
		this.fila = posicionFila;
		this.columna = posicionColumna;
		
		this.filaMaxima = filas;
		this.columnaMaxima = columnas;
	}
	
	public static Coordenada aleatoria(int maximaFila, int maximaColumna) {
		
		int fila = GeneradorDeNumeros.enteroAleatorioEntreCeroY(maximaFila);
		
		int columna = GeneradorDeNumeros.enteroAleatorioEntreCeroY(maximaColumna);
		
		return (new Coordenada(fila,columna,maximaFila,maximaColumna));
	}
	
	public static boolean sonIguales(Coordenada unaCoordenada, Coordenada otraCoordenada) {
		
		return (unaCoordenada.fila == otraCoordenada.fila && unaCoordenada.columna == otraCoordenada.columna);
	}
	
	
}
