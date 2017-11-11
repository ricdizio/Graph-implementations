import java.lang.*;
import java.util.*;
import java.text.DecimalFormat;

public class Dijkstra{
	
	public List<Vertice> listadeVertices;
	public String caminos[];
	public int lados[];
	public Double costos[];
	public DecimalFormat df;

	public Dijkstra(GrafoNoDirigido G, String s)
	{
			//PriorityQueue <Vertice>  colaP = new PriorityQueue <Vertice> ()
		// ARRAYsLIST METODO SORTING
		df = new DecimalFormat("0.0#");
		Double inf = Double.MAX_VALUE;
		Vertice x;
		Vertice ver;
		List<Vertice>  cola = new ArrayList<Vertice> (); 
		this.costos = new Double[G.numeroDeVertices()];
		this.caminos = new String[G.numeroDeVertices()];
		this.lados = new int[G.numeroDeVertices()]; 
<<<<<<< HEAD

=======
>>>>>>> 8e422efb3fa6016f1858a6eaab094a8919e1fbe4

		listadeVertices = G.vertices();
			
		for (Vertice v: listadeVertices)
		{
			this.costos[doubleToInt(v)] = inf;
			this.caminos[doubleToInt(v)] = "";
			this.lados[doubleToInt(v)] = 0;
			cola.add(v);
			if ( s.equals(v.getId())) {
				ver = v;
				this.costos[doubleToInt(ver)] = 0.0;				
			}
		}
		// Ordenamos el array list (cola de prionidad)
		Comparator<Vertice> comp = (Vertice a, Vertice b) -> {
    		return this.costos[doubleToInt(a)].compareTo(this.costos[doubleToInt(b)]);
		};

		Collections.sort(cola,comp);

		while (cola.size() > 0)
		{
			Collections.sort(cola,comp);
			x = cola.remove(0);

<<<<<<< HEAD
			for (Vertice v1: x.getListaDeAdyacencias()) 
			{

				if (this.costos[doubleToInt(v1)] > (this.costos[doubleToInt(x)] + this.costo(x, v1))) 
				{
=======
			//System.out.println(x);
			for (Vertice v1: x.getListaDeAdyacencias()) {
				/*System.out.println(this.costos[doubleToInt(v1)]);
				System.out.println(this.costos[doubleToInt(x)]);
				System.out.println(this.costo(x, v1));
				System.out.println("");*/
				if (this.costos[doubleToInt(v1)] > (this.costos[doubleToInt(x)] + this.costo(x, v1))) {
>>>>>>> 8e422efb3fa6016f1858a6eaab094a8919e1fbe4
					this.costos[doubleToInt(v1)] = this.costos[doubleToInt(x)] + this.costo(x, v1);
					this.lados[doubleToInt(v1)] = this.lados[doubleToInt(x)] + 1;
					this.caminos[doubleToInt(v1)] = this.caminos[doubleToInt(x)] + "->" + x.getId();											
				}					
			}
		}
		for(int i = 0; i < G.numeroDeVertices(); i++)
		{
			this.caminos[i] = this.caminos[i] + "->" + i;
			this.caminos[i] = this.caminos[i].substring(2, this.caminos[i].length());
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
			System.out.println("Nodo " + i + ": " + this.caminos[i]+" " + lados[i] + " lados" + " (costo "+ df.format(this.costos[i])+ ")");
		}
	}
}