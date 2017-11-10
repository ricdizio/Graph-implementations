public class Mesero{

	public static void main(String [] args) {
		
		int numeroDeNodos = 0;
		int numeroDeLados = 0;
		int nodoInicial = 0;
		int numeroDeLados = 0;
		int nodoInicial = 0;
		int nodoFinal = 0;
		In in = new In(args[0]);
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
			GND.agregarLado(String.valueOf(i), nodo1,nodo2);
		}
	}
}