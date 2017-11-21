/**********************************************************************************************************
 *    Compilacion:  javac GrafoNoDirigido.java
 *    Ejecucion:    java GrafoNoDirigido
 *    Dependencias In.java,StdOut.java, Lado.java, Arista.java, Grafo.java
 *    
 *    Clase Grafo No Dirigido que se utiliza en ClienteGrafo.java 
 *    
 *    En este archivo se implementa la estructura de datos grafo no dirigido 
 *    con el uso de otras estructuras de datos como HashMap y listas enlazadas
 *
 *
 *     Notacion para el tiempo de ejecucion: 
 *                                           V : Cardinalidad de vertices en el grafo no dirigido
 *                                           E : Cardinalidad de aristas en el grafo no dirigido
 *
 *    @author  Ricardo Di Zio 11-11274
 *    @author  Fabio Suarez   12-10578
 *    @version 1.0
 *    @since   2017-19-10
 *
 * 
 *************************************************************************************************************/


import java.util.*;
import java.io.*;

public class GrafoNoDirigido implements Grafo
{
    private int numeroDeVertices;
    private int numeroDeLados;
    private HashMap<String, Arista> MapaDeAristas;
    public HashMap<String, Vertice> MapaDeVertices;

    /**  
     * @param No posee parametro de entrada
     * @return Crea un contador de tipo entero de Vertices que hay en el grafo no dirigido
     * @return Crea un contador de tipo entero de Aristas que hay en el grafo no dirigido
     * @return Inicializa MapaDeVertices un HashMap de objetos de tipo vertice 
     * @return Inicializa MapaDeAristas  un HashMap de objetos de tipo arista 
     */


    public GrafoNoDirigido()
    {
        numeroDeVertices = 0;
        numeroDeLados = 0;
        MapaDeAristas = new HashMap <String,Arista>();
        MapaDeVertices = new HashMap <String, Vertice>();
    }

    /**  
     * @param Entra un string el cual es el parametro para construir un objeto de tipo In
     * @return true si se cargo perfectamente el Archivo
     * 
     * Tiempo: O(V+E)
     */

    public boolean cargarGrafo(String dirArchivo) {
        try{

            In in = new In(dirArchivo);
            double nodoInicial;
            double nodoFinal;
            double peso_nodo = 0.0;
            boolean agregar = true;

            int nodos = in.readInt();
            for(int i = 0; i < nodos; i++) 
            {
                nodoInicial = in.readDouble();
                nodoFinal = in.readDouble();
                Vertice  vertice = new Vertice(String.valueOf(i), peso_nodo);
                
                vertice.ejeX = nodoInicial;
                vertice.ejeY = nodoFinal;
                agregar = this.agregarVertice(vertice);
                if(agregar)
                {
                    peso_nodo = peso_nodo + 1.0;
                }
            }

            int lados = in.readInt();          
       
            String nodo1;
            String nodo2;

            for(int i = 0; i < lados;i++ )
            {
                nodo1 = in.readString();
                nodo2 = in.readString();
                this.agregarArista(String.valueOf(i),0.0,nodo1,nodo2);
            }
        }
        catch(Exception e)
        {
            System.out.println("No se pudo cargar el archivo");
            return false;
        }
        return true;
    }

    /**  
     * @param no recibe parametro de entrada
     * @return un contador de tipo entero el cual representa el numero de vertices 
     * que hay en el grafo no dirigido
     * 
     * Tiempo: O(1)
     */
    
    public int numeroDeVertices() {
        return numeroDeVertices;
    }

    /**  
     * @param no posee 
     * @return un contador de tipo entero el cual representa el numero de aristas 
     * que hay en el grafo no dirigido
     * 
     * Tiempo: O(1)
     */

    public int numeroDeLados() {
        return numeroDeLados;
    }
    
    /**  
     * @param recibe un objeto de tipo vertice
     * @return un booleano el cual representa si se pudo agregar el vertice al grafo no dirigido 
     * de manera satisfactoria o no
     *
     * 
     * Tiempo: O(1)
     */

