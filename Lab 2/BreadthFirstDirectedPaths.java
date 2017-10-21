//Lab04
import java.util.*;
public class BreadthFirstDirectedPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s->v path?
    private String[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    private int[] distTo;      // distTo[v] = length of shortest s->v path
 
    // s es el vertice
    public BreadthFirstDirectedPaths(Digrafo G, Vertice s) {
       
        this.listaDeVertices = new LinkedList<Vertice>();
        this.listaDeVertices = G.vertices();
        this.marked = new boolean[G.numeroDeVertices()];
        this.distTo = new int[G.numeroDeVertices()];
        this.edgeTo = new String[G.numeroDeVertices()];
        for (Vertice v: G.vertices()){
            if (v != s) {
                distTo[Integer.parseInt(v.getId())] = INFINITY;
            }
            else{
                distTo[Integer.parseInt(v.getId())] = 0;
            }
        }
            
        // validate vertex
        //validateVertex(s);
        if (listaDeVertices.contains(s)) {
            bfs(G, s);
        }
        else {
            throw new NoSuchElementException("El vertice con id " +s.getId() + " no se encuentra en el Grafo");
        }
        
    }
    // BFS from single source
    private void bfs(Digrafo G, Vertice s) {
        Queue<Vertice> q = new LinkedList<Vertice>();
        marked[Integer.parseInt(s.getId())] = true;
        distTo[Integer.parseInt(s.getId())] = 0;
        q.enqueue(Integer.parseInt(s.getId()));
        while (!q.isEmpty()) {
            Vertice v = q.dequeue();
     
            for (Vertice w : G.adyacentes(v.getId())) {
                if (listaDeVertices.indexOf(w) == -1) {
                    edgeTo[Integer.parseInt(w.getId())] = edgeTo[Integer.parseInt(w.getId())] +" "+ v.getId();
                    distTo[Integer.parseInt(w.getId())] = distTo[Integer.parseInt(v.getId())] + 1;
                    marked[Integer.parseInt(w.getId())] = true;
                    q.enqueue(w);
                }
            }
        }
    }
}