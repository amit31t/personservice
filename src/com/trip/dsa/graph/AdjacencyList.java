package com.trip.dsa.graph;

public class AdjacencyList 
{
	int vertixNum;
	AdjacencyList next;
	
	public AdjacencyList(int vNum, AdjacencyList list)
	{
		this.vertixNum = vNum;
		next = list;
	}
}