    public boolean agregarVertice(Vertice v) {   
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

    /**  
     * @param recibe un string el cual representa el id del vertice que se desea agregar
     * @param recibe un double el cual representa el peso del vertice que se desea agregar
     * @return un booleano el cual representa si se pudo agregar el vertice al grafo no dirigido 
     * de manera satisfactoria o no
     *
     * 
     * Tiempo: O(1)
     */

    public boolean agregarVertice(String id, double peso) {
        boolean booleano;
        Vertice v = new Vertice(id,peso);
        booleano = agregarVertice(v);
        
        return booleano;
    }

    /**  
     * @param recibe un string el cual representa el id del vertice que se desea obtener
     * @return vertice en el caso de que se encuentre en el grafo no dirigido 
     * @return un mensaje avisando que el vertice no se encuentra en el grafos
     *
     * 
     * Tiempo: O(1)
     */
    
    public Vertice obtenerVertice(String id) throws NoSuchElementException {
        
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id); 
        }  
        
        throw new NoSuchElementException("El vertice con el idenficador: " +id+ " no se encuentra en el Grafo");
    }

    /**
     * Busca en el HashMap de vertices el id de un vertice y verifica 
     * si se encuentran en el grafo no dirigido   
     * @param Entra un String que representa el identificador del vertice que se desea verificar
     * si se encuentra en el grafo no dirigido
     * @return un booleano true en caso de que el vertice se encuentre en el grafo no dirigido  
     *  y false en caso contrario
     * 
     * Tiempo: O(1)
     */

    public boolean estaVertice(String id) {
        
        //Returns true if this map maps one or more keys to the specified value.
        return MapaDeVertices.containsKey(id);
    }

    /**  
     * Busca en el HashMap de vertices el id de ambos vertices y verifica 
     * si se encuentran conectados mediante una misma arista 
     * @param Entra un String u el cual es el identificador del extremo1 de la arista
     * @param Entra un String v el cual es el identificador del extremo2 de la arista
     * @return Devuelve true si el grafo contiene la arista que conecta ambos vertices
     * devuelve false en caso contrario
     * 
     * Tiempo: O(V)
     */

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

    /**  
     * Busca en el HashMap de vertices el id del vertice deseado y lo elimina
     * a su vez actualiza el contador del numero de vertices en caso de efectuar la eliminacion
     * 
     *  
     * @param Entra un String id  identificador de un vertice 
     * @return Devuelve true si elimina el vertice y devuelve false 
     * en caso contrario
     * 
     * 
     * Tiempo: O(V+E)
     */

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

    /**  
     * Crea una LinkedList de los vertices que se encuentran en el HashMap de vertices
     * @param no posee parametros de entrada
     * @return Devuelve una LinkedList de objetos de tipo Vertice que se encuentran en el grafo no dirigido
     * 
     * Tiempo: O(V)
     */

    public List<Vertice> vertices() {

        List<Vertice> return_list_vertices = new LinkedList<Vertice>();

        for (Vertice v : MapaDeVertices.values()) {
            return_list_vertices.add(v);
        }

        return return_list_vertices;
    }

    /**  
     * Crea una LinkedList de las aristas que se encuentran en el HashMap de aristas
     * 
     * @param no posee parametros de entrada
     * @return Devuelve una LinkedList de Objetos de tipo arista
     * 
     * Tiempo: O(E)
     */

    public List<Lado> lados() {

        List<Lado> return_list_lados = new LinkedList<Lado>();
        for (Arista l : MapaDeAristas.values()) {
            return_list_lados.add(l);
        }

        return return_list_lados;
    }

    /**  
     * Cuenta el grado de un vertice en el grafo no dirigido 
     * @param Entra un String con el identificador de un vertice al cual se le desea calcular el grado
     * @return Devuelve un entero de tipo entero que representa el grado del vertice
     * Tiempo: O(E)
     */

    public int grado(String id) {

        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeIncidencias().size(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    /**  
     * Crea una LinkedList de los vertices adyacentes al identificador dado de un vertice
     * @param recibe un string, el cual es el identificador de un vertice
     *  
     * @return Devuelve una LinkedList con los objetos de tipo vertice
     * que son adyacentes al vertice con un identificador dado
     * 
     * Tiempo: O(1)
     */

    public List<Vertice> adyacentes(String id) {
        
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeAdyacencias(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }
    
    /**  
     * Crea una linkedList con las aristas incidentes a un vertice dado por el identificador
     * @param  recibe un string con el identificador de un vertice   
     * @return Devuelve una LinkedList con las aristas incidentes al vertice
     * los cuales son adyacentes a id
     * 
     * Tiempo: O(1)
     */

    public List<Lado> incidentes(String id) {
        
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeIncidencias();
 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");

       
    }
    
    /**  
     * Crea una copia del grafo no dirigido
     * @param no posee parametros de entrada 
     * @return una copia del grafo no dirigido
     * 
     * Tiempo: O(V+E)
     */

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
    
    /**  
     * 
     * @param no posee parametros de entrada
     * @return Devuelve una representacion del contenido del grafo como 
     * una cadena de strings
     * 
     * Tiempo: O(V+E)
     */

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

    /**  
     *
     * @param  Entra un objeto de tipo arista   
     * @return Devuelve true en caso de que la insercion se lleva a cabo de manera satisfactoria y
     *  false en caso contrario
     * 
     * Tiempo: O(1)
     */

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

    /**  
     *
     * @param Entra un identificador de una arista tipo String 
     * @param Entra un double para el peso de la arista
     * @param Entra un string u el cual es el identificador del vertice 1
     * @param Entra un string v el cual es el identificador del vertice 2
     * @return Devuelve true en caso de que la insercion se lleva a cabo de manera satisfactoria,retorna
     *  false en caso contrario
     * 
     * Tiempo: O(1)
     */

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

     /**  
     * 
     * @param Entra un identificador de una arista tipo string  
     * @return Devuelve true en caso de que la eliminacion de la arista se lleva a cabo de manera satisfactoria,
     * retorna false en caso contrario
     * 
     * Tiempo: O(1)
     */

    public boolean eliminarArista(String id) {
        // Capaz tambien hay que verificar si estan ambo nodos de la arista dentro del grafo
        if (MapaDeAristas.containsKey(id)) {
            
            Arista aristaTemp = MapaDeAristas.get(id);

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

    /**  
     * 
     * @param Entra un identificador de una arista de tipo string  
     * @return Devuelve la arista que tiene el identificador dado si se encuentra en el grafo no dirigido
     * 
     * Tiempo: O(1)
     */
    public Arista obtenerArista(String id) throws NoSuchElementException { 
        if (MapaDeAristas.containsKey(id)) {
            return MapaDeAristas.get(id);
        }
        throw new NoSuchElementException("La arista no se puede obtener debido a que no se encuentra en la lista");
        
    }

    /**  
     * @param no posee parametro de entrada
     * @return escribe en un archivo.txt los resultados del grafo no dirigido con la misma estructura que
     *  el de la lectura
     *
     * Tiempo: O(V+E)
     */

    public void escribirArchivo(){
        Out escritura = new Out("GNDout.txt");
        escritura.println(numeroDeVertices);
        escritura.println(numeroDeLados);
        for(Vertice i : MapaDeVertices.values())
        {
            String a = i.getId();
            String p = String.valueOf(i.getPeso());
            escritura.print(a +" "+ p);
            escritura.print("\n");
        }
        for(Arista i : MapaDeAristas.values())
        {
            String a = i.getId();
            String l1 = i.getExtremo1().getId();
            String l2 = i.getExtremo2().getId();
            String p = String.valueOf(i.getPeso());
            escritura.print(a +" "+ l1 +" "+ l2+" "+ p);
            escritura.print("\n");
        }
    }
}
