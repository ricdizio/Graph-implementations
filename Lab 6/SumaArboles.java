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
                //System.out.println("Esta entrando2");
            }
            if (words[i].equals("(")) {
                //System.out.println("Esta entrando");
                builder.append(words[i]);
                contador++;
            }
            if (words[i].equals(")")) {
                //System.out.println("Esta entrando1");
                contador1++;
            }
            if (contador == contador1) {
                //System.out.println(builder.toString());
                arregloDeLineas.add(builder.toString());
                contador = 0;
                contador1 = 0;
                //StringBuilder builder = new StringBuilder();
                builder.setLength(0);
            }            
        }

        //for (int i=0;i<arregloDeLineas.size();i++) {
        //    System.out.println(arregloDeLineas.get(i));
            
        //}
        //System.out.println(linee);
        for (int i=0;i<arregloDeLineas.size();i++) {
            System.out.println(arregloDeLineas.get(i));
            
        }
    }
}

