package com.trip.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a directed graph, find out if a vertex v is reachable from 
 * another vertex u for all vertex pairs (u, v) in the given graph. 
 * Here reachable mean that there is a path from vertex u to v. 
 * The reach-ability matrix is called transitive closure of a graph.
 * 
 * This is the solution bases on BFS for all the vertices, when visit any vertex then set 1 into transitive clousure matrix
 */
public class TransitiveClosureOfAGraph 
{
	int vertices;
	ArrayList<Integer> [] adjList;
	int[][] tc;
	
	@SuppressWarnings("unchecked")
	public TransitiveClosureOfAGraph(int v) 
	{
		this.vertices = v;
		adjList = new ArrayList[v];
		initGraph();
	}
	
	private void initGraph() 
	{
		this.tc = new int[this.vertices][this.vertices];
		for(int i =0 ; i<vertices; i++)
		{
			adjList[i] = new ArrayList<Integer>();
			for(int j=0; j< vertices; j++)
				tc[i][j] =0;
		}	
	}
	//directed graph
	public void addEdge(int u, int v)
	{
		adjList[u].add(v);
	}
	
	//Based on BFS for all the node
	public void transitiveClousure()
	{
		for(int i =0; i<vertices; i++)
		{
			runBFSUtil(i);
		}
		
		//printing Transitive Closure Matrix
		System.out.println("Transitive Closure Matrix - ");
		for(int i =0;i<vertices; i++)
		{
			System.out.println( Arrays.toString(tc[i]));
		}
		
	}

	private void runBFSUtil(int s )
	{
		tc[s][s] = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		while(!queue.isEmpty())
		{
			int v1 = queue.poll();
			for(int adj : adjList[v1])
			{
				if(tc[s][adj] == 0)
				{
					queue.add(adj);
					tc[s][adj] =1;
				}
			}
		}
		
	}

	public static void main(String[] args) 
	{
		TransitiveClosureOfAGraph tc = new TransitiveClosureOfAGraph(4);
		
		tc.addEdge(0, 1); tc.addEdge(0, 2);
		tc.addEdge(1, 2); //tc.addEdge(0, 1);
		tc.addEdge(2, 0); tc.addEdge(2, 3);
		//tc.addEdge(0, 1);
		
		tc.transitiveClousure();
	}

}
