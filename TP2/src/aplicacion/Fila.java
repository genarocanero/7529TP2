package aplicacion;

public class Fila {

	private boolean[] celdas;
	
	public Fila(int cantidadDeCeldas) {
		
		this.celdas = new boolean[cantidadDeCeldas];
	}
	
	public void liberar(int indexElemento) {
		
		this.celdas[indexElemento] = true;
	}

	public char getElemento(int i) {
		
		char resultado;
		
		if(this.celdas[i]) resultado = ' ';
		else resultado = (char)219;
		
		return resultado;
	}
}
