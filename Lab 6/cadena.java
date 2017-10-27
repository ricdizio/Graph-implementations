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

import java.util.*;

public class cadena
{

  private int longitud = 0;
  public String chain[];
  private int pointer = 0;


  public cadena (int x) 
  {
  	this.longitud = x;
    this.chain = new String[x];
  }

  public void agregar(String elemento) 
  {
  	this.chain[this.pointer] = elemento;
    this.pointer++;
   }

  public void deleteByPos(int x)
  {
    for(int i = x; i<this.longitud-1;i++)
    {
      chain[i] = chain[i+1];
    }
    this.longitud--;
    this.pointer--;
  }

  public boolean findElement(String x)
  {
    for(int i = 0; i<=this.longitud;i++)
    {
      if(x == this.chain[i])
      {
        return true;
      }
    }
    return false;
  }

  public void toStringChain ()
  {
    for(int i = 0; i<this.longitud;i++)
    {
      System.out.print(chain[i] + " ");
    }
    System.out.print("\n");
  }

  public int getTam ()
  {
    return this.longitud;
  }
}