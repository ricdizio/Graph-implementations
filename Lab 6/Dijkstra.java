import java.lang.*;
import java.util.*;
// Guardando los pesos de 0 a n-1 de cada vertice al crear el grafo
public class Dijkstra{
	
	public List<Vertice> listadeVertices;

	public Dijkstra(GrafoNoDirigido G, Vertice s){
			//PriorityQueue <Vertice>  colaP = new PriorityQueue <Vertice> ()
		// ARRAYsLIST METODO SORTING
		int inf = Integer.MAX_VALUE;
		Vertice x;
		List<Vertice>  cola = new ArrayList<Vertice> ();
		//List<Vertice> 
		int costo[] = new int[G.numeroDeVertices()];
		String caminos[] = new String[G.numeroDeVertices()]; 

		listadeVertices = G.vertices();
			
		for (Vertice v: listadeVertices) {
			costos[v.getPeso().intValue()] = inf;
			caminos[v.getPeso().intValue()] = "";
			cola.add(v);
		}
		//costos.add(listadeVertices.indexOf(s), 0);
		costos[s.getPeso().intValue()] = 0;

		while (cola.size() > 0){
			x = cola.remove(0);

			for (Vertice v1: x.getListaDeAdyacencias()) {
				//costos.get(getIndexx(v1);
				if (costos[v1.getPeso().intValue()] > (costos[x.getPeso().intValue()] + costo(x, v1)) {
					
					costos[v1.getPeso().intValue()] = costos[x.getPeso().intValue()] + costo(x, v1);
					caminos[v1.getPeso().intValue()] = caminos[v1.getPeso().intValue()] + "->" + x.getId();

					//caminos.add(getIndexx(v1), caminos.get(getIndexx(v1)) +" "+x.getId());											
				}					
			}
		}
	}

	public int costo(Vertice x, Vertice y){
		int sumX = 0;
		int sumY = 0;
		int distEuclid = 0;
		sumX = (int)Math.pow((x.ejeX - y.ejeX),2);
		sumY = (int)Math.pow((x.ejeY - y.ejeY),2);
		distEuclid = (int)Math.sqrt(sumX + sumY);
		return distEuclid;

	}
}