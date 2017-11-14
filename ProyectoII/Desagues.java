import java.util.Stack;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Desagues{

   public static void main(String [] args) 
   {
      String input_txt = args[0];

      Digrafo gd = new Digrafo();

      gd.cargarGrafo(input_txt);
      //System.out.println(gd.toString());

      Tarjan x = new Tarjan(gd);
      List<List<Vertice>> conjunto;
      conjunto = x.getComponentes();
      Stack<List<Vertice>> charco = new Stack<List<Vertice>>();


      for(List<Vertice> element : conjunto)
      {
         // Element es un conjunto de vertices las cuales representan una componete conexa

         //System.out.println("Componente:");
         //System.out.println(element);
         boolean candidatoComponente = true; //element es candidato a charco?
         for(Vertice s : element)
         {
               //Si el vertice pertece a un borde descartamos la componente conexa 
               if(s.esquina == true) 
               {
                  candidatoComponente = false;
                  //System.out.println("Nodo esquina: " + s);
                  break;
               }
               //Caso contrario
               else
               {
                  //System.out.println("Nodo size: " + s.getListaDeSucesores().size());
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
         //System.out.println("Nodo charco: " + charco.pop());
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