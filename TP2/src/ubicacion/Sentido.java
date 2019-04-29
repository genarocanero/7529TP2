package ubicacion;

import java.util.ArrayList;

public class Sentido{
	
	public static ArrayList<Desplazamiento> desplazamientosPosibles(Coordenada actual, Coordenada coordenadaFinal){
		
		ArrayList<Desplazamiento> sentidosPosibles = new ArrayList<Desplazamiento>();
		
		if(Izquierda.esPosibleDesplazarse(actual, coordenadaFinal)) sentidosPosibles.add(Izquierda.instanciar());
		if(Derecha.esPosibleDesplazarse(actual, coordenadaFinal)) sentidosPosibles.add(Derecha.instanciar());
		if(Arriba.esPosibleDesplazarse(actual, coordenadaFinal)) sentidosPosibles.add(Arriba.instanciar());
		if(Abajo.esPosibleDesplazarse(actual, coordenadaFinal)) sentidosPosibles.add(Abajo.instanciar());
		
		return sentidosPosibles;
	}
	

	
	
}
