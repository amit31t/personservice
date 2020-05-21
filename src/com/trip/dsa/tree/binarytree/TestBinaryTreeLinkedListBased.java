package com.trip.dsa.tree.binarytree;

public class TestBinaryTreeLinkedListBased 
{
	public static void main(String[] args) 
	{
		BinaryTreeL tree = new BinaryTreeL(5);
		//left tree
		tree.left = new BinaryTreeL(10);
		tree.left.left = new BinaryTreeL(4);
		//right tree 
		tree.right = new BinaryTreeL(8);
		tree.right.left = new BinaryTreeL(3);
		tree.right.right = new BinaryTreeL(2);
		tree.right.left.left = new BinaryTreeL(1);
		
		System.out.println(" InOrder Travarsal - " );
		tree.inOrder(tree);
		
		System.out.println("\n PreOrder Travarsal - " );
		tree.preOrder(tree);
		
		System.out.println("\n PostOrder Travarsal - " );
		tree.postOrder(tree);
		
		System.out.println("\n levelOrder Travarsal - " );
		tree.levelOrder();
		
		BinaryTreeL newNode = new BinaryTreeL(20);
		System.out.println("\n Insert new Node - " +newNode.value);
		tree.insert(newNode);
		tree.levelOrder();
		
		System.out.println("\n delete Node - " +newNode.value);
		tree.delete(newNode);
		tree.levelOrder();
	}

}
