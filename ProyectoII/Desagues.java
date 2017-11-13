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
		System.out.println("------------------------------------------");
		//System.out.println(gd.toString());

		tarjan x = new tarjan(gd);
		List<List<Vertice>> conjunto;
		conjunto = x.getComponentes();
		Stack<Vertice> charco = new Stack<Vertice>();

		for(List<Vertice> element : conjunto)
		{
			System.out.println("Componente:");
			System.out.println(element);
			for(Vertice s : element)
			{
   				//Si el vertice pertece a un borde descartamos la componente conexa 
   				if(s.esquina == true) 
   				{
   					System.out.println("Nodo esquina: " + s);
   					break;
   				}
   				//Caso contrario
   				else
   				{

   					System.out.println("Nodo size: " + s.getListaDeSucesores().size());
   					boolean candidato = true;
   					for(Vertice d : s.getListaDeSucesores())
   					{
   						if(d.getPeso() < s.getPeso())
   						{
   							candidato = false;
   							break;
   						}
   					}
   					if(candidato)
   					{
   						//Nodo es un charco
   						System.out.println("Nodo charco: " + s);
   						charco.push(s);
   					}
   				}
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
			Vertice q = charco.pop();
			String id = q.getId();
			String[] result = id.split("-");
			int coordX = Integer.valueOf(result[0]);
			int coordY = Integer.valueOf(result[1]);
			matriz[coordX][coordY] = "x";
			//System.out.println("x: " + coordX + coordY);
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
