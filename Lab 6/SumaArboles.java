/**
 *lab4
 */

import java.util.*;
import java.io.*;

public class SumaArboles{
    private List<String> arregloDeLineas;
    //private In in;
    private int cuentaLineas;
    private String words[];
    //private String line;
  
  public void main(String [] args) {
        this.arregloDeLineas = new ArrayList<String>();
        //this.in = new In(file);
        this.cuentaLineas = 1;
        //Cargamos archivo
        String line;
        String file = args[0];
        Digrafo g = new Digrafo();
        //String line;
        String words[];
        String acumulador = "";
        List<Integer> acumulador1 = new ArrayList<Integer>();
        In in = new In(file);
    
        while(in.hasNextLine()){
            line = in.readLine().replaceAll("\\s+","");
            words = line.split("");
            this.MetodoGrafoVariasLineas(words,in, line);
            acumulador = "";
            // Sacamos los enteros de la suma de los caminos
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
    
    public void MetodoGrafoVariasLineas(String[] words, In in, String line){
        int contador = 0;
        int contador1 = 0;
        int count = 0;
        String tempLine;
        String tempWords[];
        String[] linea;
        int cuentaLineas; // cuenta la cantidad de lineas consecutivas de la lectura que pertenecen al mismo grafo

        for (int i=0; i < words.length;i++) {
            if (words[i].equals("(")) {
                contador++;
            }
            if (words[i].equals(")")) {
                contador1++;
            }
            if (contador == contador1 && i+1 == words.length) {
                if (this.cuentaLineas == 1) {
                    this.arregloDeLineas.add(line);
                    //return arregloDeLineas;
                }
                if (this.cuentaLineas > 1) {
                    /// volver un string poner en el add
                    this.arregloDeLineas.add(Arrays.toString(words));
                    //return arregloDeLineas;
                }
            }
            if (contador != contador1 && i+1 == words.length) {
                //Implementar llamada recursiva para este caso
                this.cuentaLineas++;
                tempLine = in.readLine().replaceAll("\\s+","");
                tempWords = tempLine.split("");
                linea = new String[words.length+tempWords.length];
                //Concatena ambos arreglos
                for(int k = 0; k<words.length; k++) { 
                    linea[k] = words[k];
                    count++;
                } 
                for(int j = 0;j<tempWords.length;j++) { 
                    linea[count+1] = tempWords[j];
                    count++;
                } 
                //linea = ArrayUtils.addAll(words,tempWords);
                this.MetodoGrafoVariasLineas(linea,in,line);

            }
        }
    }

}