package com.trip.dsa.tree.bst;

public class TestBST 
{
	public static void main(String[] args) 
	{
		BSTree tree = BSTree.create(100);
		tree.left = BSTree.create(80); tree.right = BSTree.create(200);
		tree.left.left = BSTree.create(70); 
		tree.right.left = BSTree.create(150);
		
		tree.inOrder(tree);
		tree.insert(tree, BSTree.create(300));
		tree.insert(tree, BSTree.create(400));
		System.out.println("\nInOrder after insert");
		tree.inOrder(tree);
		//BSTree nodeDelete = tree.left;
		tree.delete(tree, BSTree.create(300));
		System.out.println("\nInOrder after delete");
		tree.inOrder(tree);
	}

}
