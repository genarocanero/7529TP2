package generador;

public class Puerta {

	public Habitacion h1;
	public Habitacion h2;
	
	//Deprecated
	public Puerta(int x1, int y1, int x2, int y2){
		h1=new Habitacion();
		h2=new Habitacion();
		h1.posX = x1;
		h1.posY = y1;
		h2.posX = x2;
		h2.posY = y2;
	}
	
	//esta funcion devuelve un identificador numerico unico para cada puerta sin importar el tamaño del laverinto
	public static int getID(int alto, int ancho, int x1, int y1, int x2, int y2){
		int xOrigen;
		int xDestino;
		int yOrigen;
		int yDestino;
		
		if (x1 <= x2){
			xOrigen= x1;
			xDestino=x2;
		}
		else{
			xOrigen= x2;
			xDestino=x1;
		}
		if (y1 <= y2){
			yOrigen= y1;
			yDestino=y2;
		}
		else{
			yOrigen= y2;
			yDestino=y1;
		}
			
			int res = ((xOrigen)*(alto)+(yOrigen))*(alto*ancho)+((xDestino)*(alto)+(yDestino));
			return res;
	}
}
