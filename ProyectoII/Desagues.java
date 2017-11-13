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
		System.out.println(gd.toString());

		tarjan x = new tarjan(gd);
		List<HashSet> conjunto;
		conjunto = x.getComponentes();
		Stack<Vertice> charco = new Stack<Vertice>();

		for(HashSet element : conjunto)
		{
			System.out.println("Componente:");
			System.out.println(element.getClass().getName());

 			// Creamos iterador
   			//Iterator iterator = element.iterator(); 
      
   			// Sacamos los vertices
   			Vertice n;
   			Object[] array = element.toArray();

   			for (int i = 0; i<array.length ; i++) 
   			{
   				//System.out.println(array[i].getListaSucesores());
   				
   				//System.out.println(array[i].getClass().getName());
   				//n = array[i]; 
   				//Si el vertice pertece a un borde descartamos la componente conexa 
   				if(array[i].esquina == true) break;
   				//Caso contrario
   				else
   				{
   					if(array[i].getListaSucesores().size() == 0)
   					{
   						//Nodo es un charco
   						charco.push(array[i]);
   					}
   				}
   			}
		}
	}
}
