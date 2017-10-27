/**********************************************************************************************************
 *  Compilacion:  javac Arco.java
 *  Ejecucion:    java Arco
 *  Dependencias: Vertice.java y Lado.java
 * 
 *  Subclase Arco la cual hereda las caracteristicas de la clase Lado  
 * 
 *  Esta subclase de la clase Lado sirve para poder compilar y ejecutar las clases Digrafo.java y ClienteGrafo.java  
 *  los cuales forman parte de la implementacion de la estructura de datos grafo dirigido mediante 
 *  el uso de HashMap y listas enlazadas
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
     * Clase constructora que inicializa al objeto arco con atributo id el cual representa 
     * la identificacion del arco de tipo String y el atributo peso el cual es de tipo double y 
     * representa el valor del Arco. 
     *
     */

public class Arco extends Lado
{
  private Vertice extremoInicial;
  private Vertice extremoFinal;
  
  public Arco(String id, double peso, Vertice extremoInicial, Vertice extremoFinal) {
    super(id,peso);
    this.extremoInicial = extremoInicial;
    this.extremoFinal = extremoFinal;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return devuelve un objeto vertice el cual representa el vertice de salida de un arco 
    */

  public Vertice getExtremoInicial() {
    return this.extremoInicial;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return devuelve un objeto vertice el cual representa el vertice de llegada de un arco 
    */

  public Vertice getExtremoFinal() {
    return this.extremoFinal;
  }

  /**  
    * @param No posee parametro de entrada 
    * @return devuelve un string con los datos del arco
    */

  public String toString() {
    return this.extremoInicial + " --------> " + this.extremoFinal+"\n"+" Peso del arco "+ this.getPeso()
    +" id del arco "+this.getId(); 
  }
}
