package com.trip.dsa.tree.binarytree;

public class BinaryTreeArrayBasedImplementation {

	public static void main(String[] args) 
	{
		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.Root("A");
		binaryTree.set_left("B", 0);
		binaryTree.set_right("C", 0);
		binaryTree.set_left("D", 1);
		binaryTree.set_right("E", 1);
		binaryTree.set_right("F", 2);
		binaryTree.printTree();
	}

}

class BinaryTree
{
	String [] binaryArray;
	public BinaryTree(int capacity)
	{
		binaryArray = new String [capacity];
	}
	
	public void Root(String key)
	{
		binaryArray[0] = key;
	}
	
	//for left node for given level (2*level+1)
	public void set_left(String key, int level)
	{
		binaryArray[2*level +1] = key;
	}
	//for left node for given level (2*level+2) -- level 0 starts form below root
	public void set_right(String key, int level)
	{
		binaryArray[2*level +2] = key;
	}
	
	public void printTree()
	{
		for(int i =0; i<binaryArray.length; i++)
		{
			if(binaryArray[i] != null)
				System.out.print("  " +binaryArray[i]);
			else
				System.out.print(" - ");
		}
	}
}