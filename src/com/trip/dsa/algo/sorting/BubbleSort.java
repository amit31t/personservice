package com.trip.dsa.algo.sorting;

import java.util.function.IntPredicate;

/*
 * This is in-place sorting algorithm, this is best fit when data is almost sorting.
 * time -> O(n2) , space -> O(1)
 */
public class BubbleSort {

	public static void main(String[] args) 
	{
		int [] input = {70, 40, 50, 30, 90, 10, 20};
		bubbleSort(input);
		printArray(input);
	}
	/*
	 * compare the adjecent numbers and  if > then swap it
	 * {70, 40, 50, 30} -> 
	 */
	private static void bubbleSort(int[] input) 
	{
		for(int i =0; i<input.length-1; i++)
		{
			for (int j=0; j<input.length -i -1; j++)
			{
				if(input[j] > input[j+1] )
					swap(j, j+1, input);
			}
			System.out.print(i+" pass = ");
			printArray(input);
		}
		
	}

	public static void swap(int a, int b, int[]input)
	{
		int temp = input[a];
		input[a] =  input[b];
		input[b] = temp;
	}
	public static void printArray(int[] input) 
	{
		for(int i = 0; i<input.length; i++)
		{
			System.out.print(" "+input[i]);
		}
		System.out.println();
	}
	

}
