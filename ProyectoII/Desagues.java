/**********************************************************************************************************
 *    Compilacion:  javac Desagues.java
 *    Ejecucion:    java  Desagues
 *    Dependencias In.java, Out.java,Lado.java, Arco.java, Grafo.java, Digrafo.java, Tarjan.java
 *    
 *    El makefile compila todo el proyecto siguiendo el orden de dependencias
 *    
 *    ProyectoII
 *
 *    @author  Ricardo Di Zio 11-11274
 *    @author  Fabio Suarez   12-10578
 *    @version 1.0
 *    @since   2017-14-11
 *
 * 
 *************************************************************************************************************/
import java.util.Stack;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Desagues{

   /**  
     * @param Entrada un digrafo Leido del txt pasado por consola
     * @return retorna la matriz con x en los sitios donde hay que poner desagues
     * 
     * Tiempo: O(V al cubo +E)
     */

   public static void main(String [] args) 
   {
      String input_txt = args[0];

      Digrafo gd = new Digrafo();

      gd.cargarGrafo(input_txt);

      Tarjan x = new Tarjan(gd);
      List<List<Vertice>> conjunto;
      conjunto = x.getComponentes();
      Stack<List<Vertice>> charco = new Stack<List<Vertice>>();


      for(List<Vertice> element : conjunto)
      {
         // Element es un conjunto de vertices las cuales representan una componete conexa

         boolean candidatoComponente = true; //element es candidato a charco?
         for(Vertice s : element)
         {
               //Si el vertice pertece a un borde descartamos la componente conexa 
               if(s.esquina == true) 
               {
                  candidatoComponente = false;
                  break;
               }
               //Caso contrario
               else
               {
                  boolean candidato = true;
                  for(Vertice d : s.getListaDeSucesores())
                  {
                     if(d.getPeso() < s.getPeso())
                     {
                        candidato = false;
                        break;
                     }
                  }
                  if(!candidato)
                  {
                     candidatoComponente = false;
                     break;
                  }
               }
            }
         if(candidatoComponente)
            {
               charco.push(element);
            }
      }
      //Armamos matriz de charcos
      String[][] matriz = new String[gd.getNumeroDeFilas()][gd.getNumeroDeColumnas()];
      for (int i = 0; i < gd.getNumeroDeFilas() ; i++ ) 
      {
         for (int j = 0; j < gd.getNumeroDeColumnas() ;j++ ) 
         {
            matriz[i][j] = "0";
         }
      }


      while(!charco.empty())  
      {
         List<Vertice> u = charco.pop();
         for(Vertice i : u)
         {
            i.charco = true;
            String id = i.getId();
            String[] result = id.split("-");
            int coordX = Integer.valueOf(result[0]);
            int coordY = Integer.valueOf(result[1]);
            matriz[coordX][coordY] = "x";
         }

      }

      //Printeamos matriz
      for (int i = 0; i < gd.getNumeroDeFilas() ; i++ ) 
      {
         for (int j = 0; j < gd.getNumeroDeColumnas() ;j++ ) 
         {
            System.out.print(matriz[i][j] + " ");
         }
         System.out.println();
      }
   }
}