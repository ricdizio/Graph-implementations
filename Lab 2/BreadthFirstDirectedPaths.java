//Lab04
import java.util.*;
public class BreadthFirstDirectedPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s->v path?
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    private int[] distTo;      // distTo[v] = length of shortest s->v path
    private int seleccion;
    private Vertice inicial;
 
    // s es el vertice
    public BreadthFirstDirectedPaths(Digrafo G, Vertice s,int x, int y) {
        this.marked = new boolean[G.numeroDeVertices()];
        this.distTo = new int[G.numeroDeVertices()];
        this.edgeTo = new int[G.numeroDeVertices()];
        this.seleccion = y;
        this.inicial = s;
        int largo = G.numeroDeVertices();

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
        if (validateVertex(G,s)) {
            bfs(G, s);
        }
        else {
            throw new NoSuchElementException("El vertice con id " +s.getId() + " no se encuentra en el Grafo");
        }
        imprimir(G);
        
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
        //Ordinales
        if(this.seleccion == 1){
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
        //Predecesores
        if(this.seleccion == 2){
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
        if(this.seleccion == 0){
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
            System.out.print(Integer.parseInt(s.getId()) + " ");
        }
        else if (v.getListaDePredecesores().size() == 0){
            System.out.println("No hay camino del vertice s al vertice v");
        }
        else {
            Vertice ultimo = v.getListaDePredecesores().get(0);
            printPath(G, s, ultimo);
            System.out.print(Integer.parseInt(v.getId()) + " ");
        }
    }
}