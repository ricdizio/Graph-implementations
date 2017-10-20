public class BreadthFirstDirectedPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s->v path?
    private String[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    private int[] distTo;      // distTo[v] = length of shortest s->v path

    /**
     * Computes the shortest path from {@code s} and every other vertex in graph {@code G}.
     * @param G the digraph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    // s es el vertice
    public BreadthFirstDirectedPaths(Digrafo G, Vertice s) {
        List<Vertice> listaDeVertices = new LinkedList<Vertice>();
        listaDeVertices = G.vertices();
        marked = new boolean[G.numeroDeVertices()];
        distTo = new int[G.numeroDeVertices()];
        edgeTo = new String[G.numeroDeVertices()];
        for (Vertice v: G.vertices()){
            if (v != s) {
                distTo[listaDeVertices.indexOf(v)] = INFINITY;
            }
            else{
                distTo[listaDeVertices.indexOf(v)] = 0;
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
        Queue<Vertice> q = new Queue<Vertice>();
        marked[listaDeVertices.indexOf(s)] = true;
        distTo[listaDeVertices.indexOf(s)] = 0;
        q.enqueue(listaDeVertices.indexOf(s));
        while (!q.isEmpty()) {
            Vertice v = q.dequeue();
     
            for (Vertice w : G.adyacentes(v.getId())) {
                if (!listaDeVertices.indexOf(w)]) {
                    edgeTo[listaDeVertices.indexOf(w)] = v.getExtremoFinal().getId();
                    distTo[listaDeVertices.indexOf(w)] = distTo[listaDeVertices.indexOf(v)] + 1;
                    marked[listaDeVertices.indexOf(w)] = true;
                    q.enqueue(w);
                }
            }
        }
    }
}