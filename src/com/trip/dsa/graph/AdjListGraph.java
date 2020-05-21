package com.trip.dsa.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdjListGraph 
{
	Vertix[] adjLists;
	public AdjListGraph(String file) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(file));
		
		int n = sc.nextInt();
		adjLists = new Vertix[n];
		
		//read and add all the vertices from file
		for(int i =0; i<n; i++)
		{
			adjLists[i] = new Vertix(sc.next(), null);
		}
		
		//add edges in adjacency list of the vertix
		while(sc.hasNext())
		{
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			
			adjLists[v1].adjList = new AdjacencyList(v2, adjLists[v1].adjList);
			adjLists[v2].adjList = new AdjacencyList(v1, adjLists[v2].adjList);//for undirected Graph
		}
		sc.close();
	}
	
	private int indexForName(String name)
	{
		for(int v =0; v<adjLists.length; v++)
		{
			if(adjLists[v].name.equals(name))
				return v;
		}
		return -1;
	}
	
	public void printGraph()
	{
		System.out.println();
		for(int i=0; i<adjLists.length; i++)
		{
			System.out.print("\n"+adjLists[i].name +" ");
			for(AdjacencyList list = adjLists[i].adjList; list != null; list = list.next)
			{
				System.out.print("  -->  "+adjLists[list.vertixNum].name);
			}
		}
	}
	
	public boolean isVertixConnected(Vertix v1, Vertix v2)
	{
		int v1_index = indexForName(v1.name);
		for(AdjacencyList list = adjLists[v1_index].adjList; list!=null; list = list.next)
		{
			if(adjLists[list.vertixNum].name.equals(v2.name))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		System.out.print("Enter file name to process the graph: ");
		Scanner sc = new Scanner(System.in);
		String file = sc.next();
		AdjListGraph graph = new AdjListGraph(file);
		graph.printGraph();
		sc.close();
		Vertix v1 = new Vertix("sam", null);
		Vertix v2 = new Vertix("hrishi", null);
		System.out.println("\n\nis vertix connected " +graph.isVertixConnected(v1, v2));
	}

}
