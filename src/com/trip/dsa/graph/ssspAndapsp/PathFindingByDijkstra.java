package com.trip.dsa.graph.ssspAndapsp;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.trip.dsa.graph.nodes.WeightedGNode;

public class PathFindingByDijkstra {

	public static void main(String[] args) 
	{
		ArrayList<WeightedGNode> nodeList = new ArrayList<>();
		
		//create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedGNode(""+(char)(65+i)));
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
				
		WeightedGNode source = nodeList.get(1);
		System.out.println("Printing Dijkstra from source: "+source);
		pathByDijksta(source, nodeList);
		
	}

	private static void pathByDijksta(WeightedGNode node, ArrayList<WeightedGNode> nodeList) 
	{
		//uses PriorityQueue as minheap
		PriorityQueue<WeightedGNode> minHeap = new PriorityQueue<>();
		node.setDistance(0);
		minHeap.addAll(nodeList);
		while(!minHeap.isEmpty())
		{
			WeightedGNode currentNode = minHeap.poll();
			ArrayList<WeightedGNode> neighbours = currentNode.getNeighbors();
			for(WeightedGNode neighbour : neighbours)
			{
				if(minHeap.contains(neighbour))//if neighbour is not visited
				{
					int newDistance = (currentNode.getDistance()) + (currentNode.getWeightMap().get(neighbour));
					if(neighbour.getDistance() > newDistance )
					{
						neighbour.setDistance(newDistance);
						neighbour.setParent(currentNode);
						//refresh the queue for maintaing minheap priorities
						minHeap.remove(neighbour);
						minHeap.add(neighbour);
					}
				}
			}
		}
		//print table of node with minimum distance and shortest path from source
		for(WeightedGNode nodeToCheck: nodeList) 
		{
				System.out.print("Node "+nodeToCheck+", distance: "+nodeToCheck.getDistance()+", Path: ");
				pathPrint(nodeToCheck);
				System.out.println();				
		}
	}
	private static void pathPrint(WeightedGNode node) {
		if(node.getParent()!=null) 
		{
			pathPrint(node.getParent());
			System.out.print("->"+node);
		}
		else
		{
			System.out.print(node);
			if(node.getDistance() == Integer.MAX_VALUE)
			{
				System.out.print(" N/A " );
			}
		}
			
	}//end of method

	
	// add a weighted directed edge between two nodes
	public static void addWeightedEdge(ArrayList<WeightedGNode> nodeList, int i, int j, int d) {
		WeightedGNode first = nodeList.get(i-1);
		WeightedGNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second,d);
	}//end of method


}
