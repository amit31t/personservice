package com.trip.dsa.graph.mst;

import java.util.ArrayList;

import com.trip.dsa.graph.nodes.WeightedGNode;

public class DisjointSet 
{
	private ArrayList<WeightedGNode> nodes = new ArrayList<>();
	
	//Create Disjoint Sets for each node in this list.
	public void makeSet(ArrayList<WeightedGNode> nodeList)
	{
		//for each node in list, create a disjoint set
		for(WeightedGNode node : nodeList) 
		{
			DisjointSet disjointSet = new DisjointSet();
			disjointSet.getNodes().add(node);
			node.setSet(disjointSet); //Storing the reference of this Disjoint set in Node class
		}
	}
	
	//find disjoint set for given node
	public DisjointSet findSet(WeightedGNode node)
	{
		return node.getSet();
	}
	
	//union or merge given two nodes 
	public DisjointSet union(WeightedGNode node1, WeightedGNode node2)
	{
		DisjointSet unionSet = null;
		if(node1.getSet().equals(node2.getSet()))//if two nodes are of same set then no union needed
				unionSet = null;
		else
		{
			DisjointSet set1 = node1.getSet();
			DisjointSet set2 = node2.getSet();
			// if first set is bigger then update each node of second set to merge to set1
			if(set1.getNodes().size() > set2.getNodes().size())
			{
				for(WeightedGNode node : set2.getNodes())//update each node of second set to merge to set1
				{
					set1.getNodes().add(node);
					node.setSet(set1);
				}
				unionSet = set1;
			}
			else
			{
				for(WeightedGNode node : set1.getNodes())
				{
					set2.getNodes().add(node);
					node.setSet(set2);
				}
				unionSet = set2;
			}
		}
		return unionSet;
	}
	public ArrayList<WeightedGNode> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<WeightedGNode> nodes) {
		this.nodes = nodes;
	}
	
	public void printAllNodesOfThisSet() 
	{
		System.out.println("Printing all nodes of the set: ");
		for(WeightedGNode node: nodes) {
			System.out.print(node + "  ");
		}
		System.out.println();
	}
}
