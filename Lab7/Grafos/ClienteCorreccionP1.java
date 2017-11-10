/**
 * ClienteCorreccionP1
 * Cliente de correccion para el proyecto 1 ci2693, SD 2016
 * Ivette C. Martinez
 */

import java.util.*;

public class ClienteCorreccionP1 {
    
    public static void main(String [] args) {

  	
	String nombre_archivo  = args[0];
	System.out.println("El nombre del archivo es:" + nombre_archivo);
	Digrafo G = new Digrafo();
	GrafoNoDirigido G2 = new GrafoNoDirigido(); 

	G.cargarGrafo(nombre_archivo);
	StdOut.println();
	G2.cargarGrafo(nombre_archivo);

	System.out.println();	System.out.println("El digrafo leido ----- ");
	System.out.println(G.toString());

	System.out.println();	System.out.println("El grafo no dirigido leido ----- ");
	System.out.println(G2.toString());

	System.out.println();	System.out.println("---- Pruebas sobre el digrafo ----- ");
	

	System.out.println();
	System.out.println("agregarVertice (15,1) ----- ");
	System.out.println("Resultado: " + G.agregarVertice("15",1));

	System.out.println();
	System.out.println("agregarVertice (15,1) ----- ");
	System.out.println("Resultado: " + G.agregarVertice("15",1));

	System.out.println();
	System.out.println("agregarArco (11,1.0,6,9) ----- ");
	System.out.println("Resultado: " + G.agregarArco("11",1.0, "6","9"));

	System.out.println();
	System.out.println("agregarArco (11,1.0,6,9) ----- ");
	System.out.println("Resultado: " + G.agregarArco("11",1.0, "6","9"));

	System.out.println(); 
	System.out.println("Estadisticas por nodos ----- ");

	
	for (Vertice v: G.vertices()){
		System.out.println();
		System.out.println("Nodo " + v.getId());

		System.out.print("Incidentes: ");
		System.out.println(G.incidentes(v.getId()));			
		
		System.out.print("Adyacentes: ");
		System.out.println(G.adyacentes(v.getId()));			

		System.out.print("Grado Interior: ");
		System.out.println(G.gradoInterior(v.getId()));

		System.out.print("Grado: ");
		System.out.println(G.grado(v.getId()));
			
		System.out.print("Predecesores:");
		System.out.println(G.predecesores(v.getId()));
	
		System.out.print("Sucesores:");
		System.out.println(G.sucesores(v.getId()));
		
		
	}
	
	System.out.println("\n Eliminando vertices");
	System.out.println("eliminar vertice 4: " + G.eliminarVertice("4"));
	
	System.out.println("\n Eliminando vertices");
	System.out.println("eliminar vertice 12: " + G.eliminarVertice("12"));
	
	System.out.println("toString ----- ");
	System.out.println(G.toString());

		
System.out.println();	System.out.println("---- Pruebas sobre el grafo no dirigido ----- ");
		
	System.out.println();
	System.out.println("agregarArista (11,1.0,6,9) ----- ");
	System.out.println("Resultado: " + G2.agregarArista("11",1.0, "6","9"));

	System.out.println();
	System.out.println("agregarArista (11,1.0,6,9) ----- ");
	System.out.println("Resultado: " + G2.agregarArista("11",1.0, "6","9"));

	System.out.println();
	System.out.println(" Esta Arista (6,9) ----- ");
	System.out.println("Resultado: " + G2.estaLado("6","9"));

	System.out.println();
	System.out.println(" Esta Arista (9,6) ----- ");
	System.out.println("Resultado: " + G2.estaLado("9","6"));	
	
    }
}