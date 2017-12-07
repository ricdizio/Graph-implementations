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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



public class WALLW
{
	
	public static void main(String [] args) 
	{
		List<Vertice> listadeVertices = new ArrayList<Vertice>();
		int cantidadVertices = listadeVertices.size();
		List<String> caminosLargos = new ArrayList<String>();
		List<Integer> numLados = new ArrayList<Integer>();
		String[] caminosMax;
		int[] ladosMax;
		caminosMax = new String[listadeVertices.size()];
		ladosMax = new int[listadeVertices.size()];
		int temporalLados = 0;
		int temporalPos = 0;
		String caminoFinal;


		// Carga

		In in;
		Digrafo gd;
		int cubos;
		String input_txt = args[0];



			in = new In(input_txt);

			cubos = in.readInt();
			int casos = 0;

			do
			{
				System.out.println("Case #"+casos);
				casos++;
				// Cada iteracion se crea un grafo diferente para cada caso
				gd = new Digrafo();

				gd.cargarGrafo(cubos,in);

				listadeVertices = gd.vertices();
				// Aplicamos bellman por cada vertice
				for (Vertice v: listadeVertices){
					Bellman b = new Bellman(gd,v);
					// se procede a agarrar el camino mas largo
					caminosLargos.add(b.cam);
					numLados.add(b.ladosMaximoTemp);
					//b.toString(gd);
				}

				/*
				caminosMax = caminosLargos.toArray(caminosMax);
				ladosMax = numLados.toArray(ladosMax);
				// filtramos el camino mas largo definitivo Forma 1
				for (int i = 0;i < cantidadVertices ; i++ ) {
					 if (ladosMax[i] > temporalLados) {
					 	temporalLados = ladosMax[i];
					 	temporalPos = i;
					 }			
				}
				System.out.println("Camino mas largo " +caminosMax[temporalPos]+ " Numero de lados " + temporalLados);
				
				*/

				// forma 2

				int contador = 0;
				caminoFinal = "";
				for (int i: numLados) 
				{
					
					if (i > temporalLados) 
					{
					 	temporalLados = i;
					 	temporalPos = contador;
					 	caminoFinal = caminosLargos.get(contador);
					}	
					contador = contador + 1;
				}

				//System.out.println("Camino mas largo " +caminoFinal+ " Numero de lados " + temporalLados);
						
				//System.out.println(cubos);

				String[] output = caminoFinal.split("->");
				System.out.println(output.length);

				for( int i = output.length; i != 0 ; i-- )
				{
					System.out.println(output[i-1]);
				}

				cubos = in.readInt();

			}while(cubos != 0); // cambios entre casos de prueba


	}
}