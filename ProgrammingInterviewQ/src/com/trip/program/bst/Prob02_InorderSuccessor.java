package com.trip.program.bst;
/*
 * Prob02- find inorder successor in given BST for given node.
 */
public class Prob02_InorderSuccessor 
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
		
		//Soln1 - do inorder traversal and push into the array and then next node from given node
		//Soln2 
		Node successor = inorderSuccessor(root, 22);
		System.out.println("Inorder Successor is - "+successor.value);
		
		Node predecessor = inorderPredecessor(root, 22);
		System.out.println("Inorder Predecessor is - "+predecessor.value);
	}
	
	private static Node inorderPredecessor(Node root, int data) 
	{
		Node currNode = find(root, data);
		Node predecessor = null;
		//case_1 - if currNode has left subtree then maximum of left subtree is predecessor
		if(currNode.left != null)
			predecessor = maxOfLeftSubTree(currNode.left);
		//case_2 - if current node does not has left sub tree, then deepest unvisited ancestor 
		// will be predecessor
		else
		{
			Node ancestor = root;
			while(ancestor.value != currNode.value)
			{
				if(currNode.value > ancestor.value)
				{
					predecessor = ancestor;
					ancestor = ancestor.right;
				}
				else
					ancestor = ancestor.left;
			}
		}
		return predecessor;
	}

	//Inorder successor for given node
	private static Node inorderSuccessor(Node root, int data) 
	{
		Node successor = null;
		Node currentNode = find(root, data);
		//case_1 - if current node(node for which we find successor) has right sub tree 
		//then minimum of right sub tree will be successor
		if(currentNode.right != null)
			successor = minRightSubTree(currentNode.right);
		//case_2 - if current node does not have right sub tree, then deepest unvisited ancestor 
		// will be successor
		else
		{
			Node ancestor = root;
			while(ancestor.value != currentNode.value)
			{
				if(currentNode.value < ancestor.value)
				{
					successor = ancestor;
					ancestor = ancestor.left;
				}
				else 
					ancestor = ancestor.right;
			}
		}
		return successor;
	}

	private static Node minRightSubTree(Node right) 
	{
		while(right.left != null)
			right = right.left;
		return right;
	}
	
	private static Node maxOfLeftSubTree(Node left) 
	{
		while(left.right != null)
			left = left.right;
		return left;
	}

	private static Node find(Node root, int data) 
	{
		if(root == null) return null;
		
		if(root.value == data) 
			return root;
		else if(data < root.value)
			return find(root.left, data);
		else
			return find(root.right, data);
	}

}
