import java.util.*;

public class AllDepthFirstSearch2{


	public AllDepthFirstSearch2(Digrafo G){
		dfs(G);
		static int time;
		static int[] d = new int[G.numeroDeVertices()];
		static int[] f = new int[G.numeroDeVertices()];
		//0: blanco  1: gris  2: negro
		static int[] color;
		static int[] pi = new int[G.numeroDeVertices()];
	}

	private void dfs(Digrafo G){

		for (int i = 0; i < G.V(); i++){
			color[i] = 0;
			pi[i] = null;

		}

		for (int i = 0; i < G.V(); i++){
			if (color[i] == 0){
				dfs_visit(i);
			}
		}

	}

	private void dfs_visit(Digrafo G, Vertice v){
		time++;
		d[v] = time;
		color[v] = 1;
		for(int i : adj[v]){
			if (color[i] == 0){
				pi[i] = v;
				dfs_visit(i);
			}

		}
		color[v] = 2;
		time++;
		f[v] = time;
	}


}