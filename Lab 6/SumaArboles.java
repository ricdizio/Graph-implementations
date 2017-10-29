/**********************************************************************************************************
 *    Compilacion:  javac SumaArboles.java
 *    Ejecucion:    java  SumaArboles NombreArchivo.txt
 *    Dependencias In.java,vertice.java,Lado.java, Arista.java, Grafo.java, Digrafo.java
 *    
 *
 *    @author  Ricardo Di Zio 11-11274
 *    @author  Fabio Suarez   12-10578
 *    @version 1.0
 *    @since   2017-27-10
 *
 *
 *************************************************************************************************************/
import java.util.*;
import java.io.*;

public class SumaArboles{
    public List<String> arregloDeLineas;
    //private In in;
    public int cuentaLineas;
    public String words[];
    //private String line;
  
  public static void main(String [] args) {
        List<String>  arregloDeLineas = new ArrayList<String>();
        String[] words;
        int cuentaLineas = 1;
        //Cargamos archivo
        String line;
        String linee;
        String file = args[0];
        In in = new In(file);
        StringBuilder builder = new StringBuilder();

        int contador = 0;
        int contador1 = 0;
        int count = 0;
        int index = 0;
        int index1 = 0;
        String tempLine;
        String tempWords[];
        String temporal;
        String temporal2; 
        List<Integer> words1 = new ArrayList<Integer>();
        int tamano = 0;
        String[] grafoArray;
        List<Vertice> hojas = new ArrayList<Vertice>();
        List<Vertice> raiz = new ArrayList<Vertice>();
        List<Double> camino = new ArrayList<Double>();
        int contador2 = 0; 
        double suma = 0;

        // Extraemos los enteros
        while(in.hasNextLine()){
            line = in.readLine().replaceAll("\\s+","");
            index = line.indexOf("(");
            temporal2 = line.substring(0,index).replaceAll("\\s+","").replaceAll("\t","");
            try{
                words1.add(Integer.parseInt(line.substring(0,index)));
            }
            finally{
                continue;
            }
        }

        for (int i=0;i<words1.size();i++) {
            System.out.println(words1.get(i));
        }
    
        In iin = new In(file);
        linee = iin.readAll().replaceAll("\\s+","");
        words = linee.split("");
        for (int i=0; i < words.length;i++) {
            if (words[i].equals("(")) {
                builder.append(words[i]);
                contador++;
            }
            else if (contador >= 1) {
                builder.append(words[i]);
            }
            if (words[i].equals(")")) {
                contador1++;
            }
            if (contador == contador1) {
                if (contador > 1 && contador > 1) {
                    arregloDeLineas.add(builder.toString());
                    contador = 0;
                    contador1 = 0;
                    builder.setLength(0);
                }
            }            
        }

        for (int i=0;i<arregloDeLineas.size();i++) {
            temporal = arregloDeLineas.get(i);
<<<<<<< HEAD
            grafoArray = temporal.split(""); 
            //Cargamos el grafo para cada instancia
            g.cargarGrafo(grafoArray,-1,0);
            //System.out.println(arregloDeLineas.get(i));
            //for (int j=0;j < grafoArray.length;j++) {
                // Se procede a la carga del grafo
                //System.out.println(grafoArray[j]);
            //}
=======
            grafoArray = temporal.split("");
            //System.out.println(arregloDeLineas.get(i));
            System.out.println("\n");
            System.out.println("DIGRAFO "+ i+"--------------------------------------------------------------------------------------------------");
            Digrafo g = new Digrafo();
            
            g.cargarGrafo(grafoArray,-1,0);
            
            for (Vertice v:g.vertices()) {
                if (v.getListaDePredecesores().size() == 0) {
                    raiz.add(v);
                    System.out.println("VERTICES RAIZ -------------------------------------------------------------------------");
                    System.out.println(v.getPeso()+ "\n");

                }
                if (v.getListaDeSucesores().size() == 0){
                    hojas.add(v);
                    System.out.println("VERTICES HOJAS -------------------------------------------------------------------------");
                    System.out.println(v.getPeso()+ "\n");

                }
            }
            DepthFirstSearch dfs = new DepthFirstSearch(g,raiz.get(0));
            //dfs.dfsPath(raiz.get(0));
            // Procedemos a hallar los caminos
            for (Vertice v: hojas) {
                System.out.println("DIGRAFO "+i);
                //dfs.dfsPath(raiz.get(0));
                camino = dfs.printPath(raiz.get(0),v);
                for (Double doble:camino) {
                    suma = suma+doble;
                }
                System.out.println("suma de camino = "+ suma);
                if (suma == words1.get(i)) {
                    contador2 = 1;
                    System.out.println("yes"+"\n");
                    break;                    
                }
                contador2 = 0;
                suma = 0;
                camino.clear();
            }
            if (contador2 == 0) {
                System.out.println("no"+"\n");
            }
            if (g.numeroDeVertices() == 0) {
                System.out.println("no"+"\n");                
            }
            raiz.clear();
            hojas.clear();
>>>>>>> 4356514b7cd3b8e3fd9ba3571f25a3424c290ba9
        }
    }
}

