public class Mesero{

	public static void main(String [] args) {
		
		int numeroDeNodos = 0;
		int numeroDeLados = 0;
		int nodoInicial = 0;
		int nodoFinal = 0;
		In in = new In(args[0]);
		// Vertice de partida con id cocina
		String cocina = new String (args[1]); 
		String idTemp;
		String nodo1;
		String nodo2;
		GrafoNoDirigido GND = new GrafoNoDirigido();

		numeroDeNodos = in.readInt();
		
		for(int i = 0; i < numeroDeNodos; i++) {
			nodoInicial = in.readInt();
			nodoFinal = in.readInt();
			Vertice  vertice = new Vertice(String.valueOf(i), 0.0);
			vertice.ejeX = nodoInicial;
			vertice.ejeY = nodoFinal;
			GND.agregarVertice(vertice);
		}

		numeroDeLados = in.readInt();

		for(int i = 0; i < numeroDeLados;i++ ) {
			nodo1 = in.readString();
			nodo2 = in.readString();
			GND.agregarArista(String.valueOf(i), 0.0,nodo1,nodo2);
		}
	}
}