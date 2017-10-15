/**
 * 
 */

import java.util.*;

public class Digrafo implements Grafo
{
    private int numeroDeVertices;
    private int numeroDeLados;
    private List<Vertice> lista_de_vertices;
    private List<Arco> lista_de_arcos;
    Map<String, Vertice> MapaDeVertices = New HashMap<String, Vertice>();

    public Digrafo() {
        numeroDeVertices = 0;
        numeroDeLados = 0;
        lista_de_arcos = new LinkedList<Arco>();
        
    }

    public boolean cargarGrafo(String dirArchivo) {
        // Continuar despues de implementar las funciones del grafo ya que son necesarias para terminar de cargar el grafo
        //In in = new In(args[0]);
        In in = new In(dirArchivo);
        int cantidad_de_nodos = in.readInt();
        int cantidad_de_arcos = in.readInt();

        for (int i=0;i<cantidad_de_nodos;i++) {
            String id_del_vertice = in.readString();
            double peso_del_vertice = in.readDouble();
            // se proceden a crear y verificar si ya fueron agregados los vertices
        }

        for (int i=0;i<cantidad_de_arcos;i++) {
            String id_de_arco = in.readString();
            String id_vertice_de_Salida = in.readString();
            String id_vertice_de_Llegada = in.readString();
            double peso_del_vertice = in.readDouble();
            // se proceden a crear y verificar si ya fueron agregados los acos
        }
    }
    
    public int numeroDeVertices() {
    	return numeroDeVertices;
    }

    public int numeroDeLados() {
    	return numeroDeLados;
    }
   
    public boolean agregarVertice(Vertice v) 
	{ 
        if(MapaVertices.get(v.getId()) != null)
        {
        	System.out.println("El vertice con identificador "+v.getId()+
                    " ya se encuentra en el grafo.");
        	return false;
        }

        MapaVertices.put(v.getId,v);
        numeroDeVertices++;
        return true;
    }

    public boolean agregarVertice(String id, double peso) 
	{ 
		Vertice v = new Vertice(id,peso);
        if(MapaVertices.get(v.getId()) != null)
        {
        	System.out.println("El vertice con identificador "+v.getId()+
                    " ya se encuentra en el grafo.");
        	return false;
        }

        MapaVertices.put(v.getId,v);
        numeroDeVertices++;
        return true;
    }
    
    public Vertice obtenerVertice(String id) 
    {
    	if(MapaDeVertices.get(id)!= null)
    	{
            return MapaDeVertices.get(id); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public boolean estaVertice(String id) 
    {
    	if(MapaDeVertices.get(id)!= null)
    	{
            return true; 
        }  
        return false;
    }

    public boolean estaLado(String u, String v){
    }

    public boolean eliminarVertice(String id) {
    }

    public List<Vertice> vertices() {
    }

    public List<Lado> lados() {
    }

    public int grado(String id) {
    	if(MapaDeVertices.get(id)!= null)
    	{
            return MapaDeVertices.get(id).getListaDeAdyacencias().size(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public List<Vertice> adyacentes(String id) 
    {
    	if(MapaDeVertices.get(id)!= null)
    	{
            return MapaDeVertices.get(id).getListaDeAdyacencias(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }
 
    public List<Lado> incidentes(String id) {
    {
    	if(MapaDeVertices.get(id)!= null)
    	{
            return MapaDeVertices.get(id).getListaDeIncidencias(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }
    }

    public Object clone() {
    }

    public String toString() {
    }

    public boolean agregarArco(Arco a) {
    } 

    public boolean agregarArco(String id, double peso, 
    }

    public int gradoInterior(String id) {
    }

    public int gradoExterior(String id) {
    }

    public List<Vertice> sucesores(String id) {
    }

    public List<Vertice> predecesores(String id) {
    }

    public boolean eliminarArco(String id) {
    }

    public Arco obtenerArco(String id) {
    }	
}