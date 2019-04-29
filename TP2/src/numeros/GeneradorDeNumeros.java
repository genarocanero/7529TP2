package numeros;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class GeneradorDeNumeros {

	public static int enteroAleatorio(int min, int max) {
		
		int numeroAleatorio = 0;
		
		try {
			SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
		    // genera numeros de min y max
		    numeroAleatorio = number.nextInt(max) + min;
		 }
		 catch (NoSuchAlgorithmException exception) { 
		    
		 }
	
		
		return (numeroAleatorio);		
	}
}
