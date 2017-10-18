/**
 *
 */

import java.util.*;
import java.io.*;

public class ClienteGrafo {
  public static void main(String [] args) {

    //--------------------------------------------------Cliente Grafo No Dirigido
    GrafoNoDirigido g = new GrafoNoDirigido();
    g.cargarGrafo(args[0]);
    //g.eliminarArista("arista1");
    //g.eliminarArista("arista2");
    //g.eliminarArista("arista3");
    //g.eliminarArista("arista4");
    //g.eliminarArista("arista5");
    //g.eliminarVertice("v5");
    //g.eliminarVertice("v1");
    //System.out.println("El grado del vertice v1 es  "+g.grado("v2"));
    //System.out.println("El numero de Vertices en el grafo es  "+g.numeroDeVertices());
    //System.out.println("El numero de lados en el grafo es  "+g.numeroDeLados());
    //Vertice vertice = new Vertice("v9",10.0);
    ///System.out.println("Se agregó el vertice v9?  "+g.agregarVertice(vertice));
    //System.out.println("Esta el vertice 9?  "+g.estaVertice("v9"));
    //System.out.println("Esta el lado?  "+g.estaLado("v1","v2"));
    //System.out.println(g.toString());
    //System.out.println("GRAFO NO DIRIGIDO CLON -----------------------------" + "\n");
    //System.out.println(g.clone().toString());
    

    /*
  	Vertice x = new Vertice("1",1);
  	Vertice y = new Vertice("2" ,2);	
  	String id = x.getId();
  	Double peso = x.getPeso();
  	String id2 = x.getId();
  	Double peso2 = x.getPeso();
  	
  	System.out.println("el id es "+id+"\n"+"el peso es "+peso);
  	System.out.println("el id es "+id2 +"\n"+"el peso es "+ peso2);
  	
  	Arista arista = new Arista("arista1", 5.0, x, y);
  	StdOut.print("\n"+arista.toString());

  	Arco arco = new Arco("arco1",6.0,x,y);
  	StdOut.print("\n"+arco.toString());
    */
    //----------------------------------------------------------------------- Cliente Digrafos
    Digrafo dg = new Digrafo();
    dg.cargarGrafo(args[0]);
    //dg.eliminarArco("arista1");
    //dg.eliminarVertice("v1");
    //System.out.println(dg.toString());
    //g.eliminarArista("arista1");
    System.out.println(dg.toString());
    System.out.println("DIGRAFO CLON -----------------------------" + "\n");
    System.out.println(dg.clone().toString());
  }
}