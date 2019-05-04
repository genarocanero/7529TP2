package aleatorio;

import java.util.Random;

public class GeneradorDeNumeros {

	public static int enteroAleatorioEntreCeroY(int max) {
		
		Random generador = new Random(System.currentTimeMillis());
		
		int numero = generador.nextInt(max);

		return numero;
	}
	

	
}
