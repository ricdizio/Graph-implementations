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

		AEstrella costo = new AEstrella(gnd,cocina,"0");

		for( Vertice c :gnd.vertices())
		{
			if(c.getId().equals("3")) {System.out.println("llegada igual a 3 ");}

			if(!cocina.equals(c.getId()))
			{
				System.out.println("Nodo "+ c.getId() + " \n");
				costo = new AEstrella(gnd,cocina,c.getId());
				//costo.printPath();
				for(Stack<Vertice> u : costo.caminos)
				{
					System.out.println("Camino: ");
					while(!u.isEmpty())
					{
						System.out.print(u.pop().getId() + " " );
					}
					System.out.println();
				}
			}
		}
	}
}