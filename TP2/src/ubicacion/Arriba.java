package ubicacion;

public class Arriba implements Desplazamiento {

	private static Arriba unicaInstancia;
	
	private Arriba() {
		
		
	}
	
	public static Arriba instanciar() {

		
		if(unicaInstancia == null) unicaInstancia = new Arriba();
		
		return unicaInstancia;
	}
	
	
	@Override
	public Coordenada nuevaCoordenada(Coordenada coordenada) {
		
		Coordenada nuevaCoordenada = new Coordenada(coordenada.fila - 1, coordenada.columna);
		
		return (nuevaCoordenada);
	}

	public static boolean esPosibleDesplazarse(Coordenada actual, Coordenada coordenadaFinal) {
	
		boolean esPosible = false;
		
		if(actual.fila - 1 >= 0) esPosible = true;
		
		return esPosible;
	}

	
}
