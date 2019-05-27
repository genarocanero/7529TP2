package solver;

import generador.Puerta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

public class MazeSolver {

	public HashSet<Integer> laberinto;
	//el ID de la havitacion es ancho*y+x
	public HashSet<Integer> habitacionesVisitadas;
	public HashSet<Integer> habitacionesSolucion;
	int longitud;
	int alto;
	int ancho;

    public static void main(String[] args){

		String mazeName = args[0];
		
		MazeSolver solver = new MazeSolver();
		try {
			solver.readFile(mazeName);
			solver.longitud=0;
			solver.solveMaze(0, 0);
			solver.guardarEnArchivo("solucion");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public MazeSolver(){
    	laberinto = new HashSet<Integer>();
    	habitacionesSolucion = new HashSet<Integer>();
    	habitacionesVisitadas = new HashSet<Integer>();
    }
    
    boolean solveMaze(int columna, int fila){
    	habitacionesVisitadas.add(ancho*fila+columna);
    	if (columna == (ancho-1) && fila == (alto-1)){
    		habitacionesSolucion.add(ancho*fila+columna);
    		longitud++;
    		return true;
    	}
    	//ir a la derecha
    	if (columna+1 < ancho){
			if (laberinto.contains(Puerta.getID(alto,ancho,columna, fila,columna+1, fila))){
				if (!habitacionesVisitadas.contains(ancho*(fila)+(columna+1))){
					if (solveMaze(columna+1, fila)){
			    		habitacionesSolucion.add(ancho*fila+columna);
			    		longitud++;
			    		return true;
					}
				}
			}
		}
    	//ir a la izquierda
    	if (columna-1 >= 0){
			if (laberinto.contains(Puerta.getID(alto,ancho,columna, fila,columna-1, fila))){
				if (!habitacionesVisitadas.contains(ancho*(fila)+(columna-1))){
					if (solveMaze(columna-1, fila)){
			    		habitacionesSolucion.add(ancho*fila+columna);
			    		longitud++;
			    		return true;
					}
				}
			}
		}
    	//ir  abajo
    	if (fila+1 < alto){
			if (laberinto.contains(Puerta.getID(alto,ancho,columna, fila,columna, fila+1))){
				if (!habitacionesVisitadas.contains(ancho*(fila+1)+(columna))){
					if (solveMaze(columna, fila+1)){
			    		habitacionesSolucion.add(ancho*fila+columna);
			    		longitud++;
			    		return true;
					}
				}
			}
		}
    	//ir arriba
    	if (fila-1 >= 0){
			if (laberinto.contains(Puerta.getID(alto,ancho,columna, fila,columna, fila-1))){
				if (!habitacionesVisitadas.contains(ancho*(fila-1)+(columna))){
					if (solveMaze(columna, fila-1)){
			    		habitacionesSolucion.add(ancho*fila+columna);
			    		longitud++;
			    		return true;
					}
				}
			}
		}

		return false;
    }
    
    void readFile(String path) 
    		  throws IOException 
	{
    	List<String> lines = Files.readAllLines(Paths.get(path));
    	ancho=(lines.get(1).length()-1)/2;
    	alto=(lines.size()-1)/2;
    	for (int i=0; (i*2+2)<lines.size();i++){
    		String a= lines.get(i*2+1);
    		byte[] lineV = a.getBytes();
    		byte[] lineH = lines.get(i*2+2).getBytes();
    		for (int j=0; (j*2+3)<=a.length();j++){
    			if (lineV[j*2+2]==' ')
    				laberinto.add(Puerta.getID(alto, ancho,j,i,j+1,i));
    			if (lineH[j*2+1]==' ')
    				laberinto.add(Puerta.getID(alto, ancho,j,i,j,i+1));
    		}
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
			
			if (habitacionesSolucion.contains(ancho*fila+j))
				linea = linea + "X";
			else
				linea = linea + " ";
			
			if (laberinto.contains(Puerta.getID(alto,ancho,j, fila,j+1, fila)))
				linea = linea + " ";
			else
				linea = linea + "|";

		}

		//pared del extremo derecho

		if (habitacionesSolucion.contains(ancho*fila+(ancho-1)))
			linea = linea + "X|";
		else
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
			buffer.newLine();
			impresion.append("Longitud de la solucion: " + String.valueOf(longitud));
			
			buffer.close();
			impresion.close();
			
		}catch(IOException e){};

	}
}
