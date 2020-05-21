package com.trip.program.leetcode;

import java.util.PriorityQueue;

/*
 * Design a class to find the kth largest element in a stream. Note that it is the kth 
 * largest element in the sorted order, not the kth distinct element.
 * Your KthLargest class will have a constructor which accepts an integer k and 
 * an integer array nums, which contains initial elements from the stream. 
 * For each call to the method KthLargest.add, return the element representing 
 * the kth largest element in the stream.
 */
public class Prob703_KthLargest 
{
	int k;
	int [] nums;
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	 public Prob703_KthLargest(int k, int[] nums) 
	 {
	      this.k =k;
	      this.nums = nums;
	      initMinHeap();
	 }
	public static void main(String[] args) 
	{
		//int[] input =  {4,5,8,2};
		int[] input =  {};
		int k = 1;
		Prob703_KthLargest kthLargest = new Prob703_KthLargest(k, input);
		//kthLargest.init();
		
		int[] test = {-3, -2, -4, 0, 4};
		for(int m : test)
			System.out.println(k+"th Largest = "+kthLargest.add(m));
	}
	    
	public int add(int val) 
	{
		if(minHeap.size() < k)
			minHeap.add(val);
		else if(val > minHeap.peek())
		{
			minHeap.remove();
			minHeap.add(val);
		}
		return minHeap.peek();
	}
	
	public void init()
	{
		//minHeap.isEmpty()
	    for(int i =0; i<k; i++)
	    	minHeap.add(nums[i]);
	    
	    for(int i =k; i<nums.length; i++)
	    {
	    	if(nums[i]> minHeap.peek())
	    	{
	    		minHeap.remove();
	    		minHeap.add(nums[i]);
	    	}
	     }
	}
	
	 private void initMinHeap()
	 {
		 if(nums.length >= k)
	     {
	        for(int i =0; i<k; i++)
	        	minHeap.add(nums[i]);
		   
		   for(int i =k; i<nums.length; i++)
		   {
			   if(nums[i]> minHeap.peek())
			   {
				   minHeap.remove();
				   minHeap.add(nums[i]);
			   }
		   }  
	     }
		 else
		 {
			 for(int i =0; i<nums.length; i++)
		        minHeap.add(nums[i]);
		 }
	}
}
