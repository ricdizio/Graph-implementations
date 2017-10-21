//Lab04
import java.util.*;
public class BreadthFirstDirectedPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s->v path?
    private String[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    private int[] distTo;      // distTo[v] = length of shortest s->v path
 
    // s es el vertice
    public BreadthFirstDirectedPaths(Digrafo G, Vertice s) {
        this.marked = new boolean[G.numeroDeVertices()];
        this.distTo = new int[G.numeroDeVertices()];
        this.edgeTo = new String[G.numeroDeVertices()];
        int largo = G.numeroDeVertices();
        
        for (int i = 0; i < largo;i++) {
            marked[i] = false;            
        }

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
        if (marked[Integer.parseInt(s.getId())] == true) {
            bfs(G, s);
        }
        else {
            throw new NoSuchElementException("El vertice con id " +s.getId() + " no se encuentra en el Grafo");
        }
        
    }
    // BFS from single source
    private void bfs(Digrafo G, Vertice s) {
        Queue<Integer> q = new LinkedList<Integer>();
        marked[Integer.parseInt(s.getId())] = true;
        distTo[Integer.parseInt(s.getId())] = 0;
        q.enqueue(Integer.parseInt(s.getId()));
        while (!q.isEmpty()) {
            Vertice v = q.dequeue();
     
            for (Vertice w : G.adyacentes(v.getId())) {
                if (marked[Integer.parseInt(s.getId())] == false) {
                    edgeTo[Integer.parseInt(w.getId())] = edgeTo[Integer.parseInt(w.getId())] +" "+ v.getId();
                    distTo[Integer.parseInt(w.getId())] = distTo[Integer.parseInt(v.getId())] + 1;
                    marked[Integer.parseInt(w.getId())] = true;
                    q.enqueue(Integer.parseInt(w.getId()));
                }
            }
        }
    }
}