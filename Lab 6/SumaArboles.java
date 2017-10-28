/**
 *lab4
 */

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
        //this.in = new In(file);
        String words[];
        String grafoArray[];
        int cuentaLineas = 1;
        //Cargamos archivo
        String line;
        String linee;
        Digrafo g = new Digrafo();
        //String line;
        //String words[];
        List<String> words1 = new ArrayList<String>();
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
        String[] linea;
        String temporal;

        // Extraemos los enteros
        while(in.hasNextLine()){
            line = in.readLine().replaceAll("\\s+","");
            //words = line.split("");
            index = line.indexOf("(");
            if (line.substring(0,index) != " ") {
                words1.add(line.substring(0,index)); 
            }
        }

        for (int i=0;i<words1.size();i++) {
            System.out.println(words1.get(i));
        }
    
        In iin = new In(file);
        linee = iin.readAll().replaceAll("\\s+","");
        words = linee.split("");
        for (int i=0; i < words.length;i++) {
            if (contador >= 1) {
                builder.append(words[i]);
            }
            if (words[i].equals("(")) {
                builder.append(words[i]);
                contador++;
            }
            if (words[i].equals(")")) {
                contador1++;
            }
            if (contador == contador1) {
                arregloDeLineas.add(builder.toString());
                contador = 0;
                contador1 = 0;
                builder.setLength(0);
            }            
        }

        for (int i=0;i<arregloDeLineas.size();i++) {
            temporal = arregloDeLineas.get(i);
            grafoArray = temporal.split(""); ;
            //System.out.println(arregloDeLineas.get(i));
            for (int j=0;j<grafoArray.length;j++) {
                System.out.println(grafoArray[j]+"\n");
                // Se procede a la carga del grafo
            }
            
        }
    }
}

