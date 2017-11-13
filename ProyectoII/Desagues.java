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
			//System.out.println(element.getClass().getName());
			for(Vertice s : element)
			{
   				//Si el vertice pertece a un borde descartamos la componente conexa 
   				if(s.esquina == true) break;
   				//Caso contrario
   				else
   				{
   					if(s.getListaDeSucesores().size() == 0)
   					{
   						//Nodo es un charco
   						charco.push(s);
   					}
   				}
			}
		}
	}
}
