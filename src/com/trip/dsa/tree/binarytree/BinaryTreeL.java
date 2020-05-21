package com.trip.dsa.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeL 
{
	int value;
	BinaryTreeL left;
	BinaryTreeL right;
	
	public BinaryTreeL(int value) 
	{
		this.value = value;
		left = right = null;
	}
	
	//inorder traversal - left tree, root, right tree
	public void inOrder(BinaryTreeL node)
	{
		if(node == null) return;
		//left tree traversal
		inOrder(node.left);
		System.out.print("  "+ node.value);
		inOrder(node.right);
	}
		
	//preorder traversal - root, left, right
	public void preOrder(BinaryTreeL node)
	{
		if(node == null)return;
		
		System.out.print("  "+ node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	//postorder traversal - left, right, root
	public void postOrder(BinaryTreeL node)
	{
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print("  "+ node.value);
	}
	//levelorder traversal - travers level by level usuig queue
	public void levelOrder()
	{
		if(this != null)
		{
			Queue<BinaryTreeL> queue = new LinkedList<BinaryTreeL>();
			queue.add(this);
			
			while(!queue.isEmpty())
			{
				BinaryTreeL currentNode = queue.poll();
				System.out.print("  "+currentNode.value);
				if(currentNode.left != null)
					queue.add(currentNode.left);
				if(currentNode.right != null)
					queue.add(currentNode.right);		
			}
		}	
	}
	//insert a node
	public void insert(BinaryTreeL newNode)
	{
		//do levelOrder traversal so it will search empty place as breadth wise, not depth wise
		if(this != null)
		{
			Queue<BinaryTreeL> queue = new LinkedList<BinaryTreeL>();
			queue.add(this);
			
			while(!queue.isEmpty())
			{
				BinaryTreeL currentNode = queue.poll();
				if(currentNode.left != null)
					queue.add(currentNode.left);
				else
				{
					currentNode.left = newNode;
					break;
				}
				
				if(currentNode.right != null)
					queue.add(currentNode.right);
				else
				{
					currentNode.right = newNode;
					break;
				}
			}
		}	
	}
	//delete a node
	public void delete(BinaryTreeL node)
	{
		//do levelOrder traversal
		if(this != null)
		{
			BinaryTreeL parentNode=null, previousNode=null, currentNode = null;
			boolean isLeft = false;
			boolean isRight = false;
			Queue<BinaryTreeL> queue = new LinkedList<BinaryTreeL>();
			queue.add(this);
			
			while(!queue.isEmpty())
			{
				currentNode = queue.poll();	
				
				if(currentNode.left != null)
				{
					queue.add(currentNode.left);
					if(currentNode.left.value == node.value)
					{
						isLeft =true;
						parentNode = currentNode;
					}
				}
				
				if(currentNode.right != null)
				{
					queue.add(currentNode.right);
					if(currentNode.right.value == node.value)
					{
						parentNode = currentNode;
						isRight = true;
					}
				}
				if(queue.isEmpty())
				{
					if(currentNode.value != node.value)
					{
						if(isLeft)
							parentNode.left.value = currentNode.value;
						if(isRight)
							parentNode.right.value = currentNode.value;
						
						
						previousNode = getDeepestNodeParent(currentNode);
						if(previousNode.left.value == currentNode.value)
							previousNode.left = null;
					}
				}
			}
		}	
	}
	public BinaryTreeL getDeepestNodeParent(BinaryTreeL deepNode)
	{
		BinaryTreeL pNode = null;
		Queue<BinaryTreeL> queue = new LinkedList<BinaryTreeL>();
		queue.add(this);
				
		while(!queue.isEmpty())
		{
			BinaryTreeL currentNode = queue.poll();
			if(currentNode.left !=null)
			{
				if(currentNode.left.value == deepNode.value)
				{
					pNode = currentNode;
				}
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null)
			{
				if(currentNode.right.value == deepNode.value)
				{
					pNode = currentNode;
				}
				
				queue.add(currentNode.right);	
			}	
			
		}
		return pNode;
	}
	//search a node
	public boolean search(BinaryTreeL node)
	{
		//do levelOrder traversal so it will search empty place as breadth wise, not depth wise
		if(this != null)
		{
			Queue<BinaryTreeL> queue = new LinkedList<BinaryTreeL>();
			queue.add(this);
					
			while(!queue.isEmpty())
			{
				BinaryTreeL currentNode = queue.poll();
				if(currentNode.value == node.value)
					return true;
				
				if(currentNode.left != null)
					queue.add(currentNode.left);					
				if(currentNode.right != null)
					queue.add(currentNode.right);
			}
		}
		return false;
	}
	//delete full tree
	
	//toString
	@Override
	public String toString() {
		return "[value=" + value + "]";
	}
	
}
