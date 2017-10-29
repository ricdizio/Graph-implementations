/**********************************************************************************************************
 *    Compilacion:  javac Digrafo.java
 *    Ejecucion:    java  Digrafo
 *    Dependencias In.java,StdOut.java, Lado.java, Arista.java, Grafo.java
 *    
 *    Clase Grafo Dirigido que se utiliza en ClienteGrafo.java 
 *    
 *    En este archivo se implementa la estructura de datos grafo no dirigido 
 *    con el uso de otras estructuras de datos como HashMap y listas enlazadas
 *
 *
 *     Notacion para el tiempo de ejecucion: 
 *                                           V : Cardinalidad de vertices en el grafo no dirigido
 *                                           E : Cardinalidad de arcos en el grafo no dirigido
 *
 *    @author  Ricardo Di Zio 11-11274
 *    @author  Fabio Suarez   12-10578
 *    @version 1.0
 *    @since   2017-19-10
 *
 *  Lab4
 *************************************************************************************************************/

import java.util.*;
import java.io.*;

public class Digrafo implements Grafo
{
    private int numeroDeVertices;
    private int numeroDeLados;
    private HashMap<String, Arco> MapaDeArcos;
    public HashMap<String, Vertice> MapaDeVertices;

    /**  
     * @param No posee parametro de entrada
     * @return Crea un contador de tipo entero de Vertices que hay en el grafo dirigido
     * @return Crea un contador de tipo entero de Arco que hay en el grafo dirigido
     * @return Inicializa MapaDeVertices un HashMap de objetos de tipo vertice 
     * @return Inicializa MapaDeArcos  un HashMap de objetos de tipo arco
     */

    public Digrafo() {
        numeroDeVertices = 0;
        numeroDeLados = 0;
        MapaDeArcos = new HashMap <String,Arco>();
        MapaDeVertices = new HashMap <String,Vertice>();
      
    }

