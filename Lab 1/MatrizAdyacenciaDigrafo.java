public class MatrizAdyacenciaDigrafo {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;
    private int E;
    private int[][] Madj;
    //public int[][] Madj;
    
    /**
     * Initializes an empty edge digraph with <tt>V</tt> vertices and 0 edges.
     * param V the number of vertices
     * @throws java.lang.IllegalArgumentException if <tt>V</tt> < 0
     */
    public MatrizAdyacenciaDigrafo(int V) {
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        this.Madj = new int[V][V];
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }
    // Permite revisar el valor de la posicion de una matriz
    public int valor(int i, int j){
         return Madj[i][j];
    }

    public void agregarArco(int nodo1, int nodo2){
        if (Madj[nodo1][nodo2] == 0){
            Madj[nodo1][nodo2] = 1; 
            this.E = E++;
        } 
    }
    
        
}
