package com.trip.program.leetcode;

public class Prob226_InvertBinaryTree 
{
	private static class Node
	{
		int val;
		Node left;
		Node right;
		Node(int val)
		{
			this.val = val;
			this.left = this.right = null;
		}
	}
	public static void main(String[] args) 
	{
		Node tree = new Node(4);
		tree.left = new Node(2);
		tree.right = new Node(7);
		inOrder(tree);
		System.out.println();
		Node invertTree = invert(tree);
		inOrder(invertTree);
	}
	private static Node invert(Node root) 
	{
		if(root == null) return null;
		
		Node inTree = new Node(root.val);
		
		
		inTree.right = invert(root.left);
		inTree.left = invert(root.right);
		
		return inTree;
	}
	
	private static void inOrder(Node root)
	{
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(" "+root.val);
		inOrder(root.right);
	}
}