    /**  
     * @param Entra un string el cual es el parametro para construir un objeto de tipo In
     * @return true si se cargo perfectamente el Archivo
     * 
     * Tiempo: O(V+E)
     */
    int r = 0;
    public boolean cargarGrafo(String[] arbol, int nodoAnterior, int id)
    {
/*
        try{
        */

            //Creamos un objecto de tipo cadena
            cadena c = new cadena(arbol.length);

            //Copiamos todos los elementos del array arbol de string a cadena
            for(int i= 0;i<arbol.length;i++)
            {
                c.agregar(arbol[i]);
            }

            //Borramos primer y ultimo parentesis
            c.toStringChain();
            c.deleteByPos(0);
            c.deleteByPos(arbol.length-1);
            c.toStringChain();

            //Sacamos el nodo a agregar
            int last = 0;
            String acumulador = "";
            for(int i= 0;i<c.getTam();i++)
            {
                if(c.chain[i].equals("("))
                {
                    break;
                }
                else
                {
                    acumulador = acumulador + c.chain[i];
                }
                last = i;

            }

            //borramos el nodo del objecto cadena
            for(int i=0;i<=last;i++)
            {
                c.deleteByPos(0);
            }

            //Imprimimos para ver como quedo la cadena sin el ndo que agregaremos
            c.toStringChain();

            
            if(acumulador != "")
            {
                //Acumulador tiene el nodo
                int nodo = Integer.parseInt(acumulador);
                Double nodod = Double.parseDouble(acumulador);


                //Agregamos el nodo al hashmap
                Vertice z = new Vertice(Integer.toString(id),nodod);
                agregarVertice(z);
                System.out.println("Se agrego el vertice con id: "+id +" peso: "+nodo);
                //Agregamos arco con el nodo anterior
                if(nodoAnterior != -1)
                {
                    agregarArco(Integer.toString(id),1.0,String.valueOf(nodoAnterior),Integer.toString(id));
                    System.out.println("Se agrego el arco con id: "+id+" y va de v vertice id: "+ nodoAnterior +" a u vertice id: "+id);
                }



                // Contamos parentesis abiertos y cerrados
                int numParentesis = 0;
                int abiertos = 0;
                int cerrados = 0;
                int corte = 0;
                for(int i= 0;i<c.getTam();i++)
                {
                    if(c.chain[i].equals("("))
                    {
                        abiertos++;
                    }
                    if(c.chain[i].equals(")"))
                    {
                        cerrados++;
                    }
                    if(cerrados==abiertos)
                    {
                        //cortar arreglos
                        System.out.println("corte en : "+i);
                        corte = i;
                        break;
                    }

                }

                //Sacamos la mitad

                //Procedemos a dividir el arbol en 2
                //Izquierdo c1 , derecho c2
                int ultima = 0;
                List<String> l1 = new ArrayList<String>();
                //ArrayList l1 = new ArrayList();

                for(int i= 0;i<=corte;i++)
                {
                    l1.add(c.chain[i]);
                    ultima = i;
                }


                // Arbol derecho 
                List<String> l2 = new ArrayList<String>();

                //ArrayList l2 = new ArrayList();

                for(int i = ultima+1;i<c.getTam();i++)
                {
                    l2.add(c.chain[i]);
                }

                //Convertimos l1 y l2 a k1 y k2 de tipo String array
                
                String k1[] = new String[l1.size()];
                System.out.println("size cadena 1: "+l1.size());

                String k2[] = new String[l2.size()];
                System.out.println("size cadena 2: "+l2.size());
                for (int i=0;i<l1.size();i++ ) 
                {
                    k1[i] = l1.get(i);
                }

                for (int i=0;i<l2.size();i++ )
                {
                    k2[i] = l2.get(i); 
                }

                //Si l1 no es vacio, tiene elementos a particionar
                if(!(l1.get(1).equals(")")))
                {
                    //Llamada recursiva
                    System.out.println("nodo anterior: "+id);
                    cargarGrafo(k1,id,id+1);
                }

                //Si l2 no es vacio, tiene elementos a particionar
                if(!(l2.get(1).equals(")")))
                {
                    System.out.println("nodo anterior: "+id);
                    //Llamada recursiva             
                    cargarGrafo(k2,id,id+2);
                }

            }
            

        
        /*
        }
        catch(Exception e){
            System.out.println("No se pudo cargar el archivo");
            return false;
        }
        */
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
     * @return un contador de tipo entero el cual representa el numero de arcos
     * que hay en el grafo dirigido
     * 
     * Tiempo: O(1)
     */

    public int numeroDeLados() 
    {
    	return numeroDeLados;
    }

    /**  
     * @param recibe un objeto de tipo vertice
     * @return un booleano el cual representa si se pudo agregar el vertice al grafo dirigido 
     * de manera satisfactoria o no
     *
     * 
     * Tiempo: O(1)
     */
   
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

    /**  
     * @param recibe un string el cual representa el id del vertice que se desea agregar
     * @param recibe un double el cual representa el peso del vertice que se desea agregar
     * @return un booleano el cual representa si se pudo agregar el vertice al grafo dirigido 
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
     * @return vertice en el caso de que se encuentre en el grafo dirigido 
     * @return un mensaje avisando que el vertice no se encuentra en el grafos
     *
     * 
     * Tiempo: O(1)
     */
    public Vertice obtenerVertice(String id) {
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id); 
        }  
        
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    /**
     * Busca en el HashMap de vertices el id de un vertice y verifica 
     * si se encuentran en el grafo dirigido   
     * @param Entra un String que representa el identificador del vertice que se desea verificar
     * si se encuentra en el grafo no dirigido
     * @return un booleano true en caso de que el vertice se encuentre en el grafo dirigido  
     *  y false en caso contrario
     * 
     * Tiempo: O(1)
     */

    public boolean estaVertice(String id) 
    {
        return MapaDeVertices.containsKey(id);
    }


    public boolean estaPeso(Double p) {
        return MapaDeVertices.containsValue(p);
    }

