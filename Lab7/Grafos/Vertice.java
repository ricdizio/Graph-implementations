/**********************************************************************************************************
 *  Compilacion:  javac Vertice.java
 *  Ejecucion:    java Vertice
    Dependencias: ninguna
 *
 *  Clase Vertice que se utiliza para poder compilar y correr Arista.java, Arco.java,GrafoNoDirigido.java,  
 *  Digrafo.java y ClienteGrafo.java 
 *  los cuales forman  parte de la implementacion de la estructura de datos grafo no dirigido y dirigido mediante  
 *  el uso de las estructuras de datos de hashMap y listas enlazadas. 
 *    
 *  @author  Ricardo Di Zio 11-11274
 *  @author  Fabio Suarez   12-10578
 *  @version 1.0
 *  @since   2017-10-19
 * 
 *************************************************************************************************************/
/* 
   * Clase constructora que inicializa al Vertice con atributo id el cual representa 
   * la identificacion del Vertice de tipo String y el atributo peso el cual es de tipo double 
   * y representa el valor del vertice, a su vez tambien inicializa las listas de vertices de adyacencias
   * sucesores y predecesores, e inicializa la lista de lados la cual representa las incidencias para cada vertice. 
   *
   */

import java.util.*;

public class Vertice
{
  private String id;
  private double peso;
  public List<Vertice> adyacencias;
  public List<Vertice> sucesores;
  public List<Vertice> predecesores;
  public List<Lado> incidencias;


  /**  
     * @param tipo string el cual representa la identificacion del vertice
     * @param tipo double el cual representa el valor del Vertice  
     *
     */
  
  public Vertice(String id, double peso) {
    this.id = id;
    this.peso = peso;
    this.adyacencias = new LinkedList<Vertice>();
    this.sucesores = new LinkedList<Vertice>();
    this.predecesores = new LinkedList<Vertice>();
    this.incidencias = new LinkedList<Lado>();

    List<Vertice> adyacencias = new LinkedList<Vertice>();
    List<Vertice> sucesores = new LinkedList<Vertice>();
    List<Vertice> predecesores = new LinkedList<Vertice>();
    List<Lado> incidencias = new LinkedList<Lado>();
  }

  /**  
    * @param No posee parametro de entrada 
    * @return Devuelve el valor del atributo peso del objeto vertice el cual es del tipo double 
    *
    */

  public double getPeso() {
    return this.peso;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return Devuelve el valor del atributo id del objeto vertice el cual es del tipo string 
    *
    */

  public String getId() {
    return this.id;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return Devuelve los datos del Vertice en una cadena de string
    *
    */

  public String toString() { 
    return "El Vertice tiene el id: " + this.id + " y peso: " + this.peso; 
  }

  /**  
    * @param No posee parametro de entrada 
    * @return una lista enlazada de objetos de tipo vertice, la cual representa una lista de adyacencia 
    *
    */

  public List<Vertice> getListaDeAdyacencias(){
    return this.adyacencias;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return una lista enlazada de objetos de tipo lado, la cual representa una lista de incidencias 
    *
    */

  public List<Lado> getListaDeIncidencias(){
    return this.incidencias;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return una lista enlazada de objetos de tipo vertice, la cual representa una lista de vertices predecesores 
    *
    */

  public List<Vertice> getListaDePredecesores(){
    return this.predecesores;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return una lista enlazada de objetos de tipo vertice, la cual representa una lista de vertices sucesores 
    *
    */

  public List<Vertice> getListaDeSucesores(){
    return this.sucesores;
  }
}