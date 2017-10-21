/**
 *
 */

import java.util.*;
import java.io.*;

public class DeepWeb {
  public static void main(String [] args) {

    String file = args[0];
    Vertice a = new Vertice(args[1],Double.parseDouble(args[1]));
    //int a = Integer.parseInt(args[1]);
    String algoritmo = args[2];

    Digrafo g = new Digrafo();
    g.cargarGrafo(file);
    String d = new String("DFS");
    String b = new String("BFS");

    if(algoritmo.equalsIgnoreCase(d)){
        DepthFirstSearch x = new DepthFirstSearch(g,a);
    }
    else if(algoritmo.equalsIgnoreCase(b)){
        //BreadthFirstDirectedPaths x = new BreadthFirstDirectedPaths(g,a);
    }
  }
}