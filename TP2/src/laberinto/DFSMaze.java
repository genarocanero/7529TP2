package laberinto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import aleatorio.Azar;
import contenedores.Pila;
import movimientos.Sentido;
import ubicacion.Coordenada;

public class DFSMaze {
	
	private int cantidadFilas;
	private int cantidadColumnas;
	
	private Habitacion[][] habitaciones;

	public DFSMaze(int filas, int columnas) {
		
		if(!tamanioNulo(filas,columnas)) {
			
			this.cantidadFilas = filas;
			this.cantidadColumnas = columnas;
			this.habitaciones = new Habitacion[filas][columnas];
			
			Coordenada inicioAleatorio = Coordenada.aleatoria(filas, columnas);
			
			Habitacion habitacionDeInicio = habitacionEn(inicioAleatorio);
			
			dfs(habitacionDeInicio);
		}
	}
	
	private Habitacion habitacionEn(Coordenada coordenada) {
		
		if(!existeHabitacionEn(coordenada)) crearHabitacionEn(coordenada);
		
		return habitaciones[coordenada.fila][coordenada.columna];
	}

	private Habitacion habitacionEn(int fila, int columna) {
		
		Coordenada coordenada = new Coordenada(fila, columna, cantidadFilas, cantidadColumnas);
		
		return habitacionEn(coordenada);
	}
	
	private boolean existeHabitacionEn(Coordenada coordenada) {
		
		return (habitaciones[coordenada.fila][coordenada.columna] != null);
	}

	private void crearHabitacionEn(Coordenada coordenada) {
		
		habitaciones[coordenada.fila][coordenada.columna] = new Habitacion(coordenada);
	}
	
	private boolean tamanioNulo(int filas, int columnas) {
		
		return (filas == 0 || columnas == 0);
	}
	
	private void dfs(Habitacion inicio) {
			
		Pila<Habitacion> camino = new Pila<Habitacion>();
			
		camino.apilar(inicio);
			
		inicio.visitar();
			
		while(!camino.estaVacia()) {
				
			Habitacion habitacionActual = camino.desapilar();
				
			while(habitacionActual.tieneAdyacentes()) {
					
				Coordenada coordenadaAdyacente = habitacionActual.adyacente();
				
				Habitacion habitacionAdyacente = habitacionEn(coordenadaAdyacente);
					
				if(!habitacionAdyacente.visitada()) {
						
					habitacionAdyacente.visitar();
					
					camino.apilar(habitacionAdyacente);
					
					habitacionActual.abrirPuertaHacia(coordenadaAdyacente);
					habitacionAdyacente.abrirPuertaHacia(habitacionActual.coordenada());
				}
				else{
						
						if(tamanioMinimo()) abrirAleatoriamentePuertas(habitacionActual,habitacionAdyacente);
				}
					
			}
		}
	}
	
	private boolean tamanioMinimo() {
		
		return (this.cantidadFilas > 10 && this.cantidadColumnas > 10);
	}

	private void abrirAleatoriamentePuertas(Habitacion actual, Habitacion adyacente) {
		
		if(Azar.valorDeVerdadAleatorio()) {
			
			actual.abrirPuertaHacia(adyacente.coordenada());
			adyacente.abrirPuertaHacia(actual.coordenada());;
		}	
	}

	private String bordesSuperior() {
		
		String linea = "";
		
		linea = "+ +";
		
		for(int borde = 0 ; borde < cantidadColumnas - 1; borde++) {
			
			linea = linea + "-+";
		}
		
		return linea;
	}
	
	private String paredesVerticales(int fila) {

		String linea = "";
		
		Sentido derecha = Sentido.derecha();
		
		linea = "|";
			
		for(int j = 0 ; j < cantidadColumnas ; j++) {
				
			linea = linea + " ";
				
			if(!habitacionEn(fila,j).estaAbiertaLaPuertaHaciaLa(derecha)) linea = linea + "|";
			
			else linea = linea + " ";
		}
		
		return linea;
	}
	
	private String paredesHorizontales(int fila) {
		
		String linea = "";
		
		Sentido abajo = Sentido.abajo();
		
			for(int j = 0 ; j < cantidadColumnas ; j++) {
				
				linea = linea + "+";
				
				if(!habitacionEn(fila,j).estaAbiertaLaPuertaHaciaLa(abajo)) linea = linea + "-";
				
				else linea = linea + " ";
			}
			linea = linea + "+";
			linea = linea + " ";
		
		return linea;
		
	}	
	
	private String bordeInferior() {
		
		String linea = "";
		
		linea = linea + "+";
		
		for(int borde = 0 ; borde < cantidadColumnas - 1; borde++) {
			
			linea = linea + "-+";
		}
		linea = linea + " +";
		
		return linea;
		
	}
	
	public void guardarEnArchivo(String nombreArchivo) {
		
		File archivo = new File(nombreArchivo);	
		
		try{
		
		FileWriter escritorDeArchivo = new FileWriter(archivo);
		
		BufferedWriter buffer = new BufferedWriter(escritorDeArchivo);
		
		PrintWriter impresion = new PrintWriter(buffer);  
		
		impresion.append(this.bordesSuperior());
		
		buffer.newLine();
		
		for(int i = 0 ; i < cantidadFilas - 1 ; i++) {
		
			impresion.append(paredesVerticales(i));	
			buffer.newLine();

			impresion.append(paredesHorizontales(i));
			buffer.newLine();
			
		}
		
		impresion.append(paredesVerticales(cantidadFilas-1));
		buffer.newLine();
	
		impresion.append(bordeInferior());
		
		buffer.close();
		impresion.close();
		
		}catch(IOException e){};

		}
	
}
