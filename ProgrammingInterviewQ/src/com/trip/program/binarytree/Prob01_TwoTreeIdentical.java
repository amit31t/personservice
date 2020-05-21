package com.trip.program.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Prob01_TwoTreeIdentical {

	public static void main(String[] args) 
	{
		TreeIdentical tree = new TreeIdentical(10);
		tree.left = new TreeIdentical(5);
		tree.right = new TreeIdentical(2);
		tree.left.left = new TreeIdentical(3);
		
		TreeIdentical tree1 = new TreeIdentical(10);
		tree1.left = new TreeIdentical(5);
		tree1.right = new TreeIdentical(2);
		//tree1.left.left = new TreeIdentical(3);

		//For identical when data as well as arrangement of data is same
		boolean isIdentical = areTreesIdentical(tree, tree1);
		System.out.println("Are Trees Identical "+isIdentical);
		
	}

	private static boolean areTreesIdentical(TreeIdentical tree,TreeIdentical tree1) 
	{
		Queue<TreeIdentical> q1 = new LinkedList<TreeIdentical>();
		Queue<TreeIdentical> q2 = new LinkedList<TreeIdentical>();
		q1.add(tree);
		q2.add(tree1);
		
		while(!q1.isEmpty() && !q2.isEmpty())
		{
			TreeIdentical t1 = q1.poll();
			TreeIdentical t2 = q2.poll();
			//check for values 
			if(t1.value != t2.value)
				return false;
			
			//check for left nodes for both tree
			if(t1.left != null && t2.left!=null)
			{
				q1.add(t1.left);
				q2.add(t2.left);
			}
			else if(t1.left != null || t2.left != null)
				return false;
			
			//check for right nodes for both tree
			if(t1.right != null && t2.right!=null)
			{
				q1.add(t1.right);
				q2.add(t2.right);
			}
			else if(t1.right != null || t2.right != null)
				return false;
		}
		
		return true;
	}

}

class TreeIdentical
{
	int value;
	TreeIdentical left;
	TreeIdentical right;
	
	public TreeIdentical(int value)
	{
		this.value = value;
		this.left = this.right = null;
	}
}