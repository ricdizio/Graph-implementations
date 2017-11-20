import java.lang.*;
import java.util.*;
import java.text.DecimalFormat;

public class AStar{
	
	private List<Vertice> listadeVertices;
	private String caminos[];
	private int lados[];
	private Double costos[];
	private Double costosHeuristica[];
	private DecimalFormat df;
	private List<Vertice> openSet;
	private  List<Vertice> closedSet;
	private Vertice goal[];

	public AStar(GrafoNoDirigido G, String s)
	{
			//PriorityQueue <Vertice>  colaP = new PriorityQueue <Vertice> ()
		// ARRAYsLIST METODO SORTING
		df = new DecimalFormat("0.0#");
		Double inf = Double.MAX_VALUE;
		int pos = 0;
		Vertice x;
		Vertice ver;
		Vertice goal;
		List<Vertice>  cola = new ArrayList<Vertice> (); 
		this.costos = new Double[G.numeroDeVertices()];
		this.costosHeuristica = new Double[G.numeroDeVertices()];
		this.caminos = new String[G.numeroDeVertices()];
		this.lados = new int[G.numeroDeVertices()]; 
		this.closedSet = new ArrayList<Vertice> ();
		this.openSet = new ArrayList<Vertice> ();
		this.goal = new Vertice[G.numeroDeVertices()];



		listadeVertices = G.vertices();
		//int j = 0;

		for (Vertice v: listadeVertices)
		{
			this.costos[doubleToInt(v)] = inf;
			this.costosHeuristica[doubleToInt(v)] = inf;
			this.caminos[doubleToInt(v)] = "";
			this.lados[doubleToInt(v)] = 0;
			openSet.add(v);
			this.goal[doubleToInt(v)] = v;
			if ( s.equals(v.getId())) {
				ver = v;
				this.costos[doubleToInt(ver)] = 0.0;				
			}

			if ( !s.equals(v.getId())) {
				this.costosHeuristica[doubleToInt(v)] = 0.0;				
			}
			//j = j + 1;
		}
		// Ordenamos el array list (openSet de prioridad)
		Comparator<Vertice> comp = (Vertice a, Vertice b) -> {
    		return this.costosHeuristica[doubleToInt(a)].compareTo(this.costosHeuristica[doubleToInt(b)]);
		};

		Collections.sort(openSet,comp);

		while (openSet.size() > 0)
		{
			Collections.sort(openSet,comp);
			x = openSet.remove(0);
			closedSet.add(x);

			for (Vertice v1: x.getListaDeAdyacencias()) 
			{
				if (closedSet.contains(v1)) {
					continue;
				}
				//en caso de falla revisar esta condicion(posiblemente comentarla)
				/*if (!openSet.contains(v1)) {
					openSet.add(v1);
				}*/

				if (this.costos[doubleToInt(v1)] > (this.costos[doubleToInt(x)] + this.costo(x, v1))) 
				{
					System.out.println(" Entro al if de costos");
					this.costos[doubleToInt(v1)] = this.costos[doubleToInt(x)] + this.costo(x, v1);
					//this.costos seria hasta el vertice v1 al goal , Flaviani recomendo hacerlo hasta el vertice de llegada el costoHeuristica, ver por que
					this.costosHeuristica[doubleToInt(v1)] = this.costos[doubleToInt(v1)]+this.costo(v1,this.goal[doubleToInt(v1)]);
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
			System.out.println("Nodo " + i + ": " + this.caminos[i]+"\t \t" + lados[i] + " lados" + " (costo "+ df.format(this.costosHeuristica[i])+ ")");
		}
	}
}