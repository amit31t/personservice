package com.trip.program.leetcode;

public class Prob918_MaximumSumCircularSubarray 
{
	public static void main(String[] args) 
	{
		//int [] input = {1, -2, 3, -2}; //circural array
		int[] input ={5, -3, 5};
		int maxSum = maximumSumCircularSubarray(input);
		System.out.println(maxSum);
	}

	private static int maximumSumCircularSubarray(int[] A) 
	{
		int g_sum =Integer.MIN_VALUE;
		int curr_sum =0;
		int g_min = Integer.MAX_VALUE;
		int curr_min = 0;
		int total =0;
		for(int i=0; i<A.length; i++)
		{
			curr_sum = Math.max(curr_sum + A[i], A[i]);
			if(curr_sum < 0)
				curr_sum = 0;
			if(g_sum < curr_sum)
				g_sum = curr_sum;
			
			curr_min = Math.min(curr_min + A[i], A[i]);
			if(g_min > curr_min)
				g_min = curr_min;
			//curr_min = Math.min(curr_min, 0);
			total += A[i];
			
			if(g_sum < 0)
				return g_sum;
		}
		return Math.max(g_sum, total - g_min);
	}

}
