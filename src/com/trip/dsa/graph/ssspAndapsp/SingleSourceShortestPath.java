package com.trip.dsa.graph.ssspAndapsp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.trip.dsa.graph.nodes.GraphNode;

public class SingleSourceShortestPath {

	public static void main(String[] args) 
	{
		ArrayList<GraphNode> list = new ArrayList<GraphNode>();
		for(int i=1; i<=5; i++)
			list.add(new GraphNode("V"+i));
		System.out.println(list);
		
		addUndirectedEdges(list,1, 2);
		addUndirectedEdges(list, 1, 3);
		addUndirectedEdges(list,1, 5);
		addUndirectedEdges(list,2, 3);
		addUndirectedEdges(list,3, 4);
		addUndirectedEdges(list,4, 5);
		
		GraphNode sourceNode= list.get(0);
		findShortestPath(sourceNode);
		
		//printPath(sourceNode);
	}

	private static void printPath(GraphNode node) 
	{
		if(node.getParent()!=null)
			printPath(node.getParent()); // recurseive call to all parents
		System.out.print(node+" ");	
	}

	private static void findShortestPath(GraphNode sourceNode) 
	{
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(sourceNode);
		while(!queue.isEmpty())
		{
			GraphNode currentNode = queue.poll();
			currentNode.setVisited(true);
			//print path node
			System.out.print(" Printing path for Node "+currentNode + " ");
			printPath(currentNode);
			System.out.println();
			ArrayList<GraphNode> adjacentVertices = currentNode.getNeighbours();
			for(GraphNode adjVertix : adjacentVertices)
			{
				if(!adjVertix.isVisited())
				{
					queue.add(adjVertix);
					adjVertix.setParent(currentNode);
					adjVertix.setVisited(true);
				}
			}
		}		
	}

	public static void addUndirectedEdges(ArrayList<GraphNode> nodeList, int v1, int v2)
	{
		GraphNode g1 = nodeList.get(v1-1);
		GraphNode g2 = nodeList.get(v2-1);
		g1.getNeighbours().add(g2);
		g2.getNeighbours().add(g1);
	}
}
