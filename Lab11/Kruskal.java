public class Kruskal{

	public static void main(String [] args) {
		
		String input_txt = args[0];

		In inputFile = new In(input_txt);

		int casos = inputFile.readInt();

		int contador = 1;

		for (int i = 0; i<casos ; i++)
		{
			EdgeWeightedGraph g = new EdgeWeightedGraph(inputFile);
			KruskalAlgorithm k = new KruskalAlgorithm(g);
			System.out.println("Caso " + contador++ + ":" );
			// Colocamos parse int ya que en la salida del PDF se muestra de tipo entero
			System.out.println( (int) k.weight());
			System.out.println();
		}

	}
}