
//Lab04
import java.util.*;
public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s
    private List<Vertice> listaDeVertices;
    ArrayList<String> nodos = new ArrayList<String>();


    /**
     * Computes the vertices in graph {@code G} that are
     * connected to the source vertex {@code s}.
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */

    public DepthFirstSearch(Digrafo G, Vertice v) {
        //this.listaDeVertices = G.vertices();
        this.marked = new boolean[G.numeroDeVertices()];
        if(this.validateVertex(G,v)){
            this.dfs(G, v);
            this.imprimir(G,3);
        }
     }

    // depth first search from v
    //G.adj(v) son los adyacentes de v
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

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */

    public void marked(Digrafo G, Vertice v) {

        if (validateVertex(G,v) == true) {
            this.marked[this.listaDeVertices.indexOf(v)] = true;
        }
    }

    /**
     * Returns the number of vertices connected to the source vertex {@code s}.
     * @return the number of vertices connected to the source vertex {@code s}
     */
    public int count() {
        return this.count;
    }

    public void imprimir(Digrafo G,int x){
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
        if(x==3){
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
}