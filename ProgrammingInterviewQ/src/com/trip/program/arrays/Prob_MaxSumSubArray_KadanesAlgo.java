package com.trip.program.arrays;
/*
 * Prob - Max sum of sub array in a given array
 */
public class Prob_MaxSumSubArray_KadanesAlgo
{
	public static void main(String[] args) 
	{
		int[] input = {2, -3, 4, -1, 2};
		
		//soln-1 - brute force, run two loops and check max sum for subarray's one by one
		int maxSumSubArray1 = maxSumSubArray(input);
		System.out.println("Max Sum subarray = "+maxSumSubArray1);
		//soln-2 - Kadane's algo, max sum of subarray will be max(A[i], curr_max + A[i] 
		int maxSumSubArray = KadanesAlgo(input);
		System.out.println("Max Sum subarray = "+maxSumSubArray);
	}

	private static int maxSumSubArray(int[] input) 
	{
		int global_max = input[0];
		for(int i = 0; i< input.length; i++)
		{
			int curr_max = global_max;
			int sum =0;
			for(int j =i+1; j<input.length; j++)
			{
				sum += input[j];
				if(sum > curr_max)
					curr_max = sum;
			}
			if(global_max < curr_max)
				global_max = curr_max;
		}
		return global_max;
	}

	private static int KadanesAlgo(int[] input) 
	{	
		int curr_max = input[0];
		int global_max = input[0];
		for(int i =1; i<input.length; i++)
		{
			curr_max = Math.max(input[i], curr_max + input[i]);
			if(curr_max > global_max)
				global_max = curr_max;
		}
		return global_max;
	}

}
