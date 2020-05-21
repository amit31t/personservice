package com.trip.dsa.graph.scc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuSSCAlgo 
{
	public static void main(String[] args)
	{
		//int[][] edges ={ {1,0}, {2,1}, {0, 2}, {3,0}, {3,4}};
		//int[][] edges ={{0,3}, {1,0}, {2,1}, {3,2}, {4,2}, {4,6}, {5,4}, {6,5},{6,7}, {8,7}};
		int[][] edges ={ {0,1}, {1, 2}, {2, 3}, {3,0}, {2,4}, {4, 2}};
		int v =5;
		ArrayList<Integer> [] adjList = new ArrayList[v];
		for(int i =0; i< v; i++)
			adjList[i] = new ArrayList<Integer>();
		
		for(int i =0; i<edges.length; i++)
		{
			adjList[edges[i][0]].add(edges[i][1]);
		}

		//Kosaraju's algo
		printSCCs(adjList);	
		
		//check if given graph is stongly connected or not by using kosaraju's algo
		boolean isSC = isGraphStronglyConnected(adjList);
		System.out.println("is Graph  strongly connected - "+isSC);
	}
	/*
	 * Following is Kosaraju’s DFS based simple algorithm that does two DFS traversals of graph:
	 * 1) Initialize all vertices as not visited.
	 * 2) Do a DFS traversal of graph starting from any arbitrary vertex v. If DFS traversal doesn’t visit all vertices, then return false.
	 * 3) Reverse all arcs (or find transpose or reverse of graph)
	 * 4) Mark all vertices as not-visited in reversed graph.
	 * 5) Do a DFS traversal of reversed graph starting from same vertex v (Same as step 2). 
	 * If DFS traversal doesn’t visit all vertices, then return false. Otherwise return true.
	 */
	private static boolean isGraphStronglyConnected(ArrayList<Integer>[] adjList)
	{
		boolean[] visited = new boolean[adjList.length];
		DFSFirst(0, null, visited, adjList);
		//If DFS traversal doesn’t visit all vertices, then return false
		for(boolean visit : visited)
		{
			if(!visit) return false;	
		}
		
		ArrayList<Integer>[] graphT = getTransPose(adjList);
		Arrays.fill(visited, false);
		DFSFirst(0, null, visited, graphT);
		
		for(boolean visit : visited)
		{
			if(!visit) return false;	
		}
		return true;
	}
	//Steps for Kosaraju's algo
	//1. create an empty stack of size v
	//2. Do DFS for all vertices and push into stack after all calling DFS for all adjacent vetices
	//3. do transpose of the given graph(reverse all the edges to get transpose)
	//4. pop all the vertices one by one and do DFS again until queue is empty, and print SCCs graphs
	private static void printSCCs(ArrayList<Integer>[] adjList) 
	{
		//1
		Stack<Integer> stack = new Stack<Integer>();
		
		//2
		boolean[] visited = new boolean[adjList.length];
		Arrays.fill(visited, false);
		for(int i=0; i<adjList.length; i++)
		{
			if(visited[i] == false)
				DFSFirst(i, stack, visited, adjList);
		}
		
		//3
		ArrayList<Integer>[] transposeGraph = getTransPose(adjList);
		//4
		Arrays.fill(visited, false);
		while(!stack.isEmpty())
		{
			int vertex = stack.pop();
			if(!visited[vertex])
			{
				DFSSecond(vertex, transposeGraph, visited);
				System.out.println();
			}
		}
	}

	private static void DFSFirst(int u, Stack<Integer> stack, boolean[] visited, ArrayList<Integer>[] adjList) 
	{
		visited[u]= true;
		for(Integer adjVertex : adjList[u])
		{
			if(!visited[adjVertex])
				DFSFirst(adjVertex, stack, visited, adjList);
		}
		if(stack != null)
			stack.push(u);
	}

	private static ArrayList<Integer>[] getTransPose(ArrayList<Integer>[] adjList) 
	{
		ArrayList<Integer>[] tranposeAdjList = new ArrayList[adjList.length];
		for(int i=0; i<adjList.length; i++)
			tranposeAdjList[i] = new ArrayList<Integer>();
		
		for(int i =0; i<tranposeAdjList.length; i++)
		{
			//Iterator<Integer> itr = tranposeAdjList[i].iterator();
			for(Integer v : adjList[i])
				tranposeAdjList[v].add(i);
		}
		return tranposeAdjList;
	}
	
	private static void DFSSecond(int u, ArrayList<Integer>[] transposeGraph, boolean[] visited) 
	{
		visited[u]= true;
		System.out.print(" "+u);
		for(Integer adjVertex : transposeGraph[u])
		{
			if(!visited[adjVertex])
				DFSSecond(adjVertex, transposeGraph, visited);
		}		
	}
}
