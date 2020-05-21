package com.trip.dsa.graph.nodes;

import java.util.ArrayList;
import java.util.HashMap;

import com.trip.dsa.graph.mst.DisjointSet;

public class WeightedGNode implements Comparable<WeightedGNode>
{
	private String name;
	private ArrayList<WeightedGNode> neighbors;
	private HashMap<WeightedGNode, Integer> weightMap;
	private boolean isVisited;
	private WeightedGNode parent;
	private int distance;
	
	//adding DisjointSet for kruskal algo support
	private DisjointSet set;
	
	public WeightedGNode(String name)
	{
		this.name = name;
		distance = Integer.MAX_VALUE;
		neighbors = new ArrayList<>();
		weightMap = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<WeightedGNode> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<WeightedGNode> neighbors) {
		this.neighbors = neighbors;
	}

	public HashMap<WeightedGNode, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(HashMap<WeightedGNode, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public WeightedGNode getParent() {
		return parent;
	}

	public void setParent(WeightedGNode parent) {
		this.parent = parent;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public DisjointSet getSet() {
		return set;
	}

	public void setSet(DisjointSet set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "[ "+ name + " ]";
	}

	@Override
	public int compareTo(WeightedGNode object) 
	{
		return this.distance - object.distance;
	}
	
	
}
