package aplicacion;

import laberinto.DFSMaze;
import generador.GeneradorDC;

public class MazeGenerator {

	public static void main(String[] args) {
		
		String modalidad = args[0];
		
		int filas = Integer.parseInt(args[1]);
		int columnas = Integer.parseInt(args[2]);
		
		if(modalidad.equals("dfs")) {
			
			DFSMaze laberinto = new DFSMaze(filas, columnas);
			
			laberinto.guardarEnArchivo("mapas-laberinto.txt");
			
			
		}
		else if(modalidad.equals("dyc")) {
			
			GeneradorDC laberinto = new GeneradorDC();
			laberinto.generar(filas, columnas);
			
			laberinto.guardarEnArchivo("mapas-laberinto.txt");
			
			
		}
		else{
			//echo forma de uso
			//ej: llmar a 
		}
			

		
	}

}
