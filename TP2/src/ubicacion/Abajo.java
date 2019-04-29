package ubicacion;

public class Abajo implements Desplazamiento {
	
	private static Abajo unicaInstancia;
	
	private Abajo() {
		
		
	}
	
	public static Abajo instanciar() {
		
		if(unicaInstancia == null) unicaInstancia = new Abajo();
		
		return unicaInstancia;
	}


	@Override
	public Coordenada nuevaCoordenada(Coordenada coordenada) {
		
		Coordenada nuevaCoordenada = new Coordenada(coordenada.fila + 1, coordenada.columna);
		
		return (nuevaCoordenada);
	}
	
	public static boolean esPosibleDesplazarse(Coordenada actual, Coordenada coordenadaFinal) {
		
		boolean esPosible = false;
		
		if(actual.fila + 1 <= coordenadaFinal.fila) esPosible = true;
		
		return esPosible;
	}
	

}
