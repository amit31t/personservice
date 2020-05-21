package com.trip.dsa.graph.ssspAndapsp;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.trip.dsa.graph.nodes.WeightedGNode;

public class PathFindingByBellmanFord {

	public static void main(String[] args) 
	{
		ArrayList<WeightedGNode> nodeList = new ArrayList<>();
		
		//create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedGNode(""+(char)(65+i)));
		}
		//devide the max distance by 10, so when adding weight on this it will not go in negative
		//System.out.println(Integer.MAX_VALUE + 5);
		for(WeightedGNode node : nodeList)
		{
			node.setDistance(node.getDistance()/10);
		}
				
		addWeightedEdge(nodeList, 1,3,6); //Add A-> C , weight 6
		addWeightedEdge(nodeList, 1,4,3); //Add A-> D , weight 3
		//addWeightedEdge(nodeList, 1,4,-6); //Add A-> D , weight -6 // negative cycle
		addWeightedEdge(nodeList, 2,1,3); //Add B-> A , weight 3
		addWeightedEdge(nodeList, 3,4,2); //Add C-> D , weight 2
		addWeightedEdge(nodeList, 4,3,1); //Add D-> C , weight 1
		addWeightedEdge(nodeList, 4,2,1); //Add D-> B , weight 1
		addWeightedEdge(nodeList, 5,2,4); //Add E-> B , weight 4
		addWeightedEdge(nodeList, 5,4,2); //Add E-> D , weight 2
				
		System.out.println("Printing BellmanFord from source: E");
		
		WeightedGNode source = nodeList.get(1);
		pathByBellManFord(source, nodeList);
		
	}

	private static void pathByBellManFord(WeightedGNode node, ArrayList<WeightedGNode> nodeList) 
	{
		//uses PriorityQueue as minheap
		//PriorityQueue<WeightedGNode> minHeap = new PriorityQueue<>();
		node.setDistance(0);
		int v = nodeList.size();
		//loop from 1 to v-1, otherwise if negative cycle occurs then this algo does not work
		for(int i =0; i< v-1; i++)
		{
			for(WeightedGNode presentNode : nodeList)
			{
				for(WeightedGNode neighbour : presentNode.getNeighbors())
				{
					if(neighbour.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbour)))
					{
						neighbour.setDistance(presentNode.getDistance() + presentNode.getWeightMap().get(neighbour));
						neighbour.setParent(presentNode);
					}
				}
			}
		}
		
		//finding negaive cycle in vth iteration
		for(WeightedGNode currentNode : nodeList)
		{
			for(WeightedGNode neighbour : currentNode.getNeighbors())
			{
				if(neighbour.getDistance() > (currentNode.getDistance() + currentNode.getWeightMap().get(neighbour)))
				{
					// if distance of neighbor is greater than tentative new path then we have a negative cycle, return from here..
					System.out.println("Negative cycle detected ....");
					System.out.println("Vertex Name : "+neighbour.getName());
					System.out.println("Old Distance : "+ neighbour.getDistance());
					System.out.println("New Distance : "+ currentNode.getDistance() + currentNode.getWeightMap().get(neighbour));
					return;
				}
			}
		}
		System.out.println("Negative cycle not found");
		
		//printing paths now
		System.out.println("Printing paths :");
		for(WeightedGNode printNode : nodeList)
		{
			if(printNode.getDistance() != (Integer.MAX_VALUE/10))
			{
				System.out.print("Node : "+printNode.getName() + ", Distance : "+printNode.getDistance() + ", Path : ");
				pathPrint(printNode);
				System.out.println();
			}
		}
	}
	private static void pathPrint(WeightedGNode node) {
		if(node.getParent()!=null) {
			pathPrint(node.getParent());
			System.out.print("->"+node);
		}
		else 
			System.out.print(node);
	}//end of method

	
	// add a weighted directed edge between two nodes
	public static void addWeightedEdge(ArrayList<WeightedGNode> nodeList, int i, int j, int d) {
		WeightedGNode first = nodeList.get(i-1);
		WeightedGNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second,d);
	}//end of method


}
