/**********************************************************************************************************
 *   Compilacion:  javac Arista.java
 *   Ejecucion:    java Arista
 *   Dependencias: Vertice.java y Lado.java
 * 
 *   Subclase Arista la cual hereda las caracteristicas de la clase Lado  
 * 
 *   Esta subclase sirve para poder compilar y ejecutar las clases GrafoNoDirigido.java y ClienteGrafo.java  
 *   las cuales forman  parte de la implementacion de la estructura de datos grafo no dirigido 
 *   mediante el uso de HashMap y listas enlazadas
 *
 *
 *    @author  Ricardo Di Zio 11-11274 
 *    @author  Fabio Suarez   12-10578
 *    @version 1.0
 *    @since   2017-10-19
 *
 * 
 *************************************************************************************************************/
import java.util.*;

/**  
     * Clase constructora que inicializa al objeto arista con atributo id el cual representa 
     * la identificacion de la arista de tipo String y el atributo peso el cual es de tipo double y 
     * representa el valor de la arista.
     *
     */

public class Arista extends Lado
{
  private Vertice u;
  private Vertice v;
  
  public Arista(String id, double peso, Vertice u, Vertice v) {
    super(id,peso);
    this.u = u;
    this.v = v;
  }
  /**  
    * @param No posee parametro de entrada 
    * @return devuelve un objeto vertice el cual representa el extremo1 de una arista 
    */

  public Vertice getExtremo1() {
    return this.u;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return devuelve un objeto vertice el cual representa el extremo2 de una arista 
    */

  public Vertice getExtremo2() {
    return this.v;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return devuelve un string con los datos id y peso de la arista 
    */

  public String toString() {
    return this.u + "<----->"+ this.v+" peso "+"\n Peso de la Arista "+ this.getPeso()
    +" id de la Arista "+this.getId();
  }
}