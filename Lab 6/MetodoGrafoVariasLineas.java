public class MetodoGrafoVariasLineas{
    public MetodoGrafoVariasLineas(String args[]){
        int contador = 0;
        int contador1 = 0;
        int count = 0;
        String tempLine;
        String tempWords[];
        String[] linea;
        int cuentaLineas; // cuenta la cantidad de lineas consecutivas de la lectura que pertenecen al mismo grafo

    }

    public void MetodoGrafoVariasLineas(String[] words, In in, String line){
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
}