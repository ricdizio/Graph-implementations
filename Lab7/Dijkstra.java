import java.lang.*;
import java.util.*;

public class Dijkstra{
	
	public List<Vertice> listadeVertices;

	public Dijkstra(GrafoNoDirigido G, Vertice s){
			//PriorityQueue <Vertice>  colaP = new PriorityQueue <Vertice> ()
		// ARRAYsLIST METODO SORTING
		Double inf = Double.MAX_VALUE;
		Vertice x;
		List<Vertice>  cola = new ArrayList<Vertice> (); 
		Double costos[] = new Double[G.numeroDeVertices()];
		String caminos[] = new String[G.numeroDeVertices()]; 

		listadeVertices = G.vertices();
			
		for (Vertice v: listadeVertices) {
			costos[doubleToInt(v)] = inf;
			caminos[doubleToInt(v)] = "";
			cola.add(v);
		}
		costos[doubleToInt(s)] = 0.0;

		while (cola.size() > 0){
			x = cola.remove(0);

			for (Vertice v1: x.getListaDeAdyacencias()) {
				//costos.get(getIndexx(v1);
				if (costos[doubleToInt(v1)] > (costos[doubleToInt(x)] + costo(x, v1))) {
					
					costos[doubleToInt(v1)] = costos[doubleToInt(x)] + costo(x, v1);
					caminos[doubleToInt(v1)] = caminos[doubleToInt(v1)] + "->" + x.getId();											
				}					
			}
		}
	}

	public int doubleToInt(Vertice v){
		int i = (int)v.getPeso();
		return i;
	}

	public Double costo(Vertice x, Vertice y){
		Double sumX = 0.0;
		Double sumY = 0.0;
		Double distEuclid = 0.0;
		sumX = Math.pow((x.ejeX - y.ejeX),2);
		sumY = Math.pow((x.ejeY - y.ejeY),2);
		distEuclid = Math.sqrt(sumX + sumY);
		return distEuclid;

	}
}