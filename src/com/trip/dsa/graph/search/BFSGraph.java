package com.trip.dsa.graph.search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//Java program to print BFS traversal from a given source vertex. 
//BFS(int s) traverses vertices reachable from s. 
// assume all vertices are connected
public class BFSGraph {

	public static void main(String[] args) 
	{
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 0);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		
		graph.BFS(1);
	}
}

/*
 * This class represents a directed graph using adjacency list representation 
 * 
 */
class Graph
{
	private int vertices;
	private LinkedList<Integer> adj []; //Adjacency Lists 
	
	public Graph(int v)
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
	
	public void BFS(int s)
	{
		// Mark all the vertices as not visited(By default set as false) 
		boolean [] vistied = new boolean[vertices];
		
		// Create a queue for BFS 
		Queue<Integer> queue = new LinkedList<>();
		
		// Mark the current node as visited and enqueue it 
		vistied[s] = true;
		queue.add(s);
		
		while(queue.size() != 0)
		{
			// Dequeue a vertex from queue and print it 
			int p = queue.poll();
			System.out.print(p+ " ");
			
			// Get all adjacent vertices of the dequeued vertex s If a adjacent
            // has not been visited, then mark it visited and enqueue it 
			Iterator<Integer> adjVertices = adj[p].listIterator();
			while(adjVertices.hasNext())
			{
				int adjVertix = adjVertices.next();
				if(!vistied[adjVertix])
				{
					vistied[adjVertix] = true;
					queue.add(adjVertix);
				}
			}
		}
	}	
}