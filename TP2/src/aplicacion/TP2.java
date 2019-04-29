package aplicacion;

public class TP2 {

	public static void main(String args[]) {
		
		String modalidad = args[0];
		
		int filas = Integer.parseInt(args[1]);
		int columnas = Integer.parseInt(args[2]);
		
		System.out.println("modalidad: " + modalidad + " filas:" + filas + 
				" columnas: " + columnas);
		
		if(modalidad == "dfs") GeneradorDeLaberintos.generarLaberinto(filas, columnas);
	}
}