    public int ObtIdByPeso(Double p) 
    {
        for (Vertice v : MapaDeVertices.values()) 
        {
            if(v.getPeso() == p)
            {
                return Integer.parseInt(v.getId());
            }
        }
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +p+ " no se encuentra en el Grafo");
    }


    /**  
     * Busca en el HashMap de vertices el id de ambos vertices y verifica 
     * si se encuentran conectados mediante una misma arista 
     * @param Entra un String u el cual es el identificador del extremo incial de la arci
     * @param Entra un String v el cual es el identificador del extremo final de la arco
     * @return Devuelve true si el grafo contiene el arco que conecta ambos vertices
     * devuelve false en caso contrario
     * 
     * Tiempo: O(V)
     */

    public boolean estaLado(String u, String v){

        if (estaVertice(u) == true && estaVertice(v) == true ) {

            //Partida
            Vertice v1 = MapaDeVertices.get(u);
            //llegada
            Vertice v2 = MapaDeVertices.get(v);


            for(Vertice i: v1.getListaDeSucesores()){
                if(i.getId().equals(v2)){
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
        List<Arco> temp_lista_incidencia = new LinkedList<Arco>();
        List<Vertice> temp_lista_sucesores = new LinkedList<Vertice>();
        List<Vertice> temp_lista_predecesores = new LinkedList<Vertice>();

        if (estaVertice(id)) {

            Vertice verticeTemp = MapaDeVertices.get(id);

            for(Lado l : verticeTemp.getListaDeIncidencias()){
                    Arco arco = (Arco)l;
                    temp_lista_incidencia.add(arco);
            }

            // Borrando Incidencias
            for (Lado arco: temp_lista_incidencia) {

                int posicion = verticeTemp.getListaDeIncidencias().indexOf(arco);
                //eliminarArista(arista.getId());
                if (posicion != -1) {
                    eliminarArco(verticeTemp.getListaDeIncidencias().get(posicion).getId());                     
                }
                else{
                    continue;
                }
                             
                
            }

            //Proceso para borrar los elementos de la lista de sucesores
            //Primero copiamos los sucesores en el temporal para iterar sobre ellos y luego borrar los elementos en la lista principal
            for(Vertice vertice : verticeTemp.getListaDeSucesores()){
                    temp_lista_sucesores.add(vertice);
            }

            for (Vertice v: temp_lista_sucesores) { 

                int pos = verticeTemp.getListaDeSucesores().indexOf(v);
                
                if (pos != -1) {
                   
                    MapaDeVertices.get(verticeTemp.getListaDeSucesores().get(pos).getId()).getListaDePredecesores().remove(verticeTemp);

                }
                else{
                    continue;
                }
            }


            //Caso Analogo pero para predecesores
            for(Vertice vertice : verticeTemp.getListaDePredecesores()){
                    temp_lista_predecesores.add(vertice);
            }

            for (Vertice v: temp_lista_predecesores) {

                int pos = verticeTemp.getListaDePredecesores().indexOf(v);
                
                if (pos != -1) {
                   
                    MapaDeVertices.get(verticeTemp.getListaDePredecesores().get(pos).getId()).getListaDeSucesores().remove(verticeTemp);

                }
                else{
                    continue;
                }
            }



            //temporal de vertices lista de adyacencias
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
     * @return Devuelve una LinkedList de objetos de tipo Vertice que se encuentran en el grafo 
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
     * Crea una LinkedList de los arcos que se encuentran en el HashMap de arcos
     * 
     * @param no posee parametros de entrada
     * @return Devuelve una LinkedList de Objetos de tipo arco
     * 
     * Tiempo: O(E)
     */


    public List<Lado> lados() {
        List<Lado> return_list_lados = new LinkedList<Lado>();
        for (Arco l : MapaDeArcos.values()) {
            return_list_lados.add(l);
        }

        return return_list_lados;
    }

    /**  
     * Cuenta el grado de un vertice en el grafo 
     * @param Entra un String con el identificador de un vertice al cual se le desea calcular el grado
     * @return Devuelve un entero de tipo entero que representa el grado del vertice
     * Tiempo: O(E)
     */

    public int grado(String id) {

    	if(MapaDeVertices.get(id)!= null)
    	{
            return MapaDeVertices.get(id).getListaDeSucesores().size() + MapaDeVertices.get(id).getListaDePredecesores().size(); 
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

    public List<Vertice> adyacentes(String id) 
    {
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
 
    public List<Lado> incidentes(String id) 
    {
    	if(MapaDeVertices.get(id)!= null)
    	{
            return MapaDeVertices.get(id).getListaDeIncidencias(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }


    /**  
     * Crea una copia del grafo dirigido
     * @param no posee parametros de entrada 
     * @return una copia del grafo dirigido
     * 
     * Tiempo: O(V+E)
     */


    public Object clone() {
        Digrafo cloneGD = new Digrafo();
        HashMap<String, Vertice> hashMap_vertices_clone = new HashMap<String, Vertice>();
        HashMap<String, Arco> hashMap_arcos_clone = new HashMap<String, Arco>();

        for(Vertice v : MapaDeVertices.values()){
            hashMap_vertices_clone.put(v.getId(),v);
        }
        for(Arco a : MapaDeArcos.values()){
            hashMap_arcos_clone.put(a.getId(), a);
        }
        for(Vertice v : hashMap_vertices_clone.values()){
            cloneGD.agregarVertice(v);
        }
        for(Arco a : hashMap_arcos_clone.values()){
            cloneGD.agregarArco(a);
        }
        return cloneGD;
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
        HashSet<String> setArco = new HashSet<String>();
        HashSet<String> setSuc = new HashSet<String>();
        HashSet<String> setPre = new HashSet<String>();

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
                    
                    setArco.add(l.getId());
                }

                Iterator<String> iterator = setArco.iterator();
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
            sb.append("Vertice id ");
            sb.append(vertice.getId() +  "        sucesores --------------> ");
            sb.append(" [ ");
            if(vertice.getListaDeSucesores().size() >= 1){

                for (Vertice v: vertice.getListaDeSucesores()) {

                    setSuc.add(v.getId());                  
                }

                Iterator<String> iterator = setSuc.iterator();
                while (iterator.hasNext()) {
                    sb.append(iterator.next() + ", ");
                }

                sb.append(" ] ");
            }

            else if (vertice.getListaDeAdyacencias().size() == 0) {
                sb.append(" No hay elementos sucesores al vertice ");    
            }
                       
            sb.append("\n");
            sb.append("\n");
            sb.append("\n");
            sb.append("Vertice id ");
            sb.append(vertice.getId() +  "        predecesores --------------> ");
            sb.append(" [ ");
            if(vertice.getListaDePredecesores().size() >= 1){

                for (Vertice v: vertice.getListaDePredecesores()) {

                    setPre.add(v.getId());                  
                }

                Iterator<String> iterator = setPre.iterator();
                while (iterator.hasNext()) {
                    sb.append(iterator.next() + ", ");
                }

                sb.append(" ] ");
            }

            else if (vertice.getListaDePredecesores().size() == 0) {
                sb.append(" No hay elementos predecesores al vertice ");    
            }
                       
            sb.append("\n");
            sb.append("\n");
            sb.append("\n");
            
            // Limpiamos las listas para que no nos afecte en la impresion de las variables temporales
            setVertice.clear();
            setArco.clear();
            setPre.clear();
            setSuc.clear();
        }
        return sb.toString();
    }

    /**  
     *
     * @param  Entra un objeto de tipo arco 
     * @return Devuelve true en caso de que la insercion se lleva a cabo de manera satisfactoria y
     *  false en caso contrario
     * 
     * Tiempo: O(1)
     */

    public boolean agregarArco(Arco a) {
        int temp = numeroDeLados;
        if((MapaDeArcos.containsKey(a.getId()))) {

            System.out.println("El arco con el identificador '"+a.getId()+"' ya se encuentra en el grafo.");
            return false;
        }

        if ((estaVertice(a.getExtremoInicial().getId())) && ( estaVertice(a.getExtremoFinal().getId()))) {
            // En GD debe agregar a un vertice en los sucesores y en el otro en los predecesores
            // para este caso agrega en los adyacentes
            obtenerVertice(a.getExtremoInicial().getId()).adyacencias.add(a.getExtremoFinal());
            obtenerVertice(a.getExtremoFinal().getId()).adyacencias.add(a.getExtremoInicial());
            
            // En GD debe agregar a un vertice en los sucesores y en el otro en los predecesores
            // para este caso agrega en los Sucesores y Predecesores
            obtenerVertice(a.getExtremoInicial().getId()).sucesores.add(a.getExtremoFinal());
            obtenerVertice(a.getExtremoFinal().getId()).predecesores.add(a.getExtremoInicial());
            

            //agregar incidencias
            obtenerVertice(a.getExtremoInicial().getId()).incidencias.add(a);
            obtenerVertice(a.getExtremoFinal().getId()).incidencias.add(a);

            numeroDeLados++;
            MapaDeArcos.put(a.getId(), a);

        }

        if(temp < numeroDeLados)
        {
            return true;
        }
        return false;
    } 


    /**  
     *
     * @param Entra un identificador de un arco tipo String 
     * @param Entra un double para el peso del arco
     * @param Entra un string u el cual es el identificador del vertice 1
     * @param Entra un string v el cual es el identificador del vertice 2
     * @return Devuelve true en caso de que la insercion se lleva a cabo de manera satisfactoria,retorna
     *  false en caso contrario
     * 
     * Tiempo: O(1)
     */

    public boolean agregarArco(String id, double peso, String u, String v)
    {   
        Vertice v1 = MapaDeVertices.get(u);
        Vertice v2 = MapaDeVertices.get(v);
        Arco a = new Arco(id,peso,v1,v2);
        boolean x = agregarArco(a);
        return x;
    }
     /**  
     * 
     * @param Entra un identificador de un vertice tipo string  
     * @return Devuelve el ggrado interior al dicho vertice
     * 
     * Tiempo: O(1)
     */

    public int gradoInterior(String id) {

        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDePredecesores().size(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

     /**  
     * 
     * @param Entra un identificador de un vertice tipo string  
     * @return Devuelve el grado exterior al dicho vertice
     * 
     * Tiempo: O(1)
     */
    public int gradoExterior(String id) {
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeSucesores().size(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

     /**  
     * 
     * @param Entra un identificador de un vertice tipo string  
     * @return Devuelve la lista de sucesores acociados al vertice
     * 
     * Tiempo: O(1)
     */
    public List<Vertice> sucesores(String id) {
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeSucesores(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }



     /**  
     * 
     * @param Entra un identificador de un vertice tipo string  
     * @return Devuelve la lista de predecesores acociados al vertice
     * 
     * Tiempo: O(1)
     */
    public List<Vertice> predecesores(String id) {
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDePredecesores(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }


     /**  
     * 
     * @param Entra un identificador de un arco tipo string  
     * @return Devuelve true en caso de que la eliminacion de la arco se lleva a cabo de manera satisfactoria,
     * retorna false en caso contrario
     * 
     * Tiempo: O(1)
     */
    public boolean eliminarArco(String id) {
        // Capaz tambien hay que verificar si estan ambo nodos de la arcos dentro del grafo
        if (MapaDeArcos.containsKey(id)) {
            
            Arco arcoTemp = MapaDeArcos.get(id);
            // Y distintos de null?

            if (MapaDeVertices.containsKey(arcoTemp.getExtremoInicial().getId()) && MapaDeVertices.containsKey(arcoTemp.getExtremoFinal().getId())) {

                // Procedemos a borrar los nodos en la lista de sucesores y predecesores de cada nodo , devolver excepcion
                MapaDeVertices.get(arcoTemp.getExtremoInicial().getId()).getListaDeSucesores().remove(arcoTemp.getExtremoFinal());
                MapaDeVertices.get(arcoTemp.getExtremoFinal().getId()).getListaDePredecesores().remove(arcoTemp.getExtremoInicial());

                // Procedemos a borrar los vertices en la lista de sucesores y predecesores de cada vertice , devolver excepcion
                MapaDeVertices.get(arcoTemp.getExtremoInicial().getId()).getListaDeSucesores().remove(arcoTemp.getExtremoFinal());
                MapaDeVertices.get(arcoTemp.getExtremoFinal().getId()).getListaDePredecesores().remove(arcoTemp.getExtremoInicial());

                //borramos de la lista de adyacencias el nodo de llegada
                MapaDeVertices.get(arcoTemp.getExtremoInicial().getId()).getListaDeAdyacencias().remove(arcoTemp.getExtremoFinal());
                MapaDeVertices.get(arcoTemp.getExtremoFinal().getId()).getListaDeAdyacencias().remove(arcoTemp.getExtremoInicial());
                // Procedemos a borrar el lado de la lista de incidencia de ambos nodos
                arcoTemp.getExtremoInicial().getListaDeIncidencias().remove(arcoTemp);
                arcoTemp.getExtremoFinal().getListaDeIncidencias().remove(arcoTemp);
            
                //Borramos del HashMap de aristas

                MapaDeArcos.remove(arcoTemp);
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
     * @param Entra un identificador de un arco de tipo string  
     * @return Devuelve el arco que tiene el identificador dado si se encuentra en el grafo dirigido
     * 
     * Tiempo: O(1)
     */

    public Arco obtenerArco(String id) throws NoSuchElementException {
        if(MapaDeArcos.containsKey(id)){
            return MapaDeArcos.get(id);
        }
	throw new NoSuchElementException("El arco con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }   

    /**  
     * @param no posee parametro de entrada
     * @return escribe en un archivo.txt los resultados del grafo dirigido con la misma estructura que
     *  el de la lectura
     *
     * Tiempo: O(V+E)
     */

    public void escribirArchivo(){
        Out escritura = new Out("DIout.txt");
        escritura.println(numeroDeVertices);
        escritura.println(numeroDeLados);
        for(Vertice i : MapaDeVertices.values())
        {
            String a = i.getId();
            String p = String.valueOf(i.getPeso());
            escritura.print(a +" "+ p);
            escritura.print("\n");
        }
        for(Arco i : MapaDeArcos.values())
        {
            String a = i.getId();
            String l1 = i.getExtremoInicial().getId();
            String l2 = i.getExtremoFinal().getId();
            String p = String.valueOf(i.getPeso());
            escritura.print(a +" "+ l1 +" "+ l2+" "+ p);
            escritura.print("\n");
        }
    }

    public HashMap getMapaVertices(){
        return MapaDeVertices;
    }

}