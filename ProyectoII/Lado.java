/**********************************************************************************************************
 *    Compilacion:  javac Lado.java
 *    Ejecucion:    java Lado
 *    Dependencias: Ninguna
 *
 *    Clase abstracta Lado que se utiliza en las subclases Arista.java y Arco.java
 *    
 *    Ademas es necesaria para poder correr GrafoNoDirigido.java, Digrafo.java y ClienteGrafo.java  
 *    los cuales forman parte en la implementacion de la estructura de datos grafo no dirigido 
 *     y dirigido mediante el uso de HashMap y listas enlazadas
 *
 *
 *    @author  Ricardo Di Zio 11-11274
 *    @author  Fabio Suarez   12-10578
 *    
 *    @version 1.0
 *    @since   2017-10-19
 *
 * 
 *************************************************************************************************************/
/**  
     * Clase constructora que inicializa al objeto Lado con atributo id el cual representa 
     * la identificacion del Lado de tipo String y el atributo peso el cual es de tipo double y 
     * representa el valor del Lado.
     *
     */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class Lado
{
  private String id;
  private double peso;


  public Lado(String id, double peso) {
  	this.id = id;
  	this.peso = peso;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return un string el cual representa el id del lado 
    */

  public String getId() {
  	return this.id;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return un double el cual representa el peso del lado
    */
  public double getPeso() {
  	return this.peso;
  }
  
  public abstract String toString();
}