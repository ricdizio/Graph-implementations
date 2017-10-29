
public class test
{
	public static void main(String[] args) 
	{
		String s = "(5(4(11(7()())(2()()))())(8(13()())(4()(1()()))))";
		String t[] = s.split("");
		
		Digrafo g = new Digrafo();
		g.cargarGrafo(t,-1,0);
		System.out.println("Aplicamos DFS:");
	}
}	 