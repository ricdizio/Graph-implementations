/**
 * 
 */

import java.util.*;

public class GrafoNoDirigido implements Grafo
{
    private int numeroDeVertices;
    private int numeroDeLados;
    //private List<Vertice> lista_de_vertices;
    //private List<Arista> lista_de_aristas;
    private Map<String, Arista> MapaDeAristas;
    private Map<String, Vertice> MapaDeVertices;


    public GrafoNoDirigido() {
        numeroDeVertices = 0;
        numeroDeLados = 0;
        MapaDeAristas = New HashMap<String, Arista>();
        MapaDeVertices = New HashMap<String, Vertice>();
        //lista_de_vertices = new LinkedList<Vertice>();
        //lista_de_aristas = new LinkedList<Arista>();
        
    }

    public boolean cargarGrafo(String dirArchivo) {
        // Continuar despues de implementar las funciones del grafo ya que son necesarias para terminar de cargar el grafo

        In in = new In(dirArchivo);
        int cantidad_de_nodos = in.readInt();
        int cantidad_de_aristas = in.readInt();

        for (int i=0;i<cantidad_de_nodos;i++) {
            String id_del_vertice = in.readString();
            double peso_del_vertice = in.readDouble();
            
            agregarVertice(id_del_vertice, peso_del_vertice);
        }

        for (int i=0;i<cantidad_de_aristas;i++) {
            String id_de_arista = in.readString();
            String id_vertice_de_Salida = in.readString();
            String id_vertice_de_Llegada = in.readString();
            double peso_de_arista = in.readDouble();
            
            agregarArista(id_de_arista, id_vertice_de_Salida, id_vertice_de_Llegada, peso_de_arista);

            
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
        
        /* if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id); 
        }  */
        return MapaDeVertices.get(id);  
        
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public boolean estaVertice(String id) {
        
        /*if(MapaDeVertices.get(id)!= null)
        {
            return true; 
        }  
        return false;*/
        //Returns true if this map maps one or more keys to the specified value.
        return MapaDeVertices.containsKey(id);
    }

    public boolean estaLado(String u, String v){        
        //revisar
          // Mas rapida porque aprovecha los ids de los vertices para buscarlos con el HashMap dentro de la lista de vertices y luego en la lista de adyacentes busca el otro id
        // ESTA RELACION DEBERIA SER PARA AMBOS LADOS por ser GND,verificar            
        if (estaVertice(u) == true && estaVertice(v) == true ) {

            Vertice Vertice1 = new Vertice();
            Vertice1 = MapaDeVertices.get(id); 

            Vertice Vertice2 = new Vertice();
            Vertice2 = MapaDeVertices.get(id);

            for(Vertice vertice: Vertice1.getListaDeAdyacencias()){
                if(Vertice1.getId().equals(u)  && vertice.getId().equals(v)){
                    return true;
                }
            
            }
            for(Vertice vertice: Vertice1.getListaDeAdyacencias()){
                if(Vertice2.getId().equals(v)  && vertice.getId().equals(u)){
                    return true;
                }
            
            }
        }

        else{
            return false;
        } 
                
    

        
        // 2da MEJOR MANERA IMPLEMENTADA Si tuviesemos el id del lado fuese la mejor opcion
        /* for (Arista l: MapaDeAristas.values()) {
            if ((l.getEstremo1() == u && l.getExtremo2() == v) || (l.getEstremo1() == v && l.getExtremo2() == u)) {
                return true;
            }
        }
        return false;
        */
        //Arista arista = new Arista(u,v);
        //containsValue()
    }

    public boolean eliminarVertice(String id) {

        return true
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

        /*List<Arista> lista_de_incidentes = new LinkedList();

        for (Arista arista: MapaDeAristas.values()) {
            if (arista.getExtremo1().getId() == id || arista.getExtremo2().getId() == id ) {
                
            }
            
        }*/
        MapaDeVertices.get(id).getListaDeIncidencias();

    }

    public Object clone() {
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Vertice vertice: MapaDeVertices.values()) {
            sb.append("\n");
            sb.append(vertice.getId() + " - " + vertice.getPeso()+ " ADYACENCIAS --------------> ");
            if(vertice.getListaDeAdyacencias().size() >= 1){
                for(Vertice vertice1: vertice.getListaDeAdyacencias()){
                    sb.append(vertice1.getId()+ ", ");
                }
            }
            
            sb.append("\n");
            sb.append( vertice.getId() + "Incidencias --------->");
            
            if(vertice.getListaDeIncidencias().size() >= 1){
                for(Vertice vertice1: vertice.getListaDeIncidencias()){
                    sb.append(vertice1.getId()+ ", ");
                }
            }
        }

        return sb.toString();

    }

    public boolean agregarArista(Arista a) {
        
        int temp = numeroDeLados;

        /*for(Arista arista : MapaDeAristas.values())
        {
            if(arista.getId().equals(a.getId()))
            {
                System.out.println("El arista con el identificador '"
                    +arista.getId()+"' ya se encuentra en el grafo.");
                return false;
            }
        }*/
        if ((MapaDeAristas.containsKey(a.getId()) {
            
            System.out.println("El arista con el identificador '"+arista.getId()+"' ya se encuentra en el grafo.");
            return false;
            
        }

        /*for(Vertice vertice1 : MapaVertices.values()) {
            
            if(vertice1.getId().equals(a.getExtremoInicial().getId())){
                
                vertice1.getListaDeAdyacencias().add(a.getExtremoFinal()); 
                numeroDeLados++;
                lista_de_aristas.add(a);                
            }
        }*/ 
        if ((estaVertice(a.getExtremo1().getId())) && ( estaVertice(a.getExtremo2().getId())) {
            // En GD debe agregar a un vertice en los sucesores y en el otro en los predecesores
            // para este caso agrega en los adyacentes
            obtenerVertice(a.getExtremo1().getId()).getListaDeAdyacencias().add(a.getExtremo2());
            obtenerVertice(a.getExtremo2().getId()).getListaDeAdyacencias().add(a.getExtremo1());
            //agregar incidencias
            obtenerVertice(a.getExtremo1().getId()).getListaDeIncidencias().add(a);
            obtenerVertice(a.getExtremo2().getId()).getListaDeIncidencias().add(a);

            numeroDeLados++;
            MapaDeAristas.put(a.getId(), a);

        }

        if(temp < numeroDeLados) {
            return true;
        }
        return false;
    }

    public boolean agregarArista(String id, double peso, String u, String v) {
        
        Arista arista = new Arista(id,peso,u,v);
        return agregarArista(arista);
    }

    //MODIFICAR
    public boolean eliminarArista(String id) {
        return true
    }

    public Arista obtenerArista(String id) {

         /* for(Arista arista : MapaDeAristas.key())
        {
            if(arista.equals(id);
            {
                System.out.println("La Arista con el identificador '"
                    +arista.getId()+"' ya se encuentra en el grafo.");
                return false;
            }
        }
        */

        return MapaDeAristas.get(id);
    }
}