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

    public Digrafo() {
        numeroDeVertices = 0;
        numeroDeLados = 0;
        lista_de_vertices = new LinkedList<Vertice>();
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
    }

    public int numeroDeLados() {
    }
   
    public boolean agregarVertice(Vertice v) {
    }

    public boolean agregarVertice(String id, double peso) {
    }
    
    public Vertice obtenerVertice(String id) {
    }

    public boolean estaVertice(String id) {
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