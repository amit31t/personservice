package com.trip.dsa.graph.search;

import java.util.ArrayList;

import com.trip.dsa.graph.nodes.GraphNode;

public class TestGraphs {

	public static void main(String[] args) 
	{
		ArrayList<GraphNode> list = new ArrayList<GraphNode>();
		for(int i=1; i<=5; i++)
			list.add(new GraphNode("V"+i));
		System.out.println(list);
		BFSByAdjacencyList graph = new BFSByAdjacencyList(list);
		graph.addUndirectedEdges(1, 2);
		graph.addUndirectedEdges(1, 3);
		graph.addUndirectedEdges(1, 5);
		graph.addUndirectedEdges(2, 3);
		graph.addUndirectedEdges(3, 4);
		graph.addUndirectedEdges(4, 5);
		
		//run BFS
		graph.BFS();
	}

}
