package com.trip.dsa.graph.search;

import java.util.ArrayList;
import java.util.Stack;

import com.trip.dsa.graph.nodes.GraphNode;

public class TopologicalSort {

	public static void main(String[] args) 
	{
		int vertices = 8;
		String [] arr = {"A", "B", "C", "D", "E", "F", "G", "H"};
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>(vertices);
		for(int i=1; i<=vertices; i++)
			nodeList.add(new GraphNode(arr[i-1]));
		System.out.println(nodeList);
		
		addDirectedEdges(nodeList, 1 , 3);
		addDirectedEdges(nodeList, 2 , 3);
		addDirectedEdges(nodeList, 2 , 4);
		addDirectedEdges(nodeList, 3 , 5);
		addDirectedEdges(nodeList, 4 , 6);
		addDirectedEdges(nodeList, 5 , 6);
		addDirectedEdges(nodeList, 5 , 8);
		addDirectedEdges(nodeList, 6 , 7);
		
		toplogicalSort(nodeList);
	}

	private static void toplogicalSort(ArrayList<GraphNode> nodeList) 
	{
		Stack<GraphNode> stack = new Stack<GraphNode>();
		for(GraphNode node : nodeList)
		{
			if(!node.isVisited())
				topologicalVisit(node, stack);
		}
		printStack(stack);
	}

	private static void topologicalVisit(GraphNode currentNode, Stack<GraphNode> stack) 
	{
		ArrayList<GraphNode> neighbours = currentNode.getNeighbours();
		for(GraphNode neighbour : neighbours)
		{
			if(!neighbour.isVisited())
				topologicalVisit(neighbour, stack);
		}
		currentNode.setVisited(true);
		stack.push(currentNode);
	}
	
	public static void addDirectedEdges(ArrayList<GraphNode> nodeList, int v1, int v2)
	{
		GraphNode g1 = nodeList.get(v1-1);
		GraphNode g2 = nodeList.get(v2-1);
		g1.getNeighbours().add(g2);
		//g2.getNeighbours().add(g1);
	}
	
	private static void printStack(Stack<GraphNode> stack) 
	{
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.append(stack.pop().getName() + " ");
		System.out.println(sb.toString()); 
	}
}
