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



public class test
{
	
	public static void main(String [] args) 
	{
		List<Vertice> listadeVertices = new ArrayList<Vertice>();

		// Carga

		In in;
		Digrafo gd;
		int cubos;
		String input_txt = args[0];

		try
		{

			in = new In(input_txt);

			cubos = in.readInt();

			do
			{
				// Cada iteracion se crea un grafo diferente para cada caso
				gd = new Digrafo();

				gd.cargarGrafo(cubos,in);

				listadeVertices = gd.vertices();
				for (Vertice v: listadeVertices){
					Bellman b = new Bellman(gd,v);
					b.toString(gd);
				}

				cubos = in.readInt();

			}while(cubos != 0); // cambios entre casos de prueba

		}

		catch(Exception e)
		{
            System.out.println("No se pudo cargar el archivo");
        }
	}
}
