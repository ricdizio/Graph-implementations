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
    private Map<String, Vertice> MapaDeAristas = New HashMap<String, Arista>();
    private Map<String, Vertice> MapaDeVertices = New HashMap<String, Vertice>();

    public GrafoNoDirigido() {
        numeroDeVertices = 0;
        numeroDeLados = 0;
        lista_de_vertices = new LinkedList<Vertice>();
        lista_de_aristas = new LinkedList<Arista>();
        
    }

    public boolean cargarGrafo(String dirArchivo) {
        // Continuar despues de implementar las funciones del grafo ya que son necesarias para terminar de cargar el grafo
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
        // Si el id del vertice ya se encuentra en la lista devuelve un falso, por lo tanto no procede a agregarlo  
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

    public boolean agregarVertice(String id, double peso) {
        boolean booleano;
        Vertice v = new Vertice(id,peso);
        booleano = agregarVertice(v);
        
        return booleano;
    }
    
    public Vertice obtenerVertice(String id) throws NoSuchElementException {
        
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id); 
        }    
        
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public boolean estaVertice(String id) {
        
        if(MapaDeVertices.get(id)!= null)
        {
            return true; 
        }  
        return false;
    }

    public boolean estaLado(String u, String v){        
        //revisar
        /* 
            for(Vertice v: MapaDeVertices){
                for(Vertice ver: v.get(id).getListaDeAdyacencias()){
                    if(vertice1.getId().equals(u)  && vertice2.getId().equals(v)){
                    return true;
                    }
                }    
            }

        */

        for (Arista l: MapaDeAristas.values()) {
            if ((l.getEstremo1() == u && l.getExtremo2() == v) || (l.getEstremo1() == v && l.getExtremo2() == u)) {
                return true;
            }
        }
        return false;
    }

    public boolean eliminarVertice(String id) {
    }

    public List<Vertice> vertices() {
        List<Vertices> return_list_vertices = new LinkedList<Vertice>;

        for (Vertice v : MapaDeVertices.values()) {
            return_list_vertices.add(v);
        }

        return return_list_vertices;
    }

    public List<Lado> lados() {
        List<Lados> return_list_lados = new LinkedList<Lados>;
        for (Arista l : MapaDeAristas.values()) {
            return_list_lados.add(l);
        }

        return return_list_lados;
    }

    public int grado(String id) {

        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeAdyacencias().size(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public List<Vertice> adyacentes(String id) {
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeAdyacencias(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }
 
    public List<Lado> incidentes(String id) {
    }

    public Object clone() {
    }

    public String toString() {
    }

    public boolean agregarArista(Arista a) {
        int temp = numeroDeLados;
        for(Arco arco : MapaDeAristas.values())
        {
            if(arco.getId().equals(a.getId()))
            {
                System.out.println("El arco con el identificador '"
                    +arco.getId()+"' ya se encuentra en el grafo.");
                return false;
            }
        }
        // Revisaaaar
        for(Vertice vertice1 : MapaVertices.values())
        {
            if(vertice1.getId().equals(a.getExtremoInicial().getId())){
                vertice1.getListaDeAdyacencias().add(a.getExtremoFinal()); 
                numeroDeLados++;
                lista_de_arcos.add(a);                
            }
        }

        if(temp < numeroDeLados)
        {
            return true;
        }
        return false;
    }

    public boolean agregarArista(String id, double peso, String u, String v) {
    }

    public boolean eliminarArista(String id) {
    }

    public Arista obtenerArista(String id) {
    }
}