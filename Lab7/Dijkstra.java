import java.lang.*;
import java.util.*;

public class Dijkstra{
	public List<Vertice> listadeVertices;

	public Dijkstra(GrafoNoDirigido G, Vertice s){
			//PriorityQueue <Vertice>  colaP = new PriorityQueue <Vertice> ()
		// ARRAYsLIST METODO SORTING
		int inf = Integer.MAX_VALUE;
		Vertice x;
		List<Vertice>  cola = new ArrayList<Vertice> ();
		//List<Vertice> 
		listadeVertices = new LinkedList<Vertice>();
		List<Integer> costos = new LinkedList<Integer>();
		List<String> caminos = new LinkedList<String>();

		listadeVertices = G.vertices();
			
		for (Vertice v: listadeVertices) {
			costos.add(getIndexx(v), inf);
			caminos.add(getIndexx(v), null);
			cola.add(v);
		}
		costos.add(listadeVertices.indexOf(s), 0);

		while (cola.size() > 0){
			x = cola.remove(0);

			for (Vertice v1: x.getListaDeAdyacencias()) {
				//costos.get(getIndexx(v1);
				if ((costos.get(getIndexx(v1))) > (costos.get(getIndexx(x))) + costo(v1, x)) {
					costos.get(getIndexx(v1)) = costos.get(getIndexx(x)) + costo(v1, x);
					caminos.add(getIndexx(v1), caminos.get(getIndexx(v1)) +" "+v1.getId());											
				}					
			}
		}
	}

	public int getIndexx(Vertice v){
		int i = listadeVertices.indexOf(v);
		return i;
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