package com.trip.program.binarytree;
/*
 * Prob02_01 - find the height of the tree
 */
public class Prob02_MixProblems
{
	public static void main(String[] args) 
	{
		Tree tree = new Tree(10);
		tree.left = new Tree(5);
		tree.right = new Tree(3);
		tree.left.right = new Tree(2);
		tree.left.right.right = new Tree(1);
		
		//Prob02_01 height of tree
		int height = heightOfTheTree(tree);
		System.out.println("Height of the Tree = "+height);
	}

	private static int heightOfTheTree(Tree tree) 
	{
		if(tree == null) return 0;
		
		int leftH = heightOfTheTree(tree.left);
		int leftR = heightOfTheTree(tree.right);
		
		return 1 + Integer.max(leftH, leftR);
	}	

}
class Tree
{
	int value;
	Tree left;
	Tree right;
	
	public Tree(int value)
	{
		this.value = value;
		this.left = this.right = null;
	}
}

