package com.trip.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class CountAllPossiblePathsBetweenTwoVertices {

	public static void main(String[] args)
	{
		Graph graph = new Graph(4);
		graph.addEdge(0, 1); graph.addEdge(0, 2); graph.addEdge(0, 3);
		graph.addEdge(1, 2); graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		
		//all path count between vertix 0 and vertix 2
		int pathCount = graph.countPath(0, 2);
		System.out.println("All Possible count = "+pathCount);
	}
}

//Adjacency List Graph
class Graph
{
	private int vertices;
	public LinkedList<Integer> adjList[];
	
	@SuppressWarnings("unchecked")
	public Graph(int v) 
	{
		this.vertices = v;
		adjList = new LinkedList[v];
		for(int i=0; i<adjList.length; i++)
			adjList[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int u, int v)
	{
		adjList[u].add(v);
	}
	
	//use backtracking algo and count al possible patha b/w v1, v2
	public int countPath(int v1, int v2)
	{
		boolean [] visited = new boolean[vertices];
		Arrays.fill(visited, false); //to fill some default values in array
		int count =0;
		Stack<Integer> st = new Stack<>();
		st.push(v1);
		ArrayList<Integer> localPathList = new ArrayList<>();
		localPathList.add(v1);
		printAllPathUtil(v1, v2, visited, localPathList);
		System.out.println("print through stack");
		int pathCount = countPathUtil(v1, v2, visited, count, st);
		return pathCount;
	}

	//recursive call
	private int countPathUtil(int curr, int dest, boolean[] visited, int count, Stack<Integer> st) 
	{	
		visited[curr] = true;
		if(curr == dest)
		{
			count++;
			printStack(st);
			visited[curr] = false;
			return count;
		}
		else
		{
			//Iterator<Integer> itr = adjList[curr].listIterator();
			//while(itr.hasNext())
			for(Integer n : adjList[curr])
			{
				//int n = itr.next();
				if(!visited[n])
				{
					st.push(n);
					count = countPathUtil(n, dest, visited, count, st);
					st.remove(n);
				}
			}
		}
		visited[curr] = false;
		return count;
	}

	
	//recursive call
	private void printAllPathUtil(int curr, int dest, boolean[] visited, ArrayList<Integer> st) 
	{	
		visited[curr] = true;
		if(curr == dest)
		{
			System.out.println(st);
			visited[curr] = false;
			return;
		}
		else
		{
			//Iterator<Integer> itr = adjList[curr].listIterator();
			for(Integer n : adjList[curr])
			{
				//int n = itr.next();
				if(!visited[n])
				{
					st.add(n);
					printAllPathUtil(n, dest, visited, st);
					st.remove(n);
				}
			}
		}
		visited[curr] = false;
	}
	private void printStack(Stack<Integer> st) 
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< st.size()-1; i++)
		{
			sb.append(" " +st.pop() + " ");
		}
		System.out.print(" 0 "+sb.reverse().toString());
		System.out.println();
	}	
	
}
