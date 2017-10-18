/**
 * 
 */

import java.util.*;
import java.io.*;

public class GrafoNoDirigido implements Grafo
{
    private int numeroDeVertices;
    private int numeroDeLados;
    private HashMap<String, Arista> MapaDeAristas;
    private HashMap<String, Vertice> MapaDeVertices;


    public GrafoNoDirigido(){
        numeroDeVertices = 0;
        numeroDeLados = 0;
        MapaDeAristas = new HashMap <String,Arista>();
        MapaDeVertices = new HashMap <String, Vertice>();
    }

    public boolean cargarGrafo(String dirArchivo) {
        // Continuar despues de implementar las funciones del grafo ya que son necesarias para terminar de cargar el grafo
        try{
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
                
                agregarArista(id_de_arista, peso_de_arista,id_vertice_de_Salida, id_vertice_de_Llegada);
                
            }
        }
        catch(Exception e){
            System.out.println("No se pudo cargar el archivo");
            return false;
        }
        return true;
    }
    
    public int numeroDeVertices() {
        //Verificar si mantienen numero de vertices la misma cantidad de elementos que size 
        return numeroDeVertices;
    }

    public int numeroDeLados() {
        return numeroDeLados;
    }
   
    public boolean agregarVertice(Vertice v) {  
        // Si el id del vertice ya se encuentra en la lista devuelve un falso, por lo tanto no procede a agregarlo  
        if(MapaDeVertices.get(v.getId()) != null)
        {
            System.out.println("El vertice con identificador "+v.getId()+
                    " ya se encuentra en el grafo.");
            return false;
        }

        MapaDeVertices.put(v.getId(),v);
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
        
        throw new NoSuchElementException("El vertice con el idenficador: " +id+ " no se encuentra en el Grafo");
    }

    public boolean estaVertice(String id) {
        
        //Returns true if this map maps one or more keys to the specified value.
        return MapaDeVertices.containsKey(id);
    }

    public boolean estaLado(String u, String v){        

        if (estaVertice(u) == true && estaVertice(v) == true ) {

            Vertice v1 = MapaDeVertices.get(u);

            Vertice v2 = MapaDeVertices.get(v);

            for(Vertice x : v1.getListaDeAdyacencias()){
                if(v1.getId().equals(u) && x.getId().equals(v)){
                    return true;
                }
            
            }
            for(Vertice x : v2.getListaDeAdyacencias()){
                if(v2.getId().equals(v)  && x.getId().equals(u)){
                    return true;
                }
            
            }
        }

        return false;
    }

    public boolean eliminarVertice(String id) {

        List<Vertice> temp_lista_adyacencia = new LinkedList<Vertice>();
        List<Arista> temp_lista_incidencia = new LinkedList<Arista>();

        if (estaVertice(id)) {

            Vertice verticeTemp = MapaDeVertices.get(id);

            for(Lado l : verticeTemp.getListaDeIncidencias()){
                    Arista arista = (Arista)l;
                    temp_lista_incidencia.add(arista);
            }

            // Borrando Incidencias
            for (Lado arista: temp_lista_incidencia) {

                int posicion = verticeTemp.getListaDeIncidencias().indexOf(arista);
                //eliminarArista(arista.getId());
                if (posicion != -1) {
                    eliminarArista(verticeTemp.getListaDeIncidencias().get(posicion).getId());                     
                }
                else{
                    continue;
                }
                             
                
            }
            //temporal de vertices lista de adyacencia
            for(Vertice vertice : verticeTemp.getListaDeAdyacencias()){
                    temp_lista_adyacencia.add(vertice);
            }

            //Borrando Adyacencias
            for (Vertice v: temp_lista_adyacencia) {

                int pos = verticeTemp.getListaDeAdyacencias().indexOf(v);
                
                if (pos != -1) {
                   
                    MapaDeVertices.get(verticeTemp.getListaDeAdyacencias().get(pos).getId()).getListaDeAdyacencias().remove(verticeTemp);

                }
                else{
                    continue;
                }
            }
            MapaDeVertices.remove(id);
            numeroDeVertices--;

            return true;
        }

        else {

            return false;
        }

    }

    public List<Vertice> vertices() {

        List<Vertice> return_list_vertices = new LinkedList<Vertice>();

        for (Vertice v : MapaDeVertices.values()) {
            return_list_vertices.add(v);
        }

        return return_list_vertices;
    }

    public List<Lado> lados() {

        List<Lado> return_list_lados = new LinkedList<Lado>();
        for (Arista l : MapaDeAristas.values()) {
            return_list_lados.add(l);
        }

        return return_list_lados;
    }

    public int grado(String id) {

        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeIncidencias().size(); 
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
        return MapaDeVertices.get(id).getListaDeIncidencias();

    }
    
    public Object clone() {
        GrafoNoDirigido cloneGND = new GrafoNoDirigido();
        HashMap<String, Vertice> hashMap_vertices_clone = new HashMap<String, Vertice>();
        HashMap<String, Arista> hashMap_aristas_clone = new HashMap<String, Arista>();

        for(Vertice v : MapaDeVertices.values()){
            hashMap_vertices_clone.put(v.getId(),v);
        }
        for(Arista a : MapaDeAristas.values()){
            hashMap_aristas_clone.put(a.getId(), a);
        }
        for(Vertice v : hashMap_vertices_clone.values()){
            //cloneGND.agregarVertice(v.getId(),v.getPeso());
            cloneGND.agregarVertice(v);
        }
        for(Arista a : hashMap_aristas_clone.values()){
            cloneGND.agregarArista(a);
        }
        return cloneGND;
    }
    
    public String toString() {

        StringBuilder sb = new StringBuilder();
        HashSet<String> setVertice = new HashSet<String>();
        HashSet<String> setArista = new HashSet<String>();

        for (Vertice vertice: MapaDeVertices.values()) {
            sb.append("\n");
            sb.append("Vertice id ");
            sb.append(vertice.getId() + " - " + vertice.getPeso()+ " ADYACENCIAS --------------> ");
            sb.append(" [ ");
            if(vertice.getListaDeAdyacencias().size() >= 1){

                for (Vertice v: vertice.getListaDeAdyacencias()) {

                    setVertice.add(v.getId());                  
                }

                Iterator<String> iterator = setVertice.iterator();
                while (iterator.hasNext()) {
                    sb.append(iterator.next() + ", ");
                }

                sb.append(" ] ");
            }

            else if (vertice.getListaDeAdyacencias().size() == 0) {
                sb.append(" No hay elementos adyacentes al vertice ]");    
            }
                       
            sb.append("\n");
            sb.append("\n");
            sb.append("\n");
            sb.append("Vertice id ");
            sb.append( vertice.getId() + "       INCIDENCIAS -------------->");
            sb.append("  [ ");
            
            if(vertice.getListaDeIncidencias().size() >= 1){

                for(Lado l: vertice.getListaDeIncidencias()){
                    
                    setArista.add(l.getId());
                }

                Iterator<String> iterator = setArista.iterator();
                while (iterator.hasNext()) {
                    sb.append(iterator.next() + ", ");
                }

                sb.append("  ] ");
            }

            else if (vertice.getListaDeIncidencias().size() == 0) {
                sb.append(" No hay elementos incidentes al vertice ");    
            }

            sb.append("\n");
            sb.append("\n");
            sb.append("\n");
            
            // Limpiamos las listas para que no nos afecte en la impresion de las variables temporales
            setVertice.clear();
            setArista.clear();

        }

        return sb.toString();

    }

    public boolean agregarArista(Arista a) {
        
        int temp = numeroDeLados;
        if ((MapaDeAristas.containsKey(a.getId()))) {
            
            System.out.println("El arista con el identificador '"+a.getId()+"' ya se encuentra en el grafo.");
            return false;
            
        }

        if ((estaVertice(a.getExtremo1().getId())) && ( estaVertice(a.getExtremo2().getId()))) {
            // En GD debe agregar a un vertice en los sucesores y en el otro en los predecesores
            // para este caso agrega en los adyacentes
            obtenerVertice(a.getExtremo1().getId()).adyacencias.add(a.getExtremo2());
            obtenerVertice(a.getExtremo2().getId()).adyacencias.add(a.getExtremo1());
            //agregar incidencias
            obtenerVertice(a.getExtremo1().getId()).incidencias.add(a);
            obtenerVertice(a.getExtremo2().getId()).incidencias.add(a);

            numeroDeLados++;
            MapaDeAristas.put(a.getId(), a);

        }

        if(temp < numeroDeLados) {
            return true;
        }
        return false;
    }

    public boolean agregarArista(String id, double peso, String u, String v) {

        if(estaVertice(u) && estaVertice(v))
        {
            Vertice v1 = MapaDeVertices.get(u);
            Vertice v2 = MapaDeVertices.get(v);
            Arista arista = new Arista(id,peso,v1,v2);
            return agregarArista(arista);
        }
        return false;
    }

    public boolean eliminarArista(String id) {
        // Capaz tambien hay que verificar si estan ambo nodos de la arista dentro del grafo
        if (MapaDeAristas.containsKey(id)) {
            
            Arista aristaTemp = MapaDeAristas.get(id);
            // Y distintos de null?

            if (MapaDeVertices.containsKey(aristaTemp.getExtremo1().getId()) && MapaDeVertices.containsKey(aristaTemp.getExtremo2().getId())) {

                // Procedemos a borrar los nodos en la lista de adyacencias de cada nodo , devolver excepcion
                MapaDeVertices.get(aristaTemp.getExtremo1().getId()).getListaDeAdyacencias().remove(aristaTemp.getExtremo2());
                MapaDeVertices.get(aristaTemp.getExtremo2().getId()).getListaDeAdyacencias().remove(aristaTemp.getExtremo1());

                // Procedemos a borrar el lado de la lista de incidencia de ambos nodos
                aristaTemp.getExtremo1().getListaDeIncidencias().remove(aristaTemp);
                aristaTemp.getExtremo2().getListaDeIncidencias().remove(aristaTemp);
            
                //Borramos del HashMap de aristas

                MapaDeAristas.remove(aristaTemp);
                numeroDeLados--;

                return true;
            }

            return true;
        }

        else{

            return false;
        }
    }

    public Arista obtenerArista(String id) throws NoSuchElementException { 
        if (MapaDeAristas.containsKey(id)) {
            return MapaDeAristas.get(id);
        }
        throw new NoSuchElementException("La arista no se puede obtener debido a que no se encuentra en la lista");
        
    }
    public void escribirArchivo(){
        Out escritura = new Out("GNDout.txt");
        escritura.println(numeroDeVertices);
        escritura.println(numeroDeLados);
        for(Vertice i : MapaDeVertices.values())
        {
            String a = i.getId();
            String p = String.valueOf(i.getPeso());
            escritura.print(a + p);
            escritura.print("\n");
        }
    }
}

    
        
        