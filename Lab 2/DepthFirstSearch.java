
//Lab04 DFS
import java.util.*;
public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s
    private List<Vertice> listaDeVertices;
    private Vertice inicial;
    ArrayList<String> nodos = new ArrayList<String>();
    private int seleccion;


    public DepthFirstSearch(Digrafo G, Vertice v,int x, int y) {
        //this.listaDeVertices = G.vertices();
        this.inicial = v;
        this.seleccion = y;
        this.listaDeVertices = new LinkedList<Vertice>();
        this.listaDeVertices = G.vertices();
        this.marked = new boolean[G.numeroDeVertices()];
        if(this.validateVertex(G,v)){
            this.dfs(G, v);
            this.imprimir(G);
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

    public void imprimir(Digrafo G){
        for(Vertice i : G.MapaDeVertices.values())
        {
            if(marked[Integer.parseInt(i.getId())]==true)
            {
                for(Vertice j : i.predecesores)
                {
                    System.out.print(j.getId()+" ");
                }
            }
        }
        System.out.print("\n");
        System.out.print("\n");
        if(this.seleccion == 2){
            for(Vertice i : G.MapaDeVertices.values()){
                if(marked[Integer.parseInt(i.getId())]==true){
                    System.out.print(i.getId()+": ");
                    for(Vertice j : i.predecesores){
                        System.out.print(j.getId());
                        break;
                    }
                    System.out.print("\n");
                }
                else{
                    System.out.println(i.getId()+": -1");
                }
            }
        }
        if(this.seleccion == 0){
            for(Vertice i : G.MapaDeVertices.values()){
                if(marked[Integer.parseInt(i.getId())]==true){
                    System.out.print(i.getId()+": ");
                    for(Vertice j : i.predecesores){
                        System.out.print(j.getId()+" ");
                        break;
                    }
                    System.out.print("\n");
                }
                else{
                    System.out.println(i.getId()+": -1");
                }
            }
        }
        if(this.seleccion == 1){
            for(Vertice i : G.MapaDeVertices.values()){
                if(marked[Integer.parseInt(i.getId())]==true)
                {
                   this.printPath(G,this.inicial,i); 
                }
            }
        }
    }

    private boolean validateVertex(Digrafo G,Vertice v) {
         if (G.estaVertice(v.getId())) {
            return true;
           
        }
        else {
            throw new NoSuchElementException("El vertice con id " +v.getId() + " no se encuentra en el Grafo");
        }
    }

    public void printPath(Digrafo G, Vertice s, Vertice v) {
        if (v == s){
            System.out.print(s + " ");
        }
        else if (v.getListaDePredecesores().size() == 0){
            System.out.println("No hay camino del vertice s al vertice v");
        }
        else {
            printPath(G, s, v.getListaDePredecesores().peekLast().getId());
            System.out.print(v + " ");
        }
    }
}