/**********************************************************************************************************
 *  Compilacion:  javac Grafo.java
 *  Ejecucion:    java Grafo
 *  Dependencias: Vertice.java, Lado.java, Arista.java, Arco.java
 *   
 *  Clase interface que sirve como esqueleto para las clases GrafoNoDirigido y Digrafo
 *
 *    @author  Ricardo Di Zio 11-11274
 *    @author  Fabio Suarez   12-10578
 *    @version 1.0
 *    @since   2017-10-19
 *
 * 
 *************************************************************************************************************/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface Grafo
{
    public boolean cargarGrafo(String dirArchivo);
    
    public int numeroDeVertices();

    public int numeroDeLados();
    
    public boolean agregarVertice(Vertice v);

    public boolean agregarVertice(String id, double peso);
    
    public Vertice obtenerVertice(String id);

    public boolean estaVertice(String id);

    public boolean estaLado(String u, String v);

    public boolean eliminarVertice(String id);

    public List<Vertice> vertices();

    public List<Lado> lados();

    public int grado(String id);

    public List<Vertice> adyacentes(String id);
 
    public List<Lado> incidentes(String id);

    public Object clone();

    public String toString();
}