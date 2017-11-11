public class Mesero{

	public static void main(String [] args) {
		
		String input_txt = args[0];

		// Vertice de partida con id cocina
		String cocina = new String (args[1]);
		int numeroDeNodos = 0;
		GrafoNoDirigido gnd = new GrafoNoDirigido();
<<<<<<< HEAD
		
=======
		//String cocina = new String (args[1]); 
		String idTemp;
		String nodo1;
		String nodo2;

		//numeroDeNodos = in.readInt();
		
		/**for(int i = 0; i < numeroDeNodos; i++) {
			nodoInicial = in.readInt();
			nodoFinal = in.readInt();
			Vertice  vertice = new Vertice(String.valueOf(i), 1.0);
			vertice.ejeX = nodoInicial;
			vertice.ejeY = nodoFinal;
			gnd.agregarVertice(vertice);
		}*/
>>>>>>> 10eea5c2fe888d50024c86df88c50b4d7ec5b3de
		gnd.cargarGrafo(input_txt);

<<<<<<< HEAD
		String x = gnd.toString();
=======
		/**for(int i = 0; i < numeroDeLados;i++ ) {
			nodo1 = in.readString();
			nodo2 = in.readString();
			gnd.agregarArista(String.valueOf(i), 1.0,nodo1,nodo2);
		}*/
>>>>>>> 10eea5c2fe888d50024c86df88c50b4d7ec5b3de

		System.out.println(x);
	}
}