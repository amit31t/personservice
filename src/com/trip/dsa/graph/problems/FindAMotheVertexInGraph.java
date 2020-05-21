package com.trip.dsa.graph.problems;

import java.util.Arrays;
import java.util.Iterator;

public class FindAMotheVertexInGraph {

	public static void main(String[] args)
	{
		int vertices = 4;
		Graph graph = new Graph(vertices);
/*		graph.addEdge(0, 1); 
		graph.addEdge(0, 2); 
		graph.addEdge(1, 3); 
		graph.addEdge(4, 1); 
		graph.addEdge(6, 4); 
		graph.addEdge(5, 6); 
		graph.addEdge(5, 2); 
		graph.addEdge(6, 0); */
		graph.addEdge(0, 1); graph.addEdge(0, 2); graph.addEdge(0, 3);
		graph.addEdge(1, 2); graph.addEdge(1, 3);// graph.addEdge(2, 0);
		graph.addEdge(3, 2);
		
		findAMotherVertix(graph, vertices);
	}

	private static void findAMotherVertix(Graph graph, int vertices) 
	{
		boolean [] visited = new boolean[vertices];
		int v = 0;
		for(int i=0; i<vertices; i++)
		{
			if(!visited[i])
			{
				DFSUtil(i, graph, visited);
				v=i;
			}
		}
		System.out.println("\nlast DFS vertix "+v);
		// If there exist mother vertex (or vetices) in given 
	    // graph, then v must be one (or one of them) 
	  
	    // Now check if v is actually a mother vertex (or graph 
	    // has a mother vertex).  We basically check if every vertex 
	    // is reachable from v or not. 
	  
	    // Reset all values in visited[] as false and do  
	    // DFS beginning from v to check if all vertices are 
	    // reachable from it or not. 
		Arrays.fill(visited, false);
		DFSUtil(v, graph, visited);
		for(int i=0; i<vertices; i++)
		{
			if(!visited[i])
				System.out.println("\nno mother vitix present - "+-1);
		}
		System.out.println("\nmother vitix present and vertix is "+v);
	}

	private static void DFSUtil(int v, Graph graph, boolean[] visited) 
	{
		visited[v] = true;
		System.out.print(" "+v);
		
		Iterator<Integer> itr = graph.adjList[v].listIterator();
		while(itr.hasNext())
		{
			int n = itr.next();
			if(!visited[n])
			{
				DFSUtil(n, graph, visited);
			}
		}
	}

}
