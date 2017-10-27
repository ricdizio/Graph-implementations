/**
 *lab4
 */

import java.util.*;
import java.io.*;

public class SumaArboles{
  public static void main(String [] args) {
        //Cargamos archivo
        String file = args[0];
        Digrafo g = new Digrafo();
        String line;
        String[] line1;
        String tempLine;
        String words[];
        String tempWords[];
        String linea[];

        String acumulador = "";
        List<Integer> acumulador1 = new ArrayList<Integer>();
        List<String> arregloDeLineas = new ArrayList<String>(); 
        StringBuilder tmp = new StringBuilder();
        int contador = 0;
        int contador1 = 0;
        //Array[int] = ;

        In in = new In(file);
    
        while(in.hasNextLine()){
            line = in.readLine().replaceAll("\\s+","");
            words = line.split("");
            RecursividadGrafoVariasLineas(words,arregloDeLineas);
            acumulador = "";
            // Sacamos el primer entero
            for(int i=0;i<words.length;i++){
                if (words[i].equals("("))
                {
                    break;
                }
                else
                {
                    acumulador = acumulador + words[i];
                }
            }
    }
    
    public List<String> RecursividadGrafoVariasLineas(String[] words, List<String> arregloDeLineas){
        for (int i=0; i < words.length;i++) {
            if (words[i].equals("(")) {
                contador++;
            }
            if (words[i].equals(")")) {
                contador1++;
            }
            if (contador == contador1 && i+1 == words.length) {
                return arregloDeLineas.add(line);
            }
            if (contador != contador1 && i+1 == words.length) {
                    //Implementar llamada recursiva para este caso
                tempLine = in.readLine().replaceAll("\\s+","");
                tempWords = tempLine.split("");
                //Concatena ambos arreglos
                linea = ArrayUtils.addAll(words,tempWords);
                RecursividadGrafoVariasLineas(lineas,arregloDeLineas);

            }
        }
    }

}