public class Ruta
{
  public static void main (String[] args)
  {
    In in = new In(args[0]);
    int nodos = in.readInt();
    int arcos = in.readInt();
    int valor;
    int[][] Alcanzables;
/*
    StdOut.println("Nodos: "+nodos);
    StdOut.println("Arcos: "+ arcos);
*/
    MatrizAdyacenciaDigrafo matrix = new MatrizAdyacenciaDigrafo(nodos);

    for (int i=0;i<arcos;i++) {
    	int nodoSalida = in.readInt();
    	int nodoLlegada = in.readInt();
    	//StdOut.print("\n"+nodoSalida +"  "+ nodoLlegada+"\n");
    	matrix.agregarArco(nodoSalida, nodoLlegada);
    }
    // creamos la matriz de alcanzabilidad con el nombre Alcanzables
	GraphAlgorithms royWarshall = new GraphAlgorithms();
    Alcanzables = royWarshall.Roy_Warshall(matrix);

    //Nodos de entrada por terminal
    int nodoS = Integer.parseInt(args[1]);
    int nodoL = Integer.parseInt(args[2]);

    boolean[] marcados;
    marcados = new boolean[matrix.V()];
    if (Alcanzables[nodoS][nodoL] == 0)
    {
        StdOut.print("No hay ruta entre los dos puntos");     
    }
        
    else 
    {
        int i = 0;
        marcados[nodoS] = false;
        //StdOut.print("Ruta: "+"\n");
        StdOut.print(nodoS+" ");
        while (true)
        {
            if(matrix.valor(nodoS,nodoL)==1){
                StdOut.print(nodoL);
                break;
            }
            else{
                //StdOut.println("valor nodoS: "+nodoS);
                //StdOut.println("valor i: "+i);
                if ((matrix.valor(nodoS, i) == 1) && (!marcados[i]))
                {
                    if(i!=0){marcados[i] = true;}
                    StdOut.print(i+" ");
                    nodoS = i;
                    i = 0;
                }
                else if (nodoS == nodoL)
                {
                    marcados[nodoL] = true;
                    break;
                }
                else
                {
                    i++;               
                }
            }
        }    
    }
    //StdOut.print("\n");
   }
}

