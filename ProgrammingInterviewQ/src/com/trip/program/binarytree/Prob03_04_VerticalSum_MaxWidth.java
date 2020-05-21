package com.trip.program.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
 * 1. Find vertical sum in given binary tree
 * 2. What is max width of BT
 */
public class Prob03_04_VerticalSum_MaxWidth 
{
	public static void main(String[] args) 
	{
		Node tree = new Node(5);
		tree.left = new Node(10);
		tree.left.left = new Node(4);
		tree.left.right = new Node(3);
		tree.right = new Node(1);
		tree.right.left = new Node(2);
		//Soln1 -  using horizontal distance and map to store sum
		verticalSum(tree);
		//slon2 
		int maxWidth = maxWidthOfBT(tree);
		System.out.println("Maximum width = "+maxWidth);
	}

	private static int maxWidthOfBT(Node root)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int maxWidth = 0;
		while(!q.isEmpty())
		{
			int levelNodes = q.size();
			maxWidth = Math.max(maxWidth, levelNodes);
			while(levelNodes>0)
			{
				Node cn = q.poll();
				if(cn.left != null)q.add(cn.left);
				if(cn.right != null)q.add(cn.right);
				levelNodes--;
			}
		}
		
		return maxWidth;
	}

	private static void verticalSum(Node tree) 
	{
		if(tree == null) return;
		TreeMap<Integer, Integer> sumMap = new TreeMap<Integer, Integer>();
		verticalSumUtil(tree, 0, sumMap);
		Iterator<Map.Entry<Integer, Integer>> itr = sumMap.entrySet().iterator();
		while(itr.hasNext() )
		{
			System.out.println(itr.next());
		}
	}

	private static void verticalSumUtil(Node tree, int hd, TreeMap<Integer, Integer> sumMap) 
	{
		if(tree == null )return;
		
		//for left subtree hd will be negative
		verticalSumUtil(tree.left, hd-1, sumMap);
		
		//update treeMap sum value corresponding to hd
		int preSum = sumMap.get(hd)== null ? 0 : sumMap.get(hd);
		sumMap.put(hd, preSum + tree.value);
		
		verticalSumUtil(tree.right, hd+1, sumMap);
	}

}

class Node
{
	int value; 
	Node left;
	Node right;

	
	Node(int v)
	{
		value = v;
		left = right = null;
	}
	
	public String toString()
	{
		return ""+value+"";
	}
}