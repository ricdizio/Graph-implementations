// Laboratorio 9
// Ricardo Di Zio 11-11274
// Fabio Suarez   12-10578

import java.lang.*;
import java.util.*;


public class Redecorador
{
	public static void main(String [] args) 
	{
		// variables para calcular el tiempo de corrida por vertice de A Estrella
		double timeStart;
		double timeEnd;
		double time;

		// variables para calcular el tiempo total de corrida de A Estrella
		double timeStartAStar;
		double timeEndAStar;
		double timeAStar;

		// variables para calcular el tiempo total de corrida de Dijkstra
		double timeStartD;
		double timeEndD;
		double timeD;

		String input_txt = args[0];

		// Vertice de partida con id cocina
		String cocina = new String (args[1]);

		GrafoNoDirigido gnd = new GrafoNoDirigido();

		gnd.cargarGrafo(input_txt);

		AEstrella costo;

		// A Estrella
		timeStartAStar = System.currentTimeMillis();
		for( Vertice c :gnd.vertices())
		{
			timeStart = System.currentTimeMillis();

			System.out.println(" \n"+"De cocina al nodo "+ c.getId() + " \n");
			costo = new AEstrella(gnd,cocina,c.getId());
				//costo.printPath();
			System.out.println(costo.cantidadAbiertos);
			System.out.println(costo.cantidadCerrados);
			System.out.println(costo.cantidadNoVisitados);
			for(Stack<Vertice> u : costo.caminos)
			{	
				//System.out.println("Camino: ");
				while(!u.isEmpty())
				{	
					System.out.print(u.pop().getId() + " " );
				}
				System.out.println();
			}
			timeEnd = System.currentTimeMillis();
			time = (timeEnd - timeStart)/1000;
			System.out.println("Tiempo de corrida: " + time + " seg"+ " \n");	
		}
		timeEndAStar = System.currentTimeMillis();
		timeAStar = (timeEndAStar - timeStartAStar)/1000;

		// Dijkstra 
		timeStartD = System.currentTimeMillis();
		Dijkstra d = new Dijkstra(gnd,cocina);
		timeEndD = System.currentTimeMillis();

		timeD = (timeEndD - timeStartD)/1000;

		// Tiempo total de corrida de A Estrella y Dijkstra
		System.out.println("Tiempo total de corrida de A Estrella ");
		System.out.println(timeAStar + " seg" + " \n");

		System.out.println("Tiempo total de corrida de Dijkstra ");
		System.out.println(timeD + " seg"+ " \n");

		// Descomentando la linea 80 se pueden ver los caminos y los costos utilizando Dijkstra
		//d.toString(gnd);

	}
}