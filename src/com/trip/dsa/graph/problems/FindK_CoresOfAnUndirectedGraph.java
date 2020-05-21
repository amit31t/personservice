package com.trip.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * The standard algorithm to find a k-core graph is to remove all the vertices that have
 * degree less than- ‘K’ from the input graph. We must be careful that removing a vertex 
 * reduces the degree of all the vertices adjacent to it, hence the degree of adjacent 
 * vertices can also drop below-‘K’. And thus, we may have to remove those vertices also. 
 * This process may/may not go until there are no vertices left in the graph.
 */
public class FindK_CoresOfAnUndirectedGraph 
{
	int vertices;
	ArrayList<Integer> [] adjList;
	
	@SuppressWarnings("unchecked")
	public FindK_CoresOfAnUndirectedGraph(int v) 
	{
		this.vertices = v;
		adjList = new ArrayList[v];
		initGraph();
	}
	
	private void initGraph() 
	{
		for(int i =0 ; i<vertices; i++)
		{
			adjList[i] = new ArrayList<Integer>();
		}	
	}
	//undirected graph
	public void addEdge(int u, int v)
	{
		adjList[u].add(v);
		adjList[v].add(u);
	}
	
	public void find_K_Cores(int k)
	{
		boolean [] visited = new boolean [vertices];
		int [] vDegree = new int [vertices];
		//0 update all vertices degrees
		for(int i=0; i<vertices; i++)
		{
			vDegree[i] = adjList[i].size();
		}
		//1. run DFS
		for(int i=0; i<vertices; i++)
		{
			DFSUtil(i, k, visited, vDegree);
		}
		//2. check the adjList length for vertix if less than k then delete the vertix
		//3. print remaing graph
		printKCoresgraph(vDegree, k);
	}
	private boolean DFSUtil(int s, int k, boolean[] visited, int[] vDegree) 
	{
		visited[s] = true;

		for(int adj : adjList[s])
		{
			if(vDegree[s] < k) // degree of s is less than k, then degree of adjacent must be reduced 
				vDegree[adj]--;
			
			if(!visited[adj]) // If adjacent is not processed, process it
			{
				boolean isDegreeLessK = DFSUtil(adj, k, visited, vDegree);
				//If degree of adjacent after processing becomes less than k, then reduce degree of s also. 
				if(isDegreeLessK)
					vDegree[adj]--;
			}
		}
		return (vDegree[s] < k);
	}
	
	private void printKCoresgraph(int[] vDegree, int k) 
	{
		for(int i =0; i<vertices; i++)
		{
			if(vDegree[i] >= k)
			{
				System.out.print("Vertix "+i);
				for(int adj : adjList[i])
				{
					if(vDegree[adj] >= k)
						System.out.print( " -> "+adj);
				}
				System.out.println();
			}
		}
	}
	public static void main(String[] args) 
	{
		// Create a graph given in the above diagram 
        int k = 3; 
        FindK_CoresOfAnUndirectedGraph g1 = new FindK_CoresOfAnUndirectedGraph(9); 
        g1.addEdge(0, 1); 
        g1.addEdge(0, 2); 
        g1.addEdge(1, 2); 
        g1.addEdge(1, 5); 
        g1.addEdge(2, 3); 
        g1.addEdge(2, 4); 
        g1.addEdge(2, 5); 
        g1.addEdge(2, 6); 
        g1.addEdge(3, 4); 
        g1.addEdge(3, 6); 
        g1.addEdge(3, 7); 
        g1.addEdge(4, 6); 
        g1.addEdge(4, 7); 
        g1.addEdge(5, 6); 
        g1.addEdge(5, 8); 
        g1.addEdge(6, 7); 
        g1.addEdge(6, 8);
        
        g1.find_K_Cores(k); 

	}

}
