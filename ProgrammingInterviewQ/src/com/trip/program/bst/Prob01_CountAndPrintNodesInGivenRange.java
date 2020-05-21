package com.trip.program.bst;

import java.util.LinkedList;
import java.util.Queue;

/*
 * prob01- count the number of nodes which lies within range
 */
public class Prob01_CountAndPrintNodesInGivenRange 
{
	private static class Node
	{
		int value;
		Node left;
		Node right;
		public Node (int v)
		{
			this.value = v;
			this.left = this.right = null;
		}
	}
	public static void main(String[] args)
	{
		Node root = new Node(18);
		root.left = new Node(15); root.left.left = new Node(10); root.left.right = new Node(16);
		root.right = new Node(22); root.right.left = new Node(20); root.right.right = new Node(25);
		int k1 = 10; int k2 = 20;
		//iterative
		int count = countNodesInGivenRange(root, k1, k2);
		System.out.println("Count of nodes "+count);
		
		//recursive
		int count1 = recursiveCountNodesInGivenRange(root, k1, k2);
		System.out.println("Count of nodes "+count1);
		
	}
	
	
	private static int recursiveCountNodesInGivenRange(Node root, int k1, int k2) 
	{
		if(root == null )return 0;
		
		//int count =0; int lcount =0; //int rcount =0;
		if(k1 <= root.value && root.value <= k2)
		{
			System.out.print( " "+root.value);
			return 1 + recursiveCountNodesInGivenRange(root.left, k1, k2) + recursiveCountNodesInGivenRange(root.right, k1, k2);
		}
		else if(root.value < k1) 
			return recursiveCountNodesInGivenRange(root.right, k1, k2);
		else
			return  recursiveCountNodesInGivenRange(root.left, k1, k2);
	}
	
	
	private static int countNodesInGivenRange(Node root, int k1, int k2) 
	{
		if(root == null)return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty())
		{
			Node currNode = queue.poll();
			if(k1 <= currNode.value && currNode.value <= k2)
			{
				count++;
			}
			if(currNode.left != null) queue.add(currNode.left);
			if(currNode.right != null) queue.add(currNode.right);
		}
		return count;
	}

}
