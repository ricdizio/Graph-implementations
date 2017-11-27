// Lab09
// Ricardo Di Zio 11-11274
// Fabio Suarez   12-10578

import java.util.*;

public class Orden{
  
  public static void main(String [] args) {

  	// Lectura del txt
  	In in = new In(args[0]);
  	String[] arregloL;
  	String[] dependencias;
  	String dependenciasL;
    String verticeImpID;
  	String verticeVerDependencias; //es el archivo  al que se le va a averiguar el orden de su dependencias  
  	String readL;
  	String[] arregloDependencias;
  	int index;
    int contadorArcos = 0; 
    int contador = 0;
    List<Vertice> topoArrayList; 

    Digrafo d = new Digrafo();

  	while (in.hasNextLine()) {
  		
  		readL = in.readLine();

  		index =  readL.indexOf(":");

  		arregloL = readL.split(":");
  		
  		verticeVerDependencias = arregloL[0];

      if(contador == 0){
        verticeImpID = arregloL[0]; // archivo.java al que se le desean ver el orden de las dependencias a la hora de compilar
      }
  		
      contador = contador + 1;

  		dependenciasL = readL.substring(index+2);

  		arregloDependencias = dependenciasL.split(" ");

      d.agregarVertice(verticeVerDependencias,0.0);

      for (int i = 0; i < arregloDependencias.length; i++) {

        d.agregarVertice(arregloDependencias[i],0.0);
        d.agregarArco(String.valueOf(contadorArcos),0.0,arregloDependencias[i], verticeVerDependencias);
        contadorArcos = contadorArcos + 1;  

      }
  	}
      //System.out.println(d.toString());
      ordenTopologico topo = new ordenTopologico();

      topoArrayList = topo.ordenTopologico(d);

      for (Vertice v: topoArrayList) {
        System.out.print(v.getId() + " ");        
      }
  }
}