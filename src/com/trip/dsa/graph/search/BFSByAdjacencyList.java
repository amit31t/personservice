package com.trip.dsa.graph.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.trip.dsa.graph.nodes.GraphNode;

public class BFSByAdjacencyList 
{
	private ArrayList<GraphNode> nodeList;
	
	public BFSByAdjacencyList(ArrayList<GraphNode> list) 
	{
		nodeList = list;
	}
	//firat version - BFS only for connected undirected graphs
	public void BFS()
	{
		visitBFS(nodeList.get(0));
		
	}
	private void visitBFS(GraphNode graphNode) 
	{
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(graphNode);
		//graphNode.setVisited(true);
		
		while(!queue.isEmpty())
		{
			GraphNode currentNode = queue.poll();
			
			currentNode.setVisited(true);
			System.out.print(currentNode);
			
			ArrayList<GraphNode> neibghours = currentNode.getNeighbours();
			for(GraphNode node : neibghours)
			{
				if(!node.isVisited())
				{
					queue.add(node);
				}
			}			
		}
	}
	
	public void addUndirectedEdges(int v1, int v2)
	{
		GraphNode g1 = nodeList.get(v1-1);
		GraphNode g2 = nodeList.get(v2-1);
		g1.getNeighbours().add(g2);
		g2.getNeighbours().add(g1);
	}
}
