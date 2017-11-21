import java.lang.*;
import java.util.*;


public class Recorador
{
	public static void main(String [] args) 
	{
		Long timeStart;
		Long timeEnd;
		Long time;

		String input_txt = args[0];

		// Vertice de partida con id cocina
		String cocina = new String (args[1]);

		GrafoNoDirigido gnd = new GrafoNoDirigido();

		gnd.cargarGrafo(input_txt);

		AEstrella costo;

		for( Vertice c :gnd.vertices())
		{
			timeStart = System.currentTimeMillis();

			System.out.println(" \n"+"De cocina a la mesa "+ c.getId() + " \n");
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
			System.out.println("Tiempo de corrida: " + time + " seg");	
		}
	}
}