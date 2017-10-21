
import java.util.*;

public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s
    private List<Vertice> listaDeVertices;

    /**
     * Computes the vertices in graph {@code G} that are
     * connected to the source vertex {@code s}.
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DepthFirstSearch(Digrafo G, Vertice s) {
        List<Vertice> listaDeVertices = new LinkedList<Vertice>();
        marked = new boolean[G.numeroDeVertices()];
        validateVertex(G,s);
        dfs(G, s);
     }

    // depth first search from v
    //G.adj(v) son los adyacentes de v
    private void dfs(Digrafo G, Vertice v) {
        count++;
        marked[listaDeVertices.indexOf(v)] = true;
        for (Vertice w : G.adyacentes(v.getId())) {
            if (!marked[listaDeVertices.indexOf(w)]) {
                dfs(G, w);
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
        if (validateVertex(G,v) = true) {
            marked[listaDeVertices.indexOf(v)] = true;
        }
    }

    /**
     * Returns the number of vertices connected to the source vertex {@code s}.
     * @return the number of vertices connected to the source vertex {@code s}
     */
    public int count() {
        return count;
    }

    private boolean validateVertex(Digrafo G,Vertice v) {
         if (G.estaVertice(s.getId())) {
            return true;
           
        }
        else {
            throw new NoSuchElementException("El vertice con id " +s.getId() + " no se encuentra en el Grafo");
            return false;
        }
    }
}

   