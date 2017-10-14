/**
 * 
 */

import java.util.*;

public class GrafoNoDirigido implements Grafo
{
    private int numeroDeVertices;
    private int numeroDeLados;
    private List<Vertice> lista_de_vertices;
    private List<Arista> lista_de_aristas;

    public GrafoNoDirigido() {
        numeroDeVertices = 0;
        numeroDeLados = 0;
        lista_de_vertices = new LinkedList<Vertice>();
        lista_de_aristas = new LinkedList<Arista>();
        
    }

    public boolean cargarGrafo(String dirArchivo) {
        // Continuar despues de implementar las funciones del grafo ya que son necesarias para terminar de cargar el grafo
        //In in = new In(args[0]);
        In in = new In(dirArchivo);
        int cantidad_de_nodos = in.readInt();
        int cantidad_de_aristas = in.readInt();

        for (int i=0;i<cantidad_de_nodos;i++) {
            String id_del_vertice = in.readString();
            double peso_del_vertice = in.readDouble();
            // se proceden a crear y verificar si ya fueron agregados los vertices
        }

        for (int i=0;i<cantidad_de_aristas;i++) {
            String id_de_arista = in.readString();
            String id_vertice_de_Salida = in.readString();
            String id_vertice_de_Llegada = in.readString();
            double peso_del_vertice = in.readDouble();
            // se proceden a crear y verificar si ya fueron agregados las aristas
        }
    }
    
    public int numeroDeVertices() {
        return numeroDeVertices;
    }

    public int numeroDeLados() {
        return numeroDeLados;
    }
   
    public boolean agregarVertice(Vertice v) {
        boolean boolean_agregarVertice;
        boolean_agregarVertice = true;    
        // Si el id del vertice ya se encuentra en la lista devuelve un falso, por lo tanto no procede a agregarlo  
        for (Vertice vertice : lista_de_vertices) {
            if (vertice.getId().equals(v.getId())) {
                StdOut.print(" El id "+ v.getId()+" ya se encuentra agregado");
                boolean_agregarVertice = false;               
            }
        }
        if (boolean_agregarVertice == true) {
            lista_de_vertices.add(v);
            numeroDeVertices++;         
        }

        return boolean_agregarVertice; 
        
    }

    public boolean agregarVertice(String id, double peso) {
        Vertice vertice = new Vertice(id, peso);
        return agregarVertice(vertice);
    }
    
    public Vertice obtenerVertice(String id) throws NoSuchElementException {
        for (Vertice vertice: lista_de_vertices) {
            if(vertice.getId().equals(id)) {
                return vertice;
            }
            
        }
        throw new NoSuchElementException(" El vertice con id "+ id + " no se encuentra en el grafo");
    }

    public boolean estaVertice(String id) {
        boolean estaVertice = false;
        for (Vertice vertice: lista_de_vertices) {
            if (vertice.getId().equals(id)) {
                estaVertice = true;                            
                        }            
        }

        return estaVertice;
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
    }

    public List<Vertice> adyacentes(String id) {
    }
 
    public List<Lado> incidentes(String id) {
    }

    public Object clone() {
    }

    public String toString() {
    }

    public boolean agregarArista(Arista a) {
    }

    public boolean agregarArista(String id, double peso, String u, String v) {
    }

    public boolean eliminarArista(String id) {
    }

    public Arista obtenerArista(String id) {
    }
}