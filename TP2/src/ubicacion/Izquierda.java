package ubicacion;

public class Izquierda implements Desplazamiento {

	private static Izquierda unicaInstancia;
	
	private Izquierda() {
		
		
	}
	
	public static Izquierda instanciar() {
		
		if(unicaInstancia == null) unicaInstancia = new Izquierda();
		
		return unicaInstancia;
	}
	
	@Override
	public Coordenada nuevaCoordenada(Coordenada coordenada) {
		
		Coordenada nuevaCoordenada = new Coordenada(coordenada.fila, coordenada.columna - 1);
	
		return (nuevaCoordenada);
	}
	
	public static boolean esPosibleDesplazarse(Coordenada actual, Coordenada coordenadFinal) {
		
		boolean esPosible = false;
		
		if(actual.columna - 1 >= 0) esPosible = true;
		
		return esPosible;
	}



}
