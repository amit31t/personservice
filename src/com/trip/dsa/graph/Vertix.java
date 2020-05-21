package com.trip.dsa.graph;

public class Vertix 
{
	String name;
	AdjacencyList adjList;
	public Vertix(String name, AdjacencyList list) 
	{
		this.name = name;
		this.adjList = list;
	}
}
