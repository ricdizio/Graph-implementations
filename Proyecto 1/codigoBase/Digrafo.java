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
    Map<String, Vertice> MapaDeArcos = New HashMap<String, Arco>();
    Map<String, Vertice> MapaDeVertices = New HashMap<String, Vertice>();

    public Digrafo() {
        numeroDeVertices = 0;
        numeroDeLados = 0;
      
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

            agregarVertice(id_del_vertice,peso_del_vertice);

        }

        for (int i=0;i<cantidad_de_arcos;i++) {
            String id_de_arco = in.readString();
            String id_vertice_de_Salida = in.readString();
            String id_vertice_de_Llegada = in.readString();
            double peso_del_arco = in.readDouble();
            // se proceden a crear y verificar si ya fueron agregados los arcos

            agregarArco(id_de_arco,peso_del_arco,id_vertice_de_Salida,id_vertice_de_Llegada);

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


    public boolean agregarVertice(String id, double peso) 
	{ 
        boolean booleano;
        Vertice v = new Vertice(id,peso);
        booleano = agregarVertice(v);
        
        return booleano;
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
        return MapaDeVertices.containsKey(id);
    }

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

        else{
            return false;
        } 
              
    }

    public boolean eliminarVertice(String id) {
    }

    public List<Vertice> vertices() {

        List<Vertice> return_list_vertices = new LinkedList<Vertice>();

        for (Vertice v : MapaDeVertices.values()) {
            return_list_vertices.add(v);
        }

        return return_list_vertices;
    }

    public List<Lado> lados() {
    }

    public int grado(String id) {

    	if(MapaDeVertices.get(id)!= null)
    	{
            return MapaDeVertices.get(id).getListaDeSucesores().size() + MapaDeVertices.get(id).getListaDePredecesores().size(); 
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
 
    public List<Lado> incidentes(String id) 
    {
    	if(MapaDeVertices.get(id)!= null)
    	{
            return MapaDeVertices.get(id).getListaDeIncidencias(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public Object clone() {
        Digrafo x = new Digrafo();
        return x;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        HashSet setVertice = new HashSet();
        HashSet setArista = new HashSet();

        for (Vertice vertice: MapaDeVertices.values()) {
            sb.append("\n");
            sb.append("Vertice id ");
            sb.append(vertice.getId() + " - " + vertice.getPeso()+ " ADYACENCIAS --------------> ");
            sb.append(" [ ");
            if(vertice.getListaDeAdyacencias().size() >= 1){

                for (Vertice v: vertice.getListaDeAdyacencias()) {

                    setVertice.add(v.getId());                  
                }

                Iterator iterator = setVertice.iterator();
                while (iterator.hasNext()) {
                    sb.append(iterator.next() + ", ");
                }

                sb.append(" ] ");
            }

            else if (vertice.getListaDeAdyacencias().size() == 0) {
                sb.append(" No hay elementos adyacentes al vertice ");    
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

                Iterator iterator = setArista.iterator();
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

    public boolean agregarArco(Arco a) 
    {
        int temp = numeroDeLados;
        for(Arco arco : MapaDeArcos.values())
        {
            if(arco.getId().equals(a.getId()))
            {
                System.out.println("El arco con el identificador '"
                    +a.getId()+"' ya se encuentra en el grafo.");
                return false;
            }
        }
        // Revisaaaar
        for(Vertice vertice1 : MapaVertices.values())
        {
            if(vertice1.getId().equals(a.getExtremoInicial().getId())){
                vertice1.getListaDeAdyacencias().add(a.getExtremoFinal()); 
                vertice1.getListaDeSucesores().add(a.getExtremoFinal());
                //Agregar a nodo a predecesores
                a.getExtremoFinal().getListaDePredecesores.add(a.getExtremoInicial());

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

    public boolean agregarArco(String id, double peso, Vertice v1, Vertice v2)
    {
        Arco a = new Arco(id,peso,v1,v2);
        boolean x = agregarArco(a);
        return x;
    }

    public int gradoInterior(String id) {

        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDePredecesores().size(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public int gradoExterior(String id) {
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeSucesores().size(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public List<Vertice> sucesores(String id) {
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDeSucesores(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public List<Vertice> predecesores(String id) {
        if(MapaDeVertices.get(id)!= null)
        {
            return MapaDeVertices.get(id).getListaDePredecesores(); 
        }    
        throw new NoSuchElementException("El vertice con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
    }

    public boolean eliminarArco(String id) {

    }

    public Arco obtenerArco(String id) throws NoSuchElementException {
        if(MapaDeArcos.containsKey(id)){
            return MapaDeArcos.get(id);
        }
    }	throw new NoSuchElementException("El arco con el idenficador: " 
            +id+ " no se encuentra en el Grafo");
}