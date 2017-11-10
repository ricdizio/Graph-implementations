import java.lang.*;
import java.util.*;

public class Dijkstra{

	public static void main(String[] args) {
		Int inf = Integer.MAX_VALUE;

		public Dijkstra(GrafoNoDirigido G, Vertice s){
			PriorityQueue < String >  p_queue = new PriorityQueue < String > ()
			List<Vertice> listadeVertices = new LinkedList<Vertice>();
			List<Integer> costos = new LinkedList<Integer>();
			List<String> caminos = new LinkedList<String>();
			listadeVertices = G.vertice();
			for (Vertice v: listadeVertices) {
				costos.add(listadeVertices.getIndex(v), inf);
				caminos.add(listadeVertices.getIndex(v), null);
			}
			costos.add(listadeVertices.getIndex(s), 0);

			// usamos la cola


		}

		public int costo(Vertice x, Vertice y){
			int sumX = 0;
			int sumY = 0;
			int distEuclid = 0;
			sumX = Math.pow((x.ejeX - y.ejeX),2);
			sumY = Math.pow((x.ejeY - y.ejeY),2);
			distEuclid = Math.sqrt(sumX + sumY);
			return distEuclid;

		}
		
	}
}