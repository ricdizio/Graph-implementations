
public class test
{
	public static void main(String[] args) 
	{
		//Crea un arreglo de string tipo cadena de tamano 3
	  	cadena x = new cadena(3);
	  	//Agrega un elemento al arreglo
	  	x.agregar("r");
	  	//Agrega un elemento al arreglo
	  	x.agregar("f");
	  	//Imprime tamano actual
	  	System.out.println(x.getTam());
	  	//Imprime cadena
	  	x.toStringChain();
	  	//Borra por posicion
	  	x.deleteByPos(0);
	  	//Imprime cadena
	  	x.toStringChain();
	  	//Imprime tamano actual
	  	System.out.println(x.getTam());
	}
}	 