public class Recorador
{
	public static void main(String [] args) {
		
		String input_txt = args[0];

		// Vertice de partida con id cocina
		String cocina = new String (args[1]);

		int numeroDeNodos = 0;

		GrafoNoDirigido gnd = new GrafoNoDirigido();

		gnd.cargarGrafo(input_txt);

<<<<<<< Updated upstream:Lab9/Recorador.java
		AEstrella costo;

		for( Vertice c :gnd.vertices())
		{

			if(cocina != c.getId())
			{
				costo = new AEstrella(gnd,cocina,c);
			}
		}
=======
		//Dijkstra d = new Dijkstra(gnd,cocina);
		AStar a = new AStar(gnd,cocina);

		a.toString(gnd);
>>>>>>> Stashed changes:Lab9/Mesero.java
	}
}