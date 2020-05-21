package com.trip.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Adjacency matrix is the graph representation
 * G(V, E)  -> V is a array of vertices, and E represents edges between vertices which is 
 * adjacency matrix of v * v
 * Vertics of Graph : 
 - 	A - B - C - D - E
	Vertices and Edges matrix : 
	   A  B  C  D  E
	A  0  1  1  0  1
	B  1  0  1  0  1
	C  1  1  0  1  0
	D  0  0  1  0  1
	E  1  1  0  1  0
 */
public class AdjacencyMatrixGraphR 
{
	private int num_of_vertices;
	
	//string array to store vertices
	private List<String> vertices= new ArrayList<>(num_of_vertices);
	
	//adjacency matrix to store edges b/w vertices it will store 1 if edge exist otherwise 0
	private int [][] edges;
	public AdjacencyMatrixGraphR(int n)
	{
		this.num_of_vertices = n;
		edges = new int[n][n];
		//initialize the edges with all 0
		for(int i =0; i<n-1; i++)
		{
			for(int j =0; j<n-1; j++)
			{
				edges[i][j] = 0;
			}
		}
	}
	
	public void addVertices(String ...vertix)
	{
		vertices = Arrays.asList(vertix);
	}
	
	public void addEdge(String vertix1, String vertix2)
	{
		if(vertices.contains(vertix1) && vertices.contains(vertix2))
		{
			int v1 = vertices.indexOf(vertix1);
			int v2 = vertices.indexOf(vertix2);
			edges[v1][v2] = 1;
			edges[v2][v1] = 1; //for undirectional graph we need to set from both the vertices
		}
	}
	
	public void printAdjacencyMatrixGraph()
	{
		System.out.println("Vertics of Graph : ");
		vertices.stream().forEach( s -> System.out.print(" - " +s));
		System.out.println();
		System.out.println("Vertices and Edges matrix : ");
		for(int i =0; i<edges.length; i++)
		{
			System.out.println();
			for(int j =0; j<edges.length; j++)
			{
				System.out.print("  "+edges[i][j]);
			}
		}
		
	}
}

