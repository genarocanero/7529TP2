package ubicacion;

import java.util.ArrayList;

import numeros.GeneradorDeNumeros;

public class Coordenada {

	public int fila;
	public int columna;
	
	public Coordenada(int ubicacionFila, int ubicacionesColumna) {
		
		this.fila = ubicacionFila;
		this.columna = ubicacionesColumna;
	}
	
	public int cuadradoDeLadistanciaEntre(Coordenada x, Coordenada y) {
		
		double distancia = 0;
		
		distancia = (Math.pow((x.fila - y.fila),2) + Math.pow((x.columna - y.columna),2));
		
		return (int) distancia;
	}
	
	public static Coordenada coordenadaAleatoria(Coordenada coordenadaMaxima) {
		
		int fila = GeneradorDeNumeros.enteroAleatorio(0, coordenadaMaxima.fila);
		int columna = GeneradorDeNumeros.enteroAleatorio(0, coordenadaMaxima.columna);
		
		return (new Coordenada(fila,columna));
	}

	public ArrayList<Coordenada> adyacentes(Coordenada fin) {
		
		ArrayList<Desplazamiento> desplazamientosPosibles = Sentido.desplazamientosPosibles(new Coordenada(fila,columna), fin);
		
		ArrayList<Coordenada> adyacentes = new ArrayList<Coordenada>();
		
		Coordenada actual = new Coordenada(fila,columna);
		
		for(Desplazamiento desplazamiento: desplazamientosPosibles) {
			
			adyacentes.add(desplazamiento.nuevaCoordenada(actual));
		}
		
		return adyacentes;
	}
	
	public Coordenada adyacenteMasCercanoA(ArrayList<Coordenada> coordenadas,Coordenada fin) {
		
		int[] distancias = new int[coordenadas.size()];
		
		Coordenada coordenada;
		
		int indexMin = 0;
		
		for(int i = 0 ; i < coordenadas.size() ; i++) {
			
			coordenada = coordenadas.get(i);
			
			distancias[i] = cuadradoDeLadistanciaEntre(coordenada, fin);
		}
		
		for(int i = 1 ; i < coordenadas.size() ; i++) {
			
			if(distancias[i] < distancias[indexMin]) indexMin = i;
			
			else if(distancias[i] == distancias[indexMin]) indexMin = elegirIndexAlAzar(indexMin,i);
	
		}
		
		return coordenadas.get(indexMin);
	}
	
	private int elegirIndexAlAzar(int i, int j) {
		
		int index;
		
		int n = GeneradorDeNumeros.enteroAleatorio(0, 3);
		
		if(n <= 1) index = j;
		else index = i;
		
		return index;
	}
}
