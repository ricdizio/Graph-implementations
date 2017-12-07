/**********************************************************************************************************
 *    Compilacion:  javac NegBellman.java
 *    Ejecucion:    java  NegBellman
 *    Dependencias In.java,StdIn.java,StdOut.java, Bag.java, Stack.java, Digraph.java, NegBellman.java
 *    
 *    Bellman caminos maximo
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
public class NegBellman{
	private int[] C;
	private int[] P;
	public NegBellman(Digraph G, int s){
		//Inicializacion
		this.C = new int[G.V()];
		this.P = new int[G.V()];
		boolean[] marcado = new boolean[G.V()];
		int min = -10000000;
		for (int i = 0; i < G.V(); i++){
			C[i] = min;
			P[i] = min;
			marcado[i] = false;
		}
		C[s] = 0;

		//camino
		for (int v = 0; v < G.V(); v++){
			for (int w = 0; w < G.V(); w++){			
				for (int i : G.adj(w)){
					if (C[i] < C[w] + 1){
						C[i] = C[w] + 1;
						P[i] = w;
					}
				}
			}
		}
	}
	public int[] P(){return P;}

	public int[] Costo() {return C;}
}
