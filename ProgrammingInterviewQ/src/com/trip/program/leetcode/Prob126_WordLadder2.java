package com.trip.program.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob126_WordLadder2
{
	public static void main(String[] args) 
	{
		/*String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");*/
	
		String beginWord = "hot";
		String endWord = "dog";
		List<String> wordList = Arrays.asList("hot","dog","dot");
		
		List<Node> graph = new ArrayList<Node>();
		Node beginNode = new Node(beginWord);
		Node endNode = new Node(endWord);
		//graph.add(beginNode);
		for(String word : wordList)
			graph.add(new Node(word));
		
		List<List<String>> outList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		list.add(beginWord);
		//BFSUtil(beginNode, graph, endNode, outList);
		DFSUtil(beginNode, graph, endNode, list, outList);
		//List<Node> list = addPathToList(beginNode, graph);
		
		//list.add(beginWord);
		//addPathToList(endNode, list);
		//outList.add(list);
		for(List<String> l : outList)
			System.out.println(l);
		//System.out.println(list);
	}
	
	private static void DFSUtil(Node sourceNode, List<Node> graph, Node endNode, List<String> list, List<List<String>> outList) 
	{
		sourceNode.setVisited(true);
		
		if(sourceNode.getWord().equals(endNode.getWord()))
		{
			//list.add(0, sourceNode.getWord());
			int size = list.size();
			int curr_size =0;
			if(!outList.isEmpty())
				curr_size = outList.get(0).size();
			if(curr_size == 0 || curr_size == size)
				outList.add(new ArrayList<String>(list));
			else if(curr_size > size)
				outList.set(0, new ArrayList<String>(list));
			sourceNode.setVisited(false);
			return;
		}
		
		for(Node neighbiur : graph)
		{
			if(isSingleChange(sourceNode.getWord(), neighbiur.getWord()) && !neighbiur.isVisited())
			{
				//queue.add(neighbiur);
				//neighbiur.setParent(sourceNode);
				list.add(neighbiur.getWord());
				
				DFSUtil(neighbiur, graph, endNode, list, outList);
				
				list.remove(neighbiur.getWord());
			}	
		}
		sourceNode.setVisited(false);
	}

	private static void BFSUtil(Node beginNode, List<Node> wordList, Node endNode, List<List<String>> outList )
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(beginNode);
		beginNode.setVisited(true);
		while(!queue.isEmpty())
		{
			Node current = queue.poll();
	/*		if(current.getWord().equals(endNode.getWord()))
			{
				List<String> list = new ArrayList<>();
				addPathToList(current, list);
				outList.add(list);
			}*/
			for(Node neighbiur : wordList)
			{
				if(isSingleChange(current.getWord(), neighbiur.getWord()) && !neighbiur.isVisited())
				{
					queue.add(neighbiur);
					neighbiur.setParent(current);
					neighbiur.setVisited(true);
					//list.add(neighbiur.getWord());
					if(endNode.getWord().equals(neighbiur.getWord()))
						endNode.setParent(current);
				}
				
			}
			
		}
		
	}

	private static void addPathToList(Node node, List<String> list) 
	{	
		if(node.getParent() != null)
		{
			addPathToList(node.getParent(), list);
			list.add(node.getWord());
		}		
	}

	private static boolean isSingleChange(String word1, String word2)
	{
		int n = word1.length();
		if(n != word2.length())return false;
		int count = n;
		for(int i=0; i<n; i++)
		{
			if(word1.charAt(i) == word2.charAt(i))
				count--;
		}
		if(count == 1)
			return true;
		
		return false;
	}
}

class Node
{
	String word;
	boolean visited;
	Node parent;
	int distance;
	public Node(String word)
	{
		this.word = word;
		this.parent = null;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}