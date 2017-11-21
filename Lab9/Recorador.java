import java.lang.*;
import java.util.*;


public class Recorador
{
	public static void main(String [] args) 
	{
		String input_txt = args[0];

		// Vertice de partida con id cocina
		String cocina = new String (args[1]);

		GrafoNoDirigido gnd = new GrafoNoDirigido();

		gnd.cargarGrafo(input_txt);

		AEstrella costo;

		for( Vertice c :gnd.vertices())
		{
			/*if(!cocina.equals(c.getId()))
			{
				System.out.println(" \n"+"Llegada al nodo "+ c.getId() + " \n");
				costo = new AEstrella(gnd,cocina,c.getId());
				//costo.printPath();
				System.out.println(costo.cantidadAbiertos);
				System.out.println(costo.cantidadCerrados);
				for(Stack<Vertice> u : costo.caminos)
				{	
					//System.out.println("Camino: ");
					while(!u.isEmpty())
					{	
						System.out.print(u.pop().getId() + " " );
					}
					System.out.println();
				}
			}*/

			System.out.println(" \n"+"Llegada al nodo "+ c.getId() + " \n");
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
				
		}
	}
}