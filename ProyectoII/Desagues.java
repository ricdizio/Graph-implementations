import java.util.Stack;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

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

		for(HashSet element : conjunto)
		{
			System.out.println("Componente:");
			System.out.println(element);
			/*
			for(Vertice nodo : element)
			{
				System.out.print(nodo.getId() + " ");
			}
			*/

		}
	}
}
