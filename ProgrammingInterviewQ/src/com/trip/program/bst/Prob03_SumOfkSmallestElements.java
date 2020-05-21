package com.trip.program.bst;

/*
 * Prob03- Sum of k smallest elements in BST
 */
public class Prob03_SumOfkSmallestElements 
{
	static int count =0;
	static int count1 =0;
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
		
		//soln1
		int k =3;
		int sum = sumOfkSmallestElements(root, k);
		System.out.println("Sum ="+sum);
		
		Node node = KthSmallest(root, 2);
		System.out.println("Kth element - "+node.value);
				
	}
	private static Node KthSmallest(Node root, int k) 
	{
		if(root == null || count1 > k ) return null;
		
		Node left = KthSmallest(root.left, k);
		if(left != null)
			return left;
		count1++;
		if(k == count1)
			return root;
		return KthSmallest(root.right, k);
	}
	private static int sumOfkSmallestElements(Node root, int k)
	{
		if(root == null || count > k) return 0;
	
		//go left tree first to get smallest elements
		int sum = sumOfkSmallestElements(root.left, k);	
		
		if(k == count)
			return sum;
		
		sum = sum +root.value;
		count++;
		
		/*if(k == count)
			return sum;*/
		sum = sum + sumOfkSmallestElements(root.right, k);
		return sum;
	}

}
