public class Mesero{

	public static void main(String [] args) {
		
		String input_txt = args[0];

		// Vertice de partida con id cocina
		String cocina = new String (args[1]);
		int numeroDeNodos = 0;
		GrafoNoDirigido gnd = new GrafoNoDirigido();

		gnd.cargarGrafo(input_txt);

		Dijkstra d = new Dijkstra(gnd,cocina);

		d.toString(gnd);
	}
}