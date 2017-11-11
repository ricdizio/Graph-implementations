import java.lang.*;
import java.util.*;

public class Dijkstra{
	
	public List<Vertice> listadeVertices;
	public String caminos[];

	public Dijkstra(GrafoNoDirigido G, String s)
	{
			//PriorityQueue <Vertice>  colaP = new PriorityQueue <Vertice> ()
		// ARRAYsLIST METODO SORTING
		Double inf = Double.MAX_VALUE;
		Vertice x;
		Vertice ver;
		List<Vertice>  cola = new ArrayList<Vertice> (); 
		Double costos[] = new Double[G.numeroDeVertices()];
		this.caminos = new String[G.numeroDeVertices()]; 

		listadeVertices = G.vertices();
			
		for (Vertice v: listadeVertices)
		{
			costos[doubleToInt(v)] = inf;
			this.caminos[doubleToInt(v)] = "";
			cola.add(v);
			if ( s.equals(v.getId())) {
				ver = v;
				costos[doubleToInt(ver)] = 0.0;				
			}
		}
		// Ordenamos el array list (cola de prionidad)
		Comparator<Vertice> comp = (Vertice a, Vertice b) -> {
    		return costos[doubleToInt(a)].compareTo(costos[doubleToInt(b)]);
		};

		Collections.sort(cola,comp);

		while (cola.size() > 0){
			Collections.sort(cola,comp);
			x = cola.remove(0);

			System.out.println(x);
			for (Vertice v1: x.getListaDeAdyacencias()) {
				//costos.get(getIndexx(v1);
				if (costos[doubleToInt(v1)] > (costos[doubleToInt(x)] + this.costo(x, v1))) {
					costos[doubleToInt(v1)] = costos[doubleToInt(x)] + this.costo(x, v1);
					this.caminos[doubleToInt(v1)] = this.caminos[doubleToInt(v1)] + "->" + x.getId();											
				}					
			}
		}
	}

	public int doubleToInt(Vertice v)
	{
		Double x = v.getPeso();
		int i = x.intValue();
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

	public void toString(GrafoNoDirigido g)
	{
		for(int i = 0; i < g.numeroDeVertices(); i++)
		{
			System.out.println("Nodo " + i + ": " + this.caminos[i]);
		}
	}
}