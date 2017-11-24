// Lab09
// Ricardo Di Zio 11-11274
// Fabio Suarez   12-10578

import java.util.*;
public class ordenTopologico {
    
    public ArrayList<Vertice> ordenTopologico(Digrafo G) {
        ArrayList<Vertice> topologico = new ArrayList<Vertice>();
        topologico = new ArrayList<Vertice>();
        for( Vertice v: G.vertices() ) {
            if( !( v.getVisitado() ) )
            {
                dfsTopologico(topologico, v);
            }
        }
        return topologico;
    }

    private void dfsTopologico(ArrayList<Vertice> topologico, Vertice v) {
        v.setVisitado(true);
        for( Vertice ver: v.getListaDePredecesores() )
        {
            if( !( ver.getVisitado() ) )
            {
                dfsTopologico(topologico, ver);
            }
        }
        topologico.add(v);
    }
        
}