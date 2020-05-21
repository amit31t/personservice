package com.trip.dsa.graph;

import java.util.ArrayList;

/*
 * Adjacency List is the graph representation
 * G(V, E)  -> V is a array of vertices, and E represents edges between vertices
 * 
 *  Adjacency Edge List for vertix - A
head -> B -> C -> E
 Adjacency Edge List for vertix - B
head -> D -> A
 Adjacency Edge List for vertix - C
head -> E
 Adjacency Edge List for vertix - D
head -> B
 Adjacency Edge List for vertix - E
head -> C
*/
public class AdjacencyListGraph 
{
	private int num_of_vertices;
	//private ArrayList<ArrayList<String>> adjList;
	private ArrayList<Vertix1> adjList;
	
	public AdjacencyListGraph(int n)
	{
		this.num_of_vertices = n;
		adjList = new ArrayList<>(n);
	}
	
	public Vertix1 addVertix(String s)
	{
		Vertix1 v = new Vertix1(s);
		adjList.add(v);
		return v;
	}
	
	public void addEdge(Vertix1 v1, Vertix1 v2)
	{
		if(adjList.contains(v1))
		{
			v1.getAdjList().add(v2.getValue());
		}
	}
	
	public void printAdjacencyListGraph()
	{
		for(Vertix1 v : adjList)
		{
			System.out.println("\n Adjacency Edge List for vertix - "+v.getValue());
			System.out.print("head");
			ArrayList<String> list = v.getAdjList();
			for(String s : list)
			{
				System.out.print(" -> "+s);
			}
		}
	}
}

class Vertix1
{
	String value;
	ArrayList<String> adjList;
	
	public Vertix1(String s)
	{
		this.value = s;
		adjList = new ArrayList<String>();
	}

	public String getValue() {
		return value;
	}

	public ArrayList<String> getAdjList() {
		return adjList;
	}
	
	
}