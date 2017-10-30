
//Lab04 DFSSS
import java.util.*;
public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s
    private List<Vertice> listaDeVertices;
    private Vertice inicial;
    ArrayList<String> nodos = new ArrayList<String>();
    private int seleccion;
    private List<Double> caminos = new ArrayList<Double>(); 



    public DepthFirstSearch(Digrafo G, Vertice v) {
        //this.listaDeVertices = G.vertices();
        this.inicial = v;
        //this.seleccion = y;
        this.listaDeVertices = new LinkedList<Vertice>();
        this.listaDeVertices = G.vertices();
        this.marked = new boolean[G.numeroDeVertices()];
        if(this.validateVertex(G,v)){
            this.dfs(G, v);
            //this.imprimir(G);
        }
     }

    private void dfs(Digrafo G, Vertice v) {
        this.count++;
        this.marked[Integer.parseInt(v.getId())] = true;
        for (Vertice w : G.adyacentes(v.getId())) {
            if (!this.marked[Integer.parseInt(w.getId())]) {
                //System.out.println(w.getId());
                this.dfs(G, w);
            }
        }
    }
    public void marked(Digrafo G, Vertice v) {

        if (validateVertex(G,v) == true) {
            this.marked[this.listaDeVertices.indexOf(v)] = true;
        }
    }

    public int count() {
        return this.count;
    }

    private boolean validateVertex(Digrafo G,Vertice v) {
         if (G.estaVertice(v.getId())) {
            return true;
           
        }
        else {
            throw new NoSuchElementException("El vertice con id " +v.getId() + " no se encuentra en el Grafo");
        }
    } 
    public List<Double> printPath(Vertice s, Vertice v) {
        if (v == s){
            caminos.add(v.getPeso());
            //System.out.print(s.getPeso() + "\n ");
        }
        else if (v.getListaDePredecesores().size() == 0){
            //System.out.println("No hay camino del vertice s al vertice v");
            //System.out.println(" \n");
        }
        else {
            if(!v.getListaDePredecesores().isEmpty())
            {
                Vertice ultimo = v.getListaDePredecesores().get(0);
                caminos.add(v.getPeso());
                //System.out.print(v.getPeso() + " \n");
                printPath(s, ultimo);
                
            }
        }
        return caminos;
    }
    public void dfsPath(Vertice inicial){
        Vertice nodoActual;
        Stack<Vertice> pila = new Stack<Vertice>();
        pila.push(inicial);
        HashSet<Vertice> visitados = new HashSet<Vertice>();
        while (!pila.empty()){
            nodoActual = pila.pop();
            if (!visitados.contains(nodoActual)) {
                visitados.add(nodoActual);
                for (Vertice ver:nodoActual.getListaDeSucesores()) {
                    System.out.println(ver.getPeso());
                    pila.push(ver);                    
                }
                
            }
            
        }
    }
}