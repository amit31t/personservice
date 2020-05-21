package com.trip.dsa.graph.search;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {

	public static void main(String[] args) 
	{
		GraphDFS graph = new GraphDFS(5);
/*		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 0);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		graph.addEdge(1, 3)*/;
		
		graph.addEdge(0, 1); graph.addEdge(0, 2); graph.addEdge(0, 3);
		graph.addEdge(1, 2); graph.addEdge(1, 3); graph.addEdge(2, 0);
		graph.addEdge(3, 2);
		
		graph.DFS(1);
	}
}
	/*
	 * This class represents a directed graph using adjacency list representation 
	 * 
	 */
	class GraphDFS
	{
		private int vertices;
		private LinkedList<Integer> adj []; //Adjacency Lists 
		
		public GraphDFS(int v)
		{
			this.vertices = v;
			adj = new LinkedList[v];
			for(int i =0; i<v; i++)
				adj[i] = new LinkedList<Integer>();
		}
		
		public void addEdge(int x, int y)
		{
			adj[x].add(y);
		}
		
		public void DFS(int s)
		{
			// Mark all the vertices as not visited(By default set as false) 
			boolean [] visited = new boolean[vertices];	
			DFSUtil(s, visited);
		}
		
		public void DFSUtil(int s, boolean[] visited)
		{
			// Mark the current node as visited and print it
			visited[s] = true;
			System.out.print(s +" ");
			
			// Recur for all the vertices adjacent to this vertex 
			Iterator<Integer> itr = adj[s].listIterator();
			while(itr.hasNext())
			{
				int n = itr.next();
				if(!visited[n])
				{
					DFSUtil(n, visited);
				}
			}
		}
}
