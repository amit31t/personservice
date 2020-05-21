package com.trip.dsa.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.trip.dsa.graph.nodes.WeightedGNode;

public class MSTByKruskal 
{
	public static void main(String[] args) 
	{
		int numOfVertices = 5;
		ArrayList<UndirectedEdge> edgeList = new ArrayList<>();
		ArrayList<WeightedGNode> nodeList = new ArrayList<>();
		
		for(int i=0; i<numOfVertices; i++)
		{
			nodeList.add(new WeightedGNode("" + (char)(65+i)));
		}
		//add edges 
		addWeightedUndirectedEdge(nodeList, edgeList, 0, 1, 15);
		addWeightedUndirectedEdge(nodeList, edgeList, 0, 2, 20);
		addWeightedUndirectedEdge(nodeList, edgeList, 1, 2, 13);
		addWeightedUndirectedEdge(nodeList, edgeList, 1, 3, 5);
		addWeightedUndirectedEdge(nodeList, edgeList, 2, 3, 10);
		addWeightedUndirectedEdge(nodeList, edgeList, 2, 4, 6);
		addWeightedUndirectedEdge(nodeList, edgeList, 3, 4, 8);
		
		kruskalMST(nodeList, edgeList);
	}

	private static void kruskalMST(ArrayList<WeightedGNode> nodeList, ArrayList<UndirectedEdge> edgeList1) 
	{
		DisjointSet set = new DisjointSet();
		int cost = 0;
		//1. make Disjoint set for all the nodes in nodeList
		set.makeSet(nodeList);
		
		//2. sort each edge in non decreasing order by weight
/*		Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() 
		{

			@Override
			public int compare(UndirectedEdge edge1, UndirectedEdge edge2) {
				return edge1.getEdgeWeight() - edge2.getEdgeWeight();
			}			
		};
		Collections.sort(edgeList, comparator);*/
		
		//using java 8 stream and lambda
		ArrayList<UndirectedEdge> edgeList = (ArrayList<UndirectedEdge>)edgeList1.stream().sorted((e1, e2) -> e1.getEdgeWeight() - e2.getEdgeWeight()).collect(Collectors.toList());
		
		//3. for each edge(u, v) check if both the nodes are not in same set, then union it and add the cost
		for(UndirectedEdge edge : edgeList)
		{
			if(!(set.findSet(edge.getFirstNode()).equals(set.findSet(edge.getSecondNode()))))
			{
				set.union(edge.getFirstNode(), edge.getSecondNode());
				cost += edge.getEdgeWeight();
				System.out.println("Taken " + edge);
			}
		}
		System.out.println("MST cost "+cost);
	}

	// add a weighted undirected edge between two nodes
	public static void addWeightedUndirectedEdge(ArrayList<WeightedGNode> nodeList, ArrayList<UndirectedEdge> edgeList, int firstIndex, int secondIndex, int weight) 
	{
		UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
		WeightedGNode first = edge.getFirstNode();
		WeightedGNode second = edge.getSecondNode();
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second, weight);
		second.getWeightMap().put(first, weight);
		edgeList.add(edge);
	}
}
