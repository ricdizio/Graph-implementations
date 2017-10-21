/**
 *lab4
 */

import java.util.*;
import java.io.*;

public class DeepWeb {
  public static void main(String [] args) {

    String file = args[0];
    Vertice a = new Vertice(args[1],Double.parseDouble(args[1]));
    //int a = Integer.parseInt(args[1]);
    String algoritmo = args[2];
    int longitud = args.length;

    int t = 0;
    //int t = null;
    int posicion = 0;
    boolean salir = true;

    Digrafo g = new Digrafo();
    g.cargarGrafo(file);

    String d = new String("dfs");
    String b = new String("bfs");

    String[] op = {"--arb", "--ord", "--pred"};
    if(longitud == 3){
        salir = false;
        posicion = 4;
    }
    if(longitud==5 && args[3].equalsIgnoreCase("--trunc")){
        t = Integer.parseInt(args[4]);
        System.out.println(t);
        salir = false;

    }
    else if(longitud==6 || longitud==4){
        if(longitud==4){
            for(String i : op)
            {
                if(args[3].equalsIgnoreCase(i)){
                    salir = false;
                    //System.out.println(i);
                    break;
                }
                posicion++;
            }
        }

        else if(longitud==6 && args[3].equalsIgnoreCase("--trunc")){
            t = Integer.parseInt(args[4]);
            for(String i : op){
                if(args[5].equalsIgnoreCase(i)){
                    salir = false;
                    //System.out.println(t+" "+i);
                    break;
                }
                posicion++;
            }
        }
    }
    if(salir){
        System.out.println("No valido");
        System.exit(0);
    }

    if(algoritmo.equalsIgnoreCase(d))
    {
        DepthFirstSearch x = new DepthFirstSearch(g,a,t,posicion);
    }
    else if(algoritmo.equalsIgnoreCase(b))
    {
        BreadthFirstDirectedPaths x = new BreadthFirstDirectedPaths(g,a);
    }
  }
}