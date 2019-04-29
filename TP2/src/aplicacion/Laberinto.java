package aplicacion;

import java.util.ArrayList;
import java.util.HashMap;

import contenedores.Pila;
import numeros.GeneradorDeNumeros;
import ubicacion.Coordenada;

public class Laberinto {

	private Coordenada entrada;
	private Coordenada salida;
	
	private HashMap<Integer,Fila> laberinto;
	
	public Laberinto(int cantidadFilas, int cantidadColumnas) {
		
		this.entrada = new Coordenada(0,0);
		this.salida = new Coordenada(cantidadFilas - 1, cantidadColumnas - 1);
		
		this.laberinto = new HashMap<Integer,Fila>();
		
		inicializarLaberinto();
		
		int caminos = GeneradorDeNumeros.enteroAleatorio(salida.fila/2, (salida.fila + salida.columna)/2);
		
		if(caminos > 0) generarCaminos(caminos);
		
		else crearCaminoEnProfundidad(entrada,salida);
		
	}

	private void inicializarLaberinto() {
		
		for(int i = 0 ; i <= salida.fila ; i++) {
			
			this.laberinto.put(i, new Fila(salida.columna + 1));
		}
		
	}

	private void generarCaminos(int n) {
	
		int i = 0;
		
		Coordenada inicio = null;
		Coordenada fin = null;
		
		while(i < n) {
			
			inicio = Coordenada.coordenadaAleatoria(salida);
			fin = Coordenada.coordenadaAleatoria(salida);
			
			crearCaminoEnProfundidad(inicio,fin);
			
			i++;
		}
		
		crearCaminoEnProfundidad(entrada,inicio);
		crearCaminoEnProfundidad(inicio,salida);
		
	}
	
	private void crearCaminoEnProfundidad(Coordenada inicio, Coordenada fin) {
		
		Pila<Coordenada> camino= new Pila<Coordenada>();
		
		Coordenada coordenadaActual = inicio;
			
		camino.apilar(coordenadaActual);
		
		while(!camino.vacia() &&  !seLlegoAlFinal(coordenadaActual, fin)) {
			
			coordenadaActual = camino.desapilar();
			
			this.laberinto.get(coordenadaActual.fila).liberar(coordenadaActual.columna);
			
			ArrayList<Coordenada> adyacentes = coordenadaActual.adyacentes(this.salida);
				
			camino.apilar(coordenadaActual.adyacenteMasCercanoA(adyacentes,fin));		
		}
		
	}
	
	private boolean seLlegoAlFinal(Coordenada actual, Coordenada fin) {
		
		return ((actual.fila == fin.fila) && (actual.columna == fin.columna));
	}
	
	public char[][] getLaberinto(){
		
		char[][] cuadricula = new char[salida.fila + 1][salida.columna + 1];
		
		for(int i = 0 ; i <= salida.fila ; i++) {
			
			for(int j = 0 ; j <= salida.columna ; j++) {
				
				cuadricula[i][j] = this.laberinto.get(i).getElemento(j);
			}
		}
		
		return cuadricula;
	}
}
