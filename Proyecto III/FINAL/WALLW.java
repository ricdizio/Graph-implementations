/**********************************************************************************************************
 *    Compilacion:  javac WALLW.java
 *    Ejecucion:    java  WALLW <casos>
 *    Dependencias In.java, Out.java,Lado.java, Arco.java, Grafo.java, Digrafo.java, NgBellman.java, BG.java
 *    
 *    El makefile compila todo el proyecto siguiendo el orden de dependencias
 *    
 *    ProyectoIII
 *
 *    @author  Ricardo Di Zio 11-11274
 *    @author  Fabio Suarez   12-10578
 *    @version 1.0
 *    @since   2017-6-12
 *
 * 
 *************************************************************************************************************/

import java.util.*;
public class WALLW {
	public static void main(String[] args){
		In in = new In(args[0]);
		//Numero de cubos
		int numCubos = in.readInt();
		int casos = 1;
		do{
			System.out.println("Case #"+casos);
			casos++;
			//Digrafo
			Digraph DG = new Digraph(numCubos*6);
			int[][] tabla = new int[numCubos][6];
			//Inicializacion
			for(int i = 0;i< numCubos;i++){
				for(int j = 0; j < 6;j++){
					int material = in.readInt();
					tabla[i][j] = material;
				}
			}

			//cubo -- lado
			int cubo = numCubos-1;
			//cubo anterior -- j
			int cuboAnt = cubo-1;
			while (cubo != 0){
				while (cuboAnt > -1){
					for (int lado = 0; lado < 6; lado++){
						for (int j = 0; j < 6; j++){
							if (tabla[cubo][lado] == tabla[cuboAnt][j]){
								int v = formula(cubo, lado);
								if (j%2 == 0){
									int w = formula(cuboAnt, j+1);
									DG.addEdge(v, w);
								}
								else {
									int w = formula(cuboAnt, j-1);
									DG.addEdge(v, w);						
								}
							}
						}
					}
					cuboAnt--;
				}
				cubo--;
				cuboAnt = cubo-1;
			}

			//Resultado Digrafo
			//StdOut.print(DG);

			ArrayList<Integer> salida = new ArrayList<Integer>();
			for (int i = DG.V()-1; i >= 0; i--){
				Bag<Integer> bag = DG.Bag(i);
				if (!bag.isEmpty()){
					NegBellman dij = new NegBellman(DG, i);
					int[] Costo = dij.Costo();
					int idx = 0;
					for (int j = 0; j < DG.V(); j++){
						if (Costo[j] > Costo[idx]){
							idx = j;
						}
					}
					//StdOut.print("Costo:"+Costo[idx]+"\n");
					ArrayList<Integer> camino = reconstruir(dij, idx);
					if (salida.size() == 0){
						salida = camino;
					}
					else{
						if (camino.size() >= salida.size()){
							salida = camino;
						}
					}
				}
			}
			
			Impresion(salida);
			StdOut.println();
			numCubos = in.readInt();
		}while(numCubos != 0);

	}

	private static int formula(int i, int j){
		return (6*i + j);
	}
	private static int cubo(int x){
		int s = (x/6) + 1;
		return s;
	}
	private static String lado(int x){
		if (x%6 == 0){return "front";}
		else if (x%6 == 1){return "back";}
		else if (x%6 == 2){return "left";}
		else if (x%6 == 3){return "right";}
		else if (x%6 == 4){return "top";}
		else {return "bottom";}
	}
	public static ArrayList<Integer> reconstruir(NegBellman D, int idx){
		int[] pred = D.P();
		ArrayList<Integer> C = new ArrayList<Integer>();
		C.add(idx);
		while (pred[idx] != -10000000){
			idx = pred[idx];
			C.add(idx);
		}
		return C;
	}
	public static void Impresion(ArrayList<Integer> Array){
		System.out.println(Array.size());
		for (int i = 0; i < Array.size() ; i++){
			StdOut.print(cubo(Array.get(i)) + " " + lado(Array.get(i)) + "\n");
		}
	}
}
