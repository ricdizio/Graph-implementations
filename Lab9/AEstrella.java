import java.lang.*;
import java.util.*;
import java.text.DecimalFormat;

public class AEstrella{
	
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
	public AEstrella(GrafoNoDirigido G, String s, String g)
	{
		df = new DecimalFormat("0.0#");
		Double inf = Double.MAX_VALUE;
		Double tentative_gScore = 0.0;
		Vertice x;
		Vertice goal;
		Vertice ver; // vertice de inicio
		// openSet creo que deberia ser fScore
		//List<Vertice>  openSet = new ArrayList<Vertice> ();
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
			this.fScore[stringToInt(v)] = inf;
			this.gScore[stringToInt(v)] = inf;
			//this.cameFrom[stringToInt(v)] = "";
			//this.cameFrom = "";
			this.lados[stringToInt(v)] = 0;
			//openSet.add(v);
			if ( s.equals(v.getId())) {
				ver = v;
				this.gScore[stringToInt(ver)] = 0.0;
				openSet.add(ver);				
			}

			if ( g.equals(v.getId())) {
				goal = v;								
			}
		}
		this.fScore[stringToInt(ver)] = costo(ver, goal);

		// Ordenamos el array list (openSet de prioridad)
		Comparator<Vertice> comp = (Vertice a, Vertice b) -> {
    		return this.fScore[stringToInt(a)].compareTo(this.fScore[stringToInt(b)]);
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

				tentative_gScore = gScore[stringToInt(x)] + costo(x, v1);
            	if (tentative_gScore >= gScore[stringToInt(v1)]){
            		continue;
            	}

				/*if (this.costos[stringToInt(v1)] > (this.costos[stringToInt(x)] + this.costo(x, v1))) 
				{
					this.costos[stringToInt(v1)] = this.costos[stringToInt(x)] + this.costo(x, v1);
					this.lados[stringToInt(v1)] = this.lados[stringToInt(x)] + 1;
					this.caminos[stringToInt(v1)] = this.caminos[stringToInt(x)] + "->" + x.getId();											
				}	*/	
				//cameFrom[stringToInt(v1)] = x.getPeso();
				cameFrom[stringToInt(v1)] = x;
				gScore[stringToInt(v1)] = tentative_gScore;
				fScore[stringToInt(v1)] = gScore[stringToInt(v1)] + costo(v1,goal);			
			}
		}
		/*for(int i = 0; i < G.numeroDeVertices(); i++)
		{
			this.caminos[i] = this.caminos[i] + "->" + i;
			this.caminos[i] = this.caminos[i].substring(2, this.caminos[i].length());
		}*/
	}

	public int stringToInt(Vertice v)
	{
		String str = v.getId();
		Integer pos = Integer.valueOf(str);
		return pos;
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

	public reconstruct_path(Vertice[] cameFrom,Vertice current){
    	total_path.add(current);
    	while current in cameFrom.Keys{
        	current = cameFrom[stringToInt(current)];
        	total_path.add(current);
    		return total_path;
    	}
    }
}