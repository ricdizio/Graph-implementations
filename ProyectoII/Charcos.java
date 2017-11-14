/**********************************************************************************************************
 *    Compilacion:  javac Charcos.java
 *    Ejecucion:    java  Charcos
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

public class Charcos
{
	public int len;
	public LinkedList<Vertice> calcCharcos(Digrafo gd)
	{
		this.len = 0;
		Tarjan x = new Tarjan(gd);
		LinkedList<Vertice> returnList = new LinkedList<Vertice>();
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

		while(!charco.empty())	
		{
			List<Vertice> u = charco.pop();
			for(Vertice i : u)
			{
				i.charco = true;
				returnList.add(i);
				this.len++;
			}
		}
		return returnList;
	}
	/**  
     * @param Entrada un digrafo
     * @param Entrada int cantidad, el cual representa la suma hasta ese momento de los calculos
   	 * de los metros cubicos
     * @return retorna la cantidad de la suma actualizada para la siguiente llamada recursiva
     * 
     * Tiempo: O(V al cubo +E)
     */
	public int calcCharcosRec(Digrafo gd, int cantidad)
	{
		LinkedList<Vertice> lista;
		lista = this.calcCharcos(gd);
		do
		{
			for(Vertice s : lista)
			{

				boolean sumar = true;
				for(Vertice p : s.getListaDePredecesores())
				{
					if(p.getPeso() <= s.getPeso() && !s.getListaDePredecesores().contains(p))
					{
						sumar = false;
					}
					else if(p.esquina == true && p.getPeso() == s.getPeso())
					{
						//return cantidad;
					}			
			    }
			    if(sumar)
			    {
			    	s.peso = s.peso + 1;
			    	cantidad++;

			    	Iterator<Vertice> iteradorV = s.getListaDePredecesores().iterator();

					while(iteradorV.hasNext())
					{
						Vertice y = iteradorV.next();
						if(s.getPeso() == y.getPeso() && !(lista.contains(s) && lista.contains(y)))
			    		{
			    			int numero = Integer.valueOf((gd.numeroDeLados()));
			    			numero++;
			    			gd.agregarArco(String.valueOf(numero),0.0,s.getId(),y.getId());
			    		}
					}
			    }
			}
			//Reseteamos Vertices para el tarjan
			for (Vertice e : gd.vertices())
			{
				e.reset();
			}
			lista = this.calcCharcos(gd);
			
		}while(lista.size() != 0);
		return cantidad;
	}

	public static void main(String [] args) 
	{
		String input_txt = args[0];

		Digrafo gd = new Digrafo();

		gd.cargarGrafo(input_txt);

		Charcos r = new Charcos();
		int cantidad = r.calcCharcosRec(gd,0);
		System.out.println("El volumen es igual a " + cantidad + " metros cubicos"+"\n");

	}
}
