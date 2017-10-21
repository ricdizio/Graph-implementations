//Lab04
import java.util.*;
public class BreadthFirstDirectedPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s->v path?
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    private int[] distTo;      // distTo[v] = length of shortest s->v path
    private int seleccion;
 
    // s es el vertice
    public BreadthFirstDirectedPaths(Digrafo G, Vertice s,int x, int y) {
        this.marked = new boolean[G.numeroDeVertices()];
        this.distTo = new int[G.numeroDeVertices()];
        this.edgeTo = new int[G.numeroDeVertices()];
        this.seleccion = y;
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
        int largo = G.numeroDeVertices();
        Queue<Vertice> q = new LinkedList<Vertice>();
        for (int v = 0; v < largo; v++) {
            distTo[v] = INFINITY;
        }
        marked[Integer.parseInt(s.getId())] = true;
        distTo[Integer.parseInt(s.getId())] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            Vertice v = q.remove();
     
            for (Vertice w : G.adyacentes(v.getId())) {
                if (marked[Integer.parseInt(w.getId())] == false) {
                    edgeTo[Integer.parseInt(w.getId())] = edgeTo[Integer.parseInt(v.getId())];
                    distTo[Integer.parseInt(w.getId())] = distTo[Integer.parseInt(v.getId())] + 1;
                    marked[Integer.parseInt(w.getId())] = true;
                    q.add(w);
                }
            }
        }
    }
}