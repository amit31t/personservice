package com.trip.program.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Given a Weighted Directed Graph and a destination vertex in the graph, 
 * find the shortest distance from all vertex to the destination vertex.
 * 
 */
public class Prob01_ShortestPathsFromAllVsToDestVertex 
{
	public static void main(String[] args) 
	{
		int vertex = 4;
		ArrayList<WGNode> adjList = new ArrayList<WGNode>();
		for(int i=0; i<vertex; i++)
			adjList.add(new WGNode("V"+i));
		addEdgeinReverseOrder(adjList, 0, 1, 2);
		addEdgeinReverseOrder(adjList, 0, 2, 5);
		addEdgeinReverseOrder(adjList, 0, 3, 7);
		addEdgeinReverseOrder(adjList, 1, 3, 1);
		addEdgeinReverseOrder(adjList, 2, 1, 2);
		addEdgeinReverseOrder(adjList, 2, 3, 3);
		
		shortestPathsFromAllVsToDestVertex(adjList, adjList.get(3));

	}
	//Soln - reverse all the edges in directed graph and then apply SSSP algo.
	//It will give same result for common destination also
	private static void shortestPathsFromAllVsToDestVertex(ArrayList<WGNode> adjList, WGNode source) 
	{
		//apply Dijistra for SSSP
		PriorityQueue<WGNode> minHeap = new PriorityQueue<WGNode>();
		source.setDistance(0);
		minHeap.addAll(adjList);
		
		while(!minHeap.isEmpty())
		{
			WGNode currentNode = minHeap.poll();
			
			ArrayList<WGNode> neighbours = currentNode.getNeighbours();
			for(WGNode neighbour : neighbours)
			{
				if(minHeap.contains(neighbour))
				{
					int newDistance = currentNode.getDistance() + currentNode.getWeightMap().get(neighbour);
					if(newDistance < neighbour.getDistance())
					{
						neighbour.setDistance(newDistance);
						neighbour.setParentNode(currentNode);
						//refresh min heap
						minHeap.remove(neighbour);
						minHeap.add(neighbour);
						
					}
				}
			}
		}
		for(WGNode node : adjList)
		{
			if(node != source)
			{
				System.out.println(" Shortest distance from "+node.getName() + " to "+source.getName() +" = "+node.getDistance());
			}
		}
	}
	
	private static void addEdgeinReverseOrder(ArrayList<WGNode> adjList, int u, int v, int d) 
	{
		WGNode g1 = adjList.get(u);
		WGNode g2 = adjList.get(v);
		g2.getNeighbours().add(g1);
		g2.getWeightMap().put(g1, d);
	}
	

}
