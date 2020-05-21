package com.trip.program.arrays;

import java.util.Arrays;

/* sortedSquaredArray : you have a sorted array of numbers, WAP that returns a sorted array 
 * containing squares of those integers
 */
public class SortedSquaredArrayProblem {

	public static void main(String[] args) 
	{
		//input sorted array
		int[] input = {-11, -7, -5, 1, 4, 6, 12};
		
		//int[] output = sortedSquaredArray(input);
		int[] output = optimizedSortedSquaredArray(input);
		System.out.println("Sorted Array : ");
		for(int i=0; i<output.length; i++)
		{
			System.out.print(output[i] + " " );
		}
		
	}

	/* this is optimized solution which takes O(n) time complexity 
	 * In this solution we need to traverse array from end and compare absulute value for 
	 * begining with max value from end(as array is sorted) -6, -4, 1, 3, 5
	 */
	private static int[] optimizedSortedSquaredArray(int[] input) 
	{
		int [] result = new int[input.length];
		int first = 0;
		int last = input.length -1;
		for(int i=input.length-1; i>=0; i--)
		{
			if(Math.abs(input[first]) > input[last])
			{
				result[i] = input[first] * input[first];
				first++;
			}
			else
			{
				result[i] = input[last] * input[last];
				last--;
			}
		}
		return result;
	}

	/* Simple but not optimized solution in this sorting is required 
	 * which takes at least O(nlogn)
	 */
	private static int[] sortedSquaredArray(int[] input) 
	{
		int [] result = new int[input.length];
		
		for(int i=0; i<input.length; i++)
		{
			result[i] = input[i] * input[i];
		}
		Arrays.sort(result);
		return result;
	}

}
