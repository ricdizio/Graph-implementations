/*
*
*
*
*
*/

import java.util.*;

public class Kruskal
{
	private int rep[], rank[];
	private ArrayList<Edge> edges;
	private ArrayList<Edge> MST;
	private double weight;

	private int find(int u)
	{
		if(rep[u] == u ) return u;
		return rep[u] = find(rep[u]);
	}

	private void union(int u, int v)
	{
		u = find(u);
		v = find(v);
		if(rank[u]>rank[v])
		{
			rep[v] = u;
		}
		else
		{
			rep[u] = v;
			if(rank[u]==rank[v])
			{
				rank[v]++;
			}
		}
	}



	public Kruskal(EdgeWeightedGraph G)
	{
		edges = new ArrayList<Edge>(G.getEdges());
		MST = new ArrayList<Edge>();
		Collections.sort(edges);
		rep = new int[G.V()];
		rank = new int [G.V()];
		for(int i = 0 ; i<G.V();i++)
		{
			rep[i] = i;
			rank[i] = 0;
		}
		weight = 0;
		int uniones = 0;
		for(Edge e: edges)
		{
			int u = e.either(),v=e.other(e.either());
			double c = e.weight();
			if(find(u) != find(v))
			{
				uniones++;
				union(u,v);
				weight += c;
				MST.add(e);
			}
		}
		if(uniones != G.V()-1)
		{
			MST = null;
			weight = 0;
		}
	}


	public ArrayList<Edge> getEdgesMST()
	{
		if(MST == null)
		{
			return null;
		}
		return new ArrayList<Edge>(MST);
	}

	public double weight()
	{
		return weight;
	}

}
