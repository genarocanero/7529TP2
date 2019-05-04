package aleatorio;

public class Azar {

	public static boolean valorDeVerdadAleatorio() {
		
		boolean valorDeVerdad = false;
		
		int numero = GeneradorDeNumeros.enteroAleatorioEntreCeroY(100);
		
		if (numero > 90) valorDeVerdad = true;
		
		return valorDeVerdad;
	}
}
