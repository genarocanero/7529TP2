package aplicacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneradorDeLaberintos {

	public static void generarLaberinto(int filas, int columnas) {

		Laberinto laberinto = new Laberinto(filas, columnas);
		
		guardarLaberintoEnArchivoDeTexto(laberinto, filas, columnas);
		
	}
	
	private static void guardarLaberintoEnArchivoDeTexto(Laberinto laberinto, int filas, int columnas) {
		
		char[][] cuadricula = laberinto.getLaberinto();
		
		File archivo;
		
		archivo = new File("mapa-laberinto.txt");
	
		try{
		
		FileWriter fileWriter = new FileWriter(archivo);	
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
		PrintWriter writer = new PrintWriter(bufferWriter);  
		
		for(int i = 0 ; i < filas ; i++) {
			
			for(int j = 0 ; j < columnas ; j++) {
					
				writer.append(cuadricula[i][j]);
			}
			
			writer.println();
		}	
		writer.close();
		bufferWriter.close();
		
		}catch(IOException e){
			
		}
		
	}
}
