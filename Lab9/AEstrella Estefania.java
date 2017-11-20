import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AEstrella
{	
	public String ejecucion(Grafo g, Vertice origen, Vertice destino)
	{
		final int vertices = g.vertices().size(); 
        final Set<Vertice> cerrados = new HashSet<Vertice>(); 
        final List<Vertice> abiertos = new ArrayList<Vertice>();     
        
        abiertos.add(origen); 
        
        final Map<Vertice, Vertice> cameFrom = new HashMap<Vertice, Vertice>(vertices);    
        
        origen.setH(calcularHeuristica(origen, destino));

        while (!abiertos.isEmpty())
        {
            final Vertice actual = abiertos.get(0);
            
            if (actual.equals(destino))
                return resultado(reconstruirCamino(cameFrom, destino, g), abiertos.size(), cerrados.size(), vertices, destino);

            abiertos.remove(0);
            cerrados.add(actual);
            
            for (Vertice adyacente : g.adyacentes(actual.getId())) 
            {
                if (cerrados.contains(adyacente))
                    continue; 
                
                Lado lado = g.buscarLado(actual, adyacente);                
                
                final double gAlternativo = actual.getG() + lado.getPeso(); 
                
                if (!abiertos.contains(adyacente))
                    abiertos.add(adyacente); 
                else if (gAlternativo >= adyacente.getG())
                    continue;

                cameFrom.put(adyacente, actual);
                abiertos.get(abiertos.indexOf(adyacente)).setG(gAlternativo);
                g.ordenarGrafo();
            }
        }
        
        return null;
	}
        
    private double calcularHeuristica(Vertice v, Vertice destino) 
    {
    	return Math.sqrt(Math.pow((v.getCoordenadas()[0] - destino.getCoordenadas()[0]), 2) + Math.pow((v.getCoordenadas()[1] - destino.getCoordenadas()[1]), 2));
    }
    
    private List<Lado> reconstruirCamino(Map<Vertice,Vertice> cameFrom, Vertice v, Grafo g)
    {
        final List<Lado> ruta = new ArrayList<Lado>();

        while (v != null) 
        {
            final Vertice previo = v;
            
            v = cameFrom.get(v); //A traves del nodo en cuestion buscamos dentro del Set a su antecesor y lo almacenamos en la misma variable
            
            if (v != null) 
            {
                final Lado lado = g.buscarLado(previo, v);
                ruta.add(lado);
            }
        }
        
        Collections.reverse(ruta);
        
        return ruta;
    }
    
    private String resultado(List<Lado> ruta, int abiertos, int cerrados, int vertices, Vertice destino)
    {
    	StringBuilder s = new StringBuilder();
    	
    	s.append("Para el nodo ").append(destino.getId()).append(":\n");
    	s.append("\tNumero de nodos abiertos: ").append(abiertos).append("\n");
    	s.append("\tNumero de nodos cerrados: ").append(cerrados).append("\n");
    	s.append("\tNumero de nodos no visitados: ").append(vertices - (abiertos + cerrados)).append("\n");
    	s.append("\tRuta Menor Costo: ").append(ruta.toString()).append("\n\n");
    	
    	return s.toString();
    }
}
