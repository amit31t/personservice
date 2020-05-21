package com.trip.dsa.tree.binarytree;

public class Prob_BTSumTree 
{
	public static void main(String[] args) 
	{
		TreeNode tree = new TreeNode(26);
		//left tree
		tree.setLeft(new TreeNode(10));
		tree.getLeft().setLeft(new TreeNode(4));
		tree.getLeft().setRight(new TreeNode(6));
		//right tree
		tree.setRight(new TreeNode(3));
		tree.getRight().setRight(new TreeNode(3));
		
		//check if given tree is sum tree
		boolean isSumTree = isSumTree(tree);
		System.out.println("Given tree is sum tree - "+isSumTree);
 	}

	private static boolean isSumTree(TreeNode node) 
	{
		if(node == null) return true;
		if(node!= null && (node.getLeft()==null || node.getRight()==null))
			return true;
	
/*		boolean isNodesSum = node.getValue() == node.getLeft().getValue() + node.getRight().getValue();
		if((isNodesSum && isSumTree(node.getLeft()) && isSumTree(node.getRight())))
			return true;*/
		int leftSum = node.getLeft().getValue() + treeSum(node.getLeft());
		int rightSum = node.getRight().getValue() + treeSum(node.getRight());
		
		if(node.getValue() == (leftSum + rightSum))
			return true;
			
		return false;
	}

	private static int treeSum(TreeNode node) 
	{
		if(node == null) return 0;
		else if(node.getLeft()==null && node.getRight()==null)
			return node.getValue();
		return treeSum(node.getLeft()) + treeSum(node.getRight());
	}

}
