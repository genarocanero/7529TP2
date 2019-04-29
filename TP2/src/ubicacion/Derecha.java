package ubicacion;

public class Derecha implements Desplazamiento {

	private static Derecha unicaInstancia;
	
	private Derecha() {
		
		
	}

	public static Derecha instanciar() {
		
		if(unicaInstancia == null) unicaInstancia = new Derecha();
		
		return unicaInstancia;
	}
	
	@Override
	public Coordenada nuevaCoordenada(Coordenada coordenada) {
		
		Coordenada nuevaCoordenada = new Coordenada(coordenada.fila, coordenada.columna + 1);
		
		return (nuevaCoordenada);
	}

	
	public static boolean esPosibleDesplazarse(Coordenada actual, Coordenada coordenadaFinal) {
		
		boolean esPosible = false;
		
		if(actual.columna + 1 <= coordenadaFinal.columna) esPosible = true;
		
		return esPosible;
	}

}
