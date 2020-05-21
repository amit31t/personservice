package com.trip.dsa.graph.mst;

import java.util.ArrayList;

import com.trip.dsa.graph.nodes.WeightedGNode;

public class MainDisjointSet {

	public static void main(String[] args)
	{
		// Constructor for ArrayList
		ArrayList<WeightedGNode> nodeList = new ArrayList<>();

		// create 10 nodes: 1-10
		for (int i = 0; i < 10; i++) {
			nodeList.add(new WeightedGNode("" + (char) (65 + i)));
		}
		DisjointSet set = new DisjointSet();
		//driver code 
		set.makeSet(nodeList); //Create Disjoint Sets for each node in this list.
		//set.setNodes(set.getNodes());
		for(int i= 0; i<nodeList.size()-1; i++) 
		{
			WeightedGNode firstNode = nodeList.get(i);
			WeightedGNode secondNode = nodeList.get(i+1);
			System.out.println("Checking if node "+firstNode.getName()+" and "+secondNode.getName() +" belongs to different set, if yes, will Union them...");
			System.out.println("\nFirst Set name is: " + firstNode.getName());
			firstNode.getSet().printAllNodesOfThisSet();
			System.out.println("\nSecond Set name is: " + secondNode.getName());
			secondNode.getSet().printAllNodesOfThisSet();
			if(!set.findSet(firstNode).equals(set.findSet(secondNode))) {
				System.out.println("\nMaking union "+firstNode+" and "+secondNode );
				DisjointSet unionedSet = set.union(firstNode, secondNode);
				unionedSet.printAllNodesOfThisSet();
			}
			System.out.println("\n**************************************\n");
		}
	}

}
