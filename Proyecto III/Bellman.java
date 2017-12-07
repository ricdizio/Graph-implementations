import java.util.*;
public class Bellman{
	private int[] costos;
	private int[] grado;
	private int[] lados;
	private String[] caminos;
	public int ladosMaximoTemp;
	public int ladosMaximoPos;
	public String cam;

	// habria que aplicarlo para cada vertice del grafo y ver cual es el que tiene el mayor costo
	public Bellman(Digrafo G, Vertice s){
		this.ladosMaximoPos = 0;
		this.ladosMaximoTemp = 0;
		Vertice x;
		Vertice ver;
		int inf = Integer.MAX_VALUE;
		// t es el conjunto de vertices visitados
		List<Vertice> t = new ArrayList<Vertice>();
		t.add(s);
		List<Vertice> listadeVertices = new ArrayList<Vertice>();
		this.costos = new int[G.numeroDeVertices()+1];
		this.grado = new int[G.numeroDeVertices()+1];
		this.caminos = new String[G.numeroDeVertices()+1];
		this.lados = new int[G.numeroDeVertices()+1]; 

		listadeVertices = G.vertices();
			
		for (Vertice v: listadeVertices)
		{
			this.costos[stringToInt(v)] = inf;
			this.grado[stringToInt(v)] = G.gradoInterior(v.getId());
			//this.caminos[stringToInt(v)] = "";
			this.caminos[stringToInt(v)] = v.material + " " + v.cara+" ";
			this.lados[stringToInt(v)] = 0;

			if ( s.equals(v)) {
				//ver = v;
				this.costos[stringToInt(s)] = 0;	
				this.grado[stringToInt(s)] = 0;
				this.lados[stringToInt(v)] = 0;			
			}
		}

		while (t.size() > 0)
		{
			//Collections.sort(cola,comp);
			//x = cola.remove(0);
			x = t.remove(0);

			for (Vertice v1: x.getListaDeSucesores()) 
			{
				this.grado[stringToInt(v1)] = this.grado[stringToInt(v1)] - 1;

				if (this.grado[stringToInt(v1)] == 0) {
					t.add(v1);					
				}

				if (this.costos[stringToInt(v1)] > (this.costos[stringToInt(x)] - 1)) 
				{
					this.costos[stringToInt(v1)] = this.costos[stringToInt(x)] + 1;
					this.lados[stringToInt(v1)] = this.lados[stringToInt(x)] + 1;
					this.caminos[stringToInt(v1)] = this.caminos[stringToInt(x)] + "->" + " "+ x.materialParalelo + " " + v1.cara;											
					if (lados[stringToInt(v1)] > ladosMaximoTemp ) {
						this.ladosMaximoTemp = lados[stringToInt(v1)];
						this.ladosMaximoPos = stringToInt(v1);
						this.cam = this.caminos[stringToInt(v1)];						
					}
				}					

			}
		}
	}

	public int stringToInt(Vertice v){
		int i = Integer.parseInt(v.getId());
		return i;
	}

	public void toString(Digrafo g)
	{
		for(int i = 0; i < g.numeroDeVertices(); i++)
		{	
			System.out.println("Nodo " + i + ": " + this.caminos[i]+"\n" + this.lados[i] + " lados");
		}
	}
}