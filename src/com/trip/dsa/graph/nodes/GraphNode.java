package com.trip.dsa.graph.nodes;

import java.util.ArrayList;

public class GraphNode 
{
	private String name;
	private ArrayList<GraphNode> neighbours;
	private boolean visited;
	private GraphNode parent;
	
	public GraphNode(String name)
	{
		this.name = name;
		this.neighbours = new ArrayList<GraphNode>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<GraphNode> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<GraphNode> neighbours) {
		this.neighbours = neighbours;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public GraphNode getParent() {
		return parent;
	}

	public void setParent(GraphNode parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return " [" + name + "] ";
	}
}
