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
    int logitud = args.length;
    int t;
    String[] op = {"--arb", "--ord", "--pred"};

    if(logitud==5 && args[3].equalsIgnoreCase("--trunc")){
        t = Integer.parseInt(args[4]);
    }
    else if(logitud==6 || logitud==4){
        if(logitud==4){
            for(String i : op){
                if(args[3].equalsIgnoreCase(i)){
                    break;
                }
                else{
                    System.out.println("Opcion "+ i +" no valida");
                    System.exit(0);
                }
            }
            
        }

        else if(logitud==6){
            t = Integer.parseInt(args[4]);
            for(String i : op){
                if(args[5].equalsIgnoreCase(i)){
                    // Selecciono el tipo de datos
                }
                else{
                    System.out.print("Opcion "+ i +" no valida");
                    System.exit(0);
                }
            }
        }
    }
    else{
        System.out.println("No valido");
        System.exit(0);
    }

    Digrafo g = new Digrafo();
    g.cargarGrafo(file);
    String d = new String("dfs");
    String b = new String("bfs");

    if(algoritmo.equalsIgnoreCase(d)){
        DepthFirstSearch x = new DepthFirstSearch(g,a);
    }
    else if(algoritmo.equalsIgnoreCase(b)){
        //BreadthFirstDirectedPaths x = new BreadthFirstDirectedPaths(g,a);
    }
  }
}