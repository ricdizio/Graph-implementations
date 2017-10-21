/**
 *
 */

import java.util.*;
import java.io.*;

public class DeepWeb {
  public static void main(String [] args) {

    String file = args[0];
    int a = args[1].parseInt();
    String algoritmo = args[2];

    Digrafo g = new Digrafo();
    g.cargarGrafo(file);
    String d = new String("DFS");
    String b = new String("BFS");

    if(algoritmo==d.String.equalsIgnoreCase()){
        DepthFirstSearch x = new DepthFirstSearch(g,a);
    }
    else if(algoritmo==b.String.equalsIgnoreCase()){
        BreadthFirstDirectedPaths x = new BreadthFirstDirectedPaths(g,a);
    }
  }
}