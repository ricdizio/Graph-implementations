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
        List<String> ids_hojas = new ArrayList<String>();

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
            grafoArray = temporal.split("");
            //System.out.println(arregloDeLineas.get(i));
            System.out.println("\n");
            System.out.println("DIGRAFO "+ i+"--------------------------------------------------------------------------------------------------");
            Digrafo g = new Digrafo();
            g.cargarGrafo(grafoArray,-1,0);
            for (Vertice v:g.vertices()) {
                if (v.getListaDeSucesores().size() == 0){
                    ids_hojas.add(v.getId());
                    System.out.println("VERTICES HOJAS -------------------------------------------------------------------------");
                    System.out.println(v.getPeso()+ "\n");
                }
            }
        }
    }
}

