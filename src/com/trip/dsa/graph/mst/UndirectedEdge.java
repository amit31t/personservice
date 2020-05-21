package com.trip.dsa.graph.mst;

import com.trip.dsa.graph.nodes.WeightedGNode;

public class UndirectedEdge 
{
	WeightedGNode firstNode;
	WeightedGNode secondNode;
	int edgeWeight;
	
	public UndirectedEdge(WeightedGNode firstNode, WeightedGNode secondNode, int edgeWeight) 
	{
		this.firstNode = firstNode;
		this.secondNode = secondNode;
		this.edgeWeight = edgeWeight;
	}
	public WeightedGNode getFirstNode() 
	{
		return firstNode;
	}
	public WeightedGNode getSecondNode()
	{
		return secondNode;
	}
	public int getEdgeWeight()
	{
		return edgeWeight;
	}
	
	@Override
	public String toString() {
		return "Edge (" + firstNode + "," + secondNode + "), weight=" + edgeWeight + "]";
	}
}
