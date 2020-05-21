package com.trip.dsa.graph.ssspAndapsp;

import java.util.ArrayList;

import com.trip.dsa.graph.nodes.WeightedGNode;

public class AllPairShortestPathByFloydWarshall {

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
		
		int[][] result = allPairShortestPathByfloydWarshall(nodeList);
		
		printDistanceResult(result, nodeList);
	}

	private static int[][] allPairShortestPathByfloydWarshall(ArrayList<WeightedGNode> nodeList) 
	{
		//1. create V * V array for distance
		int [][] distanceTable =  new int [nodeList.size()][nodeList.size()];
		
		//2. copy all the distance from given graph(adjacencyList) to distanceTable
		copyDistanceFromGraphToTable(nodeList, distanceTable);
		
		//3. run the loops v times and internal loops to optimize distances
		for(int k=0; k<nodeList.size(); k++)
		{
			for(int i=0; i<nodeList.size();i++)
			{
				for(int j=0; j<nodeList.size(); j++)
				{
					if(distanceTable[i][j] > distanceTable[i][k] + distanceTable[k][j])
						distanceTable[i][j] =  distanceTable[i][k] + distanceTable[k][j];
				}
			}
		}
		return distanceTable;
	}

	private static void copyDistanceFromGraphToTable(ArrayList<WeightedGNode> nodeList, int[][] distanceTable) 
	{
		for(int i=0; i<nodeList.size(); i++)
		{
			for(int j=0; j<nodeList.size(); j++)
			{
				WeightedGNode first = nodeList.get(i);
				WeightedGNode second = nodeList.get(j);
				if(i == j)
					distanceTable[i][j] = 0;
				else if(first.getWeightMap().containsKey(second)) // the vertices are directly connected so update weight as distance
				{
					distanceTable[i][j] = first.getWeightMap().get(second);
				}
				else
					distanceTable[i][j] = Integer.MAX_VALUE/10; // max value devide by 10 to ignore arithmatic overflow
			}
		}
		
	}
	
	//print all pair shortest path
	private static void printDistanceResult(int[][] result, ArrayList<WeightedGNode> list) {
		// Print table of node with minimum distance and shortest path from each source
		System.out.println("Printing distance list for node  -- "+list.get(0)+""+list.get(1)+""+list.get(2)+""+list.get(3)+ "" +list.get(4));
		for (int i = 0; i < list.size(); i++) {
			System.out.print("Printing distance list for node "+list.get(i)+": ");
			for (int j = 0; j < list.size(); j++) {
				System.out.print(result[i][j]+"    ");
			}
			System.out.println();
		}
		
	}
	// add a weighted directed edge between two nodes
	public static void addWeightedEdge(ArrayList<WeightedGNode> nodeList, int i, int j, int d) {
		WeightedGNode first = nodeList.get(i-1);
		WeightedGNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second,d);
	}//end of method
}
