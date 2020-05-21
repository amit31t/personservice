package com.trip.program.arrays;

import java.util.Arrays;

/*
 * Prob.- Product of array except self
 * Given an arry of integers n where n>1
 * Ex input- [1, 2, 3, 4] 
 * 	  output - [24, 12, 8, 6]
 * solve it without division and O(n)
 */
public class Prob_LeetCode_ProdOfArrayExceptSelf 
{
	public static void main(String[] args) 
	{
		int [] input = {1, 2, 3, 4};
		
		int [] result  = prodOfArrayExceptSelf(input.clone());
		System.out.println("Product of array except self =" +Arrays.toString(result));

	}

	private static int[] prodOfArrayExceptSelf(int[] input) 
	{
		int [] result = new int[input.length];
		int [] temp1 = new int [input.length];
		int [] temp2 = new int [input.length];
		temp1[0] =1; 
		temp2[temp2.length -1]=1;
		for(int i =1, j = input.length -1; i< input.length && j>=0; i++, j--)
		{
			temp1[i] = temp1[i-1] * input[i-1];
			temp2[j-1] = temp2[j] * input[j]; 
		}
		
		for(int i =0; i<input.length; i++)
			result[i] = temp1[i] * temp2[i]; 
		
		return result;
	}

}
