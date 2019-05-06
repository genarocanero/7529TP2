package generador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;


public class GeneradorDC extends Generador {

	private Random rand;
	public HashSet<Integer> laberinto;
	int ancho;
	int alto;
	
	public GeneradorDC(){

		 rand = new Random();
		 laberinto = new HashSet<Integer>();
		 ancho=0;
		 alto=0;
	}

	public void generar(int ancho, int alto) {
		//genero un mapa como una coleccion de puertas
		laberinto.clear();
		this.alto=alto;
		this.ancho=ancho;
		//el laberinto va de 0 a n-1
		divideAConquer(ancho-1, alto-1, 0, 0);
		
	}
	
	/**
	 * Se toma la esquina superior izquierda (entrada) como indefior en x e y
	 * y la esquina inferior derecha (salida) como superior tanto en x como en y
	 * @param xSup
	 * @param ySup
	 * @param xInf
	 * @param yInf
	 */
	private void divideAConquer(int xSup, int ySup, int xInf, int yInf){
		boolean xDiv=false; //puede dividirse en x
		boolean yDiv=false; //puede dividirse en y
		int divX=0; //posicion en x donde se divide
		int divY=0; //posicion en y donde se divide
		
		if (xSup-xInf >=1){
			xDiv=true;
			if (xSup-xInf < (ySup-yInf)/4){
				xDiv=false;
			}
		}
		if (ySup-yInf >=1){
			yDiv=true;
			if (ySup-yInf < (xSup-xInf)/4){
				yDiv=false;
			}
		}
		
		///si los 2 pueden dividirse solo 1 lo hace
		if (xDiv && yDiv){
			xDiv = rand.nextBoolean();
			yDiv = !xDiv;
		}
		
		
		//divide cada sub laberinto
		if (xDiv){
			int nrand = 0;
			//si hay mas de 1 escoje una pared random entre los extremos
			if ((xSup-xInf-1)>0)
				nrand = rand.nextInt(xSup-xInf-1); 
			divX = xInf + nrand;
			
			//if (xSup>divX+1)
				divideAConquer(xSup, ySup, divX+1, yInf);
			//if (divX<xInf)
				divideAConquer(divX, ySup, xInf, yInf);
			
			//unir los sub laberintos
			nrand=0;
			if ((ySup-yInf)>0)
				nrand = rand.nextInt(ySup-yInf); 
			int puertaY = nrand+yInf;
			laberinto.add( Puerta.getID(alto,ancho,divX,puertaY,divX+1,puertaY) );
		}
		else if (yDiv){
			int nrand = 0;
			//si hay mas de 1 escoje una pared random entre los extremos
			if ((ySup-yInf-1)>0)
				nrand = rand.nextInt(ySup-yInf-1); 
			divY = yInf + nrand;
			
			//if (ySup>divY+1)
				divideAConquer(xSup, ySup, xInf, divY+1);
			//if (divY<yInf)
				divideAConquer(xSup, divY, xInf, yInf);

			//unir los sub laberintos
			nrand=0;
			if ((xSup-xInf)>0)
				nrand = rand.nextInt(xSup-xInf); 
			int puertaX = nrand+xInf;
			laberinto.add(Puerta.getID(alto,ancho,puertaX,divY+1,puertaX,divY) );
		}
	}
	

	private String bordesSuperior() {
		
		String linea = "";
		
		linea = "+ +";
		
		for(int borde = 0 ; borde < ancho - 1; borde++) {
			
			linea = linea + "-+";
		}
		
		return linea;
	}
	
	private String paredesVerticales(int fila) {

		String linea = "";
		
		//pared del extremo izquierdo
		linea = "|";
			
		for(int j = 0 ; j < ancho -1; j++) {
				
			linea = linea + " ";
			
			if (laberinto.contains(Puerta.getID(alto,ancho,j, fila,j+1, fila)))
				linea = linea + " ";
			else
				linea = linea + "|";

		}

		//pared del extremo derecho
		linea = linea + " |";
		
		return linea;
	}
	
	private String paredesHorizontales(int fila) {
		
		String linea = "";

		//pared del extremo izquierdo
		linea = "+";
			
		for(int j = 0 ; j < ancho ; j++) {
			
			if (laberinto.contains(Puerta.getID(alto,ancho,j, fila,j, fila+1)))
				linea = linea + " +";
			else
				linea = linea + "-+";
			
		}
		
		return linea;
		
	}	
	
	private String bordeInferior() {
		
		String linea = "";
		
		linea = linea + "+";
		
		for(int borde = 0 ; borde < ancho - 1; borde++) {
			
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
			
			for(int i = 0 ; i < alto - 1 ; i++) {
			
				impresion.append(paredesVerticales(i));	
				buffer.newLine();
	
				impresion.append(paredesHorizontales(i));
				buffer.newLine();
				
			}
			
			impresion.append(paredesVerticales(alto-1));
			buffer.newLine();
		
			impresion.append(bordeInferior());
			
			buffer.close();
			impresion.close();
			
		}catch(IOException e){};

		}

}
