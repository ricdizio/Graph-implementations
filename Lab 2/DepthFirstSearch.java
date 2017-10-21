
//Lab04 DFS
import java.util.*;
public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s
    private List<Vertice> listaDeVertices;


    public DepthFirstSearch(Digrafo G, Vertice v) {
        //this.listaDeVertices = G.vertices();
        this.listaDeVertices = new LinkedList<Vertice>();
        this.listaDeVertices = G.vertices();
        this.marked = new boolean[G.numeroDeVertices()];
        if(this.validateVertex(G,v)){
            this.dfs(G, v);
            this.imprimir(G,3);
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

    public void imprimir(Digrafo G,int x){
        if(x==3){
            for(Vertice i : G.MapaDeVertices.values()){
                if(marked[Integer.parseInt(i.getId())]==true){
                    System.out.print(i.getId()+": ");
                    for(Vertice j : i.predecesores){
                        System.out.print(j.getId()+" ");
                    }
                    System.out.print("\n");
                }
                else{
                    System.out.println(i.getId()+": -1");
                }
            }
        }
        if(x==1){
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
            System.out.print(Integer.parseInt(s.getId()) + " ");
        }
        else if (v.getListaDePredecesores().size() == 0){
            System.out.println("No hay camino del vertice s al vertice v");
        }
        else {
            Vertice ultimo = v.getListaDePredecesores().get(G.numeroDeVertices());
            printPath(G, s, ultimo);
            System.out.print(Integer.parseInt(v.getId()) + " ");
        }
    }
}