/**********************************************************************************************************
 *    Compilacion:  javac cadena.java
 *    Ejecucion:    java cadena
 *    Dependencias: Ninguna
 *
 *    Clase objecto cadena el cual es una implementacion de strings sobre arreglos
 *   
 *
 *
 *    @author  Ricardo Di Zio 11-11274
 *    @author  Fabio Suarez   12-10578
 *    
 *    @version 1.0
 *    @since   2017-10-28
 *
 * 
 *************************************************************************************************************/
/**  
     * Clase constructora que inicializa al objeto Cadena con atributo x el cual representa 
     * la logitud de la cadena de strings
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