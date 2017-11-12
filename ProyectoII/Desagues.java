public class Desagues{

	public static void main(String [] args) {

		String input_txt = args[0];

		Digrafo gd = new Digrafo();

		gd.cargarGrafo(input_txt);
		gd.toString();


	}
}
