package com.trip.program.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class WGNode implements Comparable<WGNode>
{
	private String name;
	private ArrayList<WGNode> neighbours;
	private HashMap<WGNode, Integer> weightMap;
	private WGNode parentNode;
	private int distance;
	private boolean visited;
	
	public WGNode(String name) 
	{
		this.name = name;
		neighbours = new ArrayList<WGNode>();
		weightMap = new HashMap<WGNode, Integer>();
		this.distance = Integer.MAX_VALUE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<WGNode> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<WGNode> neighbours) {
		this.neighbours = neighbours;
	}

	public HashMap<WGNode, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(HashMap<WGNode, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	public WGNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(WGNode parentNode) {
		this.parentNode = parentNode;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}
	
	// add a weighted undirected edge between two nodes
	public void addWeightedUndirectedEdge(ArrayList<WGNode> nodeList, int v1, int v2, int d)
	{
		WGNode g1 = nodeList.get(v1-1);
		WGNode g2 = nodeList.get(v2-1);
		g1.getNeighbours().add(g2);
		g2.getNeighbours().add(g1);
		g1.getWeightMap().put(g2, d);
		g2.getWeightMap().put(g1, d);
	}
	// add a weighted directed edge between two nodes
	public void addWeightedDirectedEdge(ArrayList<WGNode> nodeList, int i, int j, int d) 
	{
		WGNode first = nodeList.get(i-1);
		WGNode second = nodeList.get(j-1);
		first.getNeighbours().add(second);
		first.getWeightMap().put(second,d);
	}//end of method

	@Override
	public int compareTo(WGNode node) 
	{
		return this.getDistance() - node.getDistance();
	}
	
	public void printPath(WGNode node)
	{
		if(node.getParentNode() != null)
			System.out.print(node.getParentNode()+ " ");
		System.out.print(node +" " );
	}
}
