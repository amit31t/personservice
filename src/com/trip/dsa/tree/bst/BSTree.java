package com.trip.dsa.tree.bst;

import java.util.ArrayList;
import java.util.Stack;

import com.trip.dsa.tree.binarytree.BinaryTreeL;

public class BSTree 
{
	int value;
	BSTree left;
	BSTree right;
	BSTree parent;
	public BSTree(int value)
	{
		this.value = value;
	}
	
	//Create a BST Node
	public static BSTree create(int value)
	{
		BSTree node = new BSTree(value);
		node.left = node.right =null;
		node.parent = null;
		return node;
	}
	
	//insert anode in BST
	public BSTree insert (BSTree root, BSTree node)
	{
		if(root == null)
		{
			root = create(node.value);	
		}
		else if(node.value < root.value)
		{	
			root.left = insert(root.left, node);
		}
		else
		{
			root.right = insert( root.right, node);
		}
		
		return root;
	}
	
	//delete a node from BST
	public BSTree delete(BSTree root, BSTree node)
	{
		if(root == null)
		{
			return null;
		}
		else if(node.value < root.value)
		{
			root.left = delete(root.left, node);
		}
		else if(node.value > root.value)
		{
			root.right = delete( root.right, node);
		}
		else
		{
			if(root.value == node.value)
			{
				//case 1 if root has both children
				if(root.left != null && root.right != null)
				{
					BSTree IOSucc = getInOrderSuccessor(root.right);
					root.value = IOSucc.value;
					delete(root.right, IOSucc);
				}
				else if(root.left == null )
				{
					root = root.right;
				}
				else if(root.right == null)
				{
					root = root.left;
				}
				else
				{ 
					root = null;
				}
				
			}
		}
		return root;
	}

	private BSTree getInOrderSuccessor(BSTree root) 
	{
		if(root.left == null) return root;
		else
			return getInOrderSuccessor(root.left);
		
	}
	
	public void inOrder(BSTree node)
	{
		if(node == null) return;
		//left tree traversal
		inOrder(node.left);
		System.out.print("  "+ node.value);
		inOrder(node.right);
	}
	
	public String toString()
	{
		return " "+this.value;
	}
}








