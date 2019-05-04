package ubicacion;

import java.util.ArrayList;

import aleatorio.GeneradorDeNumeros;
import movimientos.Abajo;
import movimientos.Arriba;
import movimientos.Derecha;
import movimientos.Izquierda;
import movimientos.Sentido;

public class Adyacencias {
	
	public static Sentido izquierda = new Izquierda();
	public static Sentido derecha = new Derecha();
	public static Sentido arriba = new Arriba();
	public static Sentido abajo = new Abajo();

	public static ArrayList<Coordenada> adyacentesA(Coordenada actual){
		
		ArrayList<Coordenada> adyacentes = new ArrayList<Coordenada>();
			
		if(arriba.esPosibleMoverseDesde(actual)) adyacentes.add(arriba.moverse(actual));
		
		if(abajo.esPosibleMoverseDesde(actual)) adyacentes.add(abajo.moverse(actual));
		
		if(izquierda.esPosibleMoverseDesde(actual)) adyacentes.add(izquierda.moverse(actual));
		
		if(derecha.esPosibleMoverseDesde(actual)) adyacentes.add(derecha.moverse(actual));

		ArrayList<Coordenada> adyacentesMezclados = mezclarElementos(adyacentes);
		
		return adyacentesMezclados;
	}

	private static ArrayList<Coordenada> mezclarElementos(ArrayList<Coordenada> adyacentes) {
		
		ArrayList<Coordenada> mezcla = new ArrayList<Coordenada>();
		
		while(!adyacentes.isEmpty()) {
			
			int indexAleatorio = GeneradorDeNumeros.enteroAleatorioEntreCeroY(adyacentes.size());
			
			mezcla.add(adyacentes.remove(indexAleatorio));
		}
		
		return mezcla;
	}

}
