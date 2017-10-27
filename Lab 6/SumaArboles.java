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
        String words[];
        
        String acumulador = "";
        List<Integer> acumulador1 = new ArrayList<Integer>();
        List<String> arregloDeLineas = new ArrayList<String>(); 
        StringBuilder tmp = new StringBuilder();
        int cuentaLineas = 1;
        
        //Array[int] = ;

        In in = new In(file);
    
        while(in.hasNextLine()){
            line = in.readLine().replaceAll("\\s+","");
            words = line.split("");
            MetodoGrafoVariasLineas(words,arregloDeLineas,in, line, cuentaLineas);
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
    }
    
    public List<String> MetodoGrafoVariasLineas(String[] words, List<String> arregloDeLineas, In in, String line){
        int contador = 0;
        int contador1 = 0;
        int count = 0;
        String tempLine;
        String tempWords[];
        String linea[];
        int cuentaLineas; // cuenta la cantidad de lineas consecutivas de la lectura que pertenecen al mismo grafo

        for (int i=0; i < words.length;i++) {
            if (words[i].equals("(")) {
                contador++;
            }
            if (words[i].equals(")")) {
                contador1++;
            }
            if (contador == contador1 && i+1 == words.length) {
                if (cuentaLineas == 1) {
                    arregloDeLineas.add(line);
                    return arregloDeLineas;
                }
                if (cuentaLineas > 1) {
                    /// volver un string poner en el add
                    arregloDeLineas.add(line);
                    return arregloDeLineas;
                }
            }
            if (contador != contador1 && i+1 == words.length) {
                //Implementar llamada recursiva para este caso
                cuentaLineas++;
                tempLine = in.readLine().replaceAll("\\s+","");
                tempWords = tempLine.split("");
                //Concatena ambos arreglos
                for(int k = 0; k<words.length; k++) { 
                    linea[k] = words[k];
                    count++;
                } 
                for(int j = 0;j<tempWords.length;j++) { 
                    linea[count++] = tempWords[j];
                } 
                //linea = ArrayUtils.addAll(words,tempWords);
                MetodoGrafoVariasLineas(linea,arregloDeLineas,in,line,cuentaLineas);

            }
        }
    }

}