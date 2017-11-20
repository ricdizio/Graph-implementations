import java.lang.*;
import java.util.*;
import java.text.DecimalFormat;

public class A{
	
	private List<Vertice> listadeVertices;
	private String caminos[];
	private int lados[];
	private Double costos[];
	private DecimalFormat df;
	//private Set<Vertice> closedSet = new HashSet<Vertice>();
	//private Set<Vertice> openSet = new HashSet<Vertice>();
	private List<Vertice> openSet;
	private  List<Vertice> closedSet;
	private  List<Vertice> total_path;
	private Double fScore[];
	private Double gScore[];
	private Vertice cameFrom[];
	private Vertice goal;
	private Vertice ver;
	// s start vertice y g goal vertice
	// Falta hacer el conteo de los lados y probar si funciona la implementacion
	public A(GrafoNoDirigido G, String s, String g)
	{
		df = new DecimalFormat("0.0#");
		Double inf = Double.MAX_VALUE;
		//Double tentative_gScore = 0.0;
		Vertice x;
		Vertice goal;
		Vertice start; // vertice de inicio
		// openSet creo que deberia ser fScore
		//List<Vertice>  openSet = new ArrayList<Vertice> ();
		this.closeSet = new ArrayList<Vertice> ();
		this.openSet = new ArrayList<Vertice> ();
		//this.gScore = new Double[G.numeroDeVertices()];
		listadeVertices = G.vertices();
			
		for (Vertice v: listadeVertices)
		{
			//this.fScore[doubleToInt(v)] = inf;
			//this.gScore[doubleToInt(v)] = inf;
			//this.cameFrom[doubleToInt(v)] = "";
			//this.cameFrom = "";
			//this.lados[doubleToInt(v)] = 0;
			//openSet.add(v);
			if ( s.equals(v.getId())) {
				start = v;
				//this.gScore[doubleToInt(ver)] = 0.0;
				openSet.add(ver);				
			}

			if ( g.equals(v.getId())) {
				goal = v;								
			}
		}
		openSet.add(start);
		//this.fScore[doubleToInt(ver)] = costo(ver, goal);

		// Ordenamos el array list (openSet de prioridad)
		Comparator<Vertice> comp = (Vertice a, Vertice b) -> {
    		return this.fScore[doubleToInt(a)].compareTo(this.fScore[doubleToInt(b)]);
		};

		//Collections.sort(openSet,comp);


		while (openSet.size() > 0)
		{
			Collections.sort(openSet,comp);
			x = openSet.remove(0);
			closedSet.add(x);
			if (x.getId().equals(g)) {
				return reconstructPath(this.cameFrom,x);
			}			

			for (Vertice v1: x.getListaDeAdyacencias()) 
			{
				if (closedSet.contains(v1)) {
					continue;
				}

				if (!openSet.contains(v1)) {
					openSet.add(v1);
				}

				tentative_gScore = gScore[doubleToInt(x)] + costo(x, v1);
            	if (tentative_gScore >= gScore[doubleToInt(v1)]){
            		continue;
            	}

				/*if (this.costos[doubleToInt(v1)] > (this.costos[doubleToInt(x)] + this.costo(x, v1))) 
				{
					this.costos[doubleToInt(v1)] = this.costos[doubleToInt(x)] + this.costo(x, v1);
					this.lados[doubleToInt(v1)] = this.lados[doubleToInt(x)] + 1;
					this.caminos[doubleToInt(v1)] = this.caminos[doubleToInt(x)] + "->" + x.getId();											
				}	*/	
				//cameFrom[doubleToInt(v1)] = x.getPeso();
				cameFrom[doubleToInt(v1)] = x;
				gScore[doubleToInt(v1)] = tentative_gScore;
				fScore[doubleToInt(v1)] = gScore[doubleToInt(v1)] + costo(v1,goal);			
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
}