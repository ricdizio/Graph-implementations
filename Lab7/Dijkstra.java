import java.lang.*;
import java.util.*;

public class Dijkstra{
<<<<<<< HEAD

	public static void main(String[] args) 
	{
		Int inf = Integer.MAX_VALUE;

		public Dijkstra(GrafoNoDirigido G, Vertice s){
			PriorityQueue <Vertice>  colaP = new PriorityQueue <Vertice> ()
			List<Vertice> listadeVertices = new LinkedList<Vertice>();
			List<Integer> costos = new LinkedList<Integer>();
			List<String> caminos = new LinkedList<String>();
			listadeVertices = G.vertice();
			for (Vertice v: listadeVertices) {
				costos.add(listadeVertices.getIndex(v), inf);
				caminos.add(listadeVertices.getIndex(v), null);
				colaP.add(v);
			}
			costos.add(listadeVertices.getIndex(s), 0);

			// usamos la cola

			while (colaP.size() > 0){
				
								
=======
	
	public List<Vertice> listadeVertices;

	public Dijkstra(GrafoNoDirigido G, Vertice s){
			//PriorityQueue <Vertice>  colaP = new PriorityQueue <Vertice> ()
		// ARRAYsLIST METODO SORTING
		int inf = Integer.MAX_VALUE;
		Vertice x;
		List<Vertice>  cola = new ArrayList<Vertice> (); 
		int costos[] = new int[G.numeroDeVertices()];
		String caminos[] = new String[G.numeroDeVertices()]; 

		listadeVertices = G.vertices();
			
		for (Vertice v: listadeVertices) {
			costos[doubleToInt(v)] = inf;
			caminos[doubleToInt(v)] = "";
			cola.add(v);
		}
		costos[doubleToInt(s)] = 0;

		while (cola.size() > 0){
			x = cola.remove(0);

			for (Vertice v1: x.getListaDeAdyacencias()) {
				//costos.get(getIndexx(v1);
				if (costos[doubleToInt(v1)] > (costos[doubleToInt(x)] + costo(x, v1))) {
					
					costos[doubleToInt(v1)] = costos[doubleToInt(x)] + costo(x, v1);
					caminos[doubleToInt(v1)] = caminos[doubleToInt(v1)] + "->" + x.getId();											
				}					
>>>>>>> 10eea5c2fe888d50024c86df88c50b4d7ec5b3de
			}
		}
	}

<<<<<<< HEAD
		public int costo(Vertice x, Vertice y)
		{
			int sumX = 0;
			int sumY = 0;
			int distEuclid = 0;
			sumX = Math.pow((x.ejeX - y.ejeX),2);
			sumY = Math.pow((x.ejeY - y.ejeY),2);
			distEuclid = Math.sqrt(sumX + sumY);
			return distEuclid;

		}
=======
	public int doubleToInt(Vertice v){
		int i = (int)v.getPeso();
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

>>>>>>> 10eea5c2fe888d50024c86df88c50b4d7ec5b3de
	}
}