import java.lang.*;
import java.util.*;
import java.text.DecimalFormat;

public class AEstrella{
	
	private List<Vertice> listadeVertices;
	private String caminos[];
	private int lados[];
	private Double costos[];
	private DecimalFormat df;
	private Set<Vertice> closedSet = new HashSet<Vertice>();
	private Set<Vertice> openSet = new HashSet<Vertice>();
	private Double fScore[];
	// s start vertice y g goal vertice
	// Falta hacer el conteo de los lados y probar si funciona la implementacion
	public AEstrella(GrafoNoDirigido G, String s, String g)
	{
		df = new DecimalFormat("0.0#");
		Double inf = Double.MAX_VALUE;
		Double tentative_gScore = 0.0;
		Vertice x;
		Vertice goal;
		Vertice ver;
		// cola creo que deberia ser fScore
		//List<Vertice>  cola = new ArrayList<Vertice> ();
		this.closedSet = new ArrayList<Vertice> ();
		this.openSet = new ArrayList<Vertice> ();
		this.gScore = new Double[G.numeroDeVertices()];
		this.costos = new Double[G.numeroDeVertices()];
		this.caminos = new String[G.numeroDeVertices()];
		this.lados = new int[G.numeroDeVertices()]; 
		this.cameFrom = new Double[G.numeroDeVertices()];
		this.fScore = new Double[G.numeroDeVertices()];


		listadeVertices = G.vertices();
			
		for (Vertice v: listadeVertices)
		{
			this.fScore[doubleToInt(v)] = inf;
			this.gScore[doubleToInt(v)] = inf;
			this.cameFrom[doubleToInt(v)] = "";
			this.lados[doubleToInt(v)] = 0;
			cola.add(v);
			this.fScore[doubleToInt(v)] = costo(s, v);
			if ( s.equals(v.getId())) {
				ver = v;
				this.gScore[doubleToInt(ver)] = 0;				
			}

			if ( g.equals(v.getId())) {
				goal = v;								
			}
		}
		// Ordenamos el array list (cola de prioridad)
		Comparator<Vertice> comp = (Vertice a, Vertice b) -> {
    		return this.fScore[doubleToInt(a)].compareTo(this.fScore[doubleToInt(b)]);
		};

		//Collections.sort(openSet,comp);


		while (openSet.size() > 0)
		{
			Collections.sort(openSet,comp);
			x = openSet.remove(0);
			if (x.getId().equals(g)) {
				return reconstructPath(camefrom,current);
			}
			openSet.remove(current);
			closedSet.add(current);

			for (Vertice v1: x.getListaDeAdyacencias()) 
			{
				if (closedSet.contains(v1)) {
					continue;
				}

				if (!openSet.contains(v1)) {
					openSet.add(v1);
				}

				tentative_gScore := gScore[doubleToInt(x)] + dist_between(x, v1);
            	if (tentative_gScore >= gScore[doubleToInt(v1)]){
            		continue;
            	}

				/*if (this.costos[doubleToInt(v1)] > (this.costos[doubleToInt(x)] + this.costo(x, v1))) 
				{
					this.costos[doubleToInt(v1)] = this.costos[doubleToInt(x)] + this.costo(x, v1);
					this.lados[doubleToInt(v1)] = this.lados[doubleToInt(x)] + 1;
					this.caminos[doubleToInt(v1)] = this.caminos[doubleToInt(x)] + "->" + x.getId();											
				}	*/	
				cameFrom[doubleToInt(v1)] = x.getPeso();
				gScore[doubleToInt(v1)] = tentative_gScore;
				fScore[doubleToInt(v1)] = gScore[doubleToInt(v1)] + costo(v1,goal);			
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
			System.out.println("Nodo " + i + ": " + this.caminos[i]+"\t \t" + lados[i] + " lados" + " (costo "+ df.format(this.costos[i])+ ")");
		}
	}
}