import java.util.*;

public class CompruebaMatriz{

	public void CompruebaMatriz(String[][] matrizResultado){
		String file = args[1];
   		In in = new In(file);
   		int filas = in.readInt();
    	int columnas = in.readInt();
    	int cantidadDeNodos = filas * columnas;
    	String[][] matriz = new String[filas][columnas];
    	String valor;

    	for (int i = 0; i < filas ; i++ ) {
    		for (int j = 0; j < columnas; j++) {
    			valor = in.readString();
    			matriz[i][j] =  valor;
    		}
    	}

	        if (matrizResultado.equals(matriz)) {
	        	System.out.println(" La matriz resultado para este caso hace match con el caso solucion de Flaviani"+" \n");	        	
	        }
	        else{
	        	System.out.println(" La matriz resultado para este caso no hace match con el caso solucion de Flaviani :("+" \n");
	        }
	    }
   }