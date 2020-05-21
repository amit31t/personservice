package com.trip.dsa.algo.sorting;

public class InsertionSort {

	public static void main(String[] args) 
	{
		int [] arr = {30, 60, 20, 40};
		insertionSort(arr);
		BubbleSort.printArray(arr);
	}

	/*
	 * Loop from i = 1 to n-1.
	 * Pick element arr[i] and insert it into sorted sequence arr[0…i-1] 
	 */
	private static void insertionSort(int[] arr) 
	{
		for(int i =1; i<arr.length; i++)
		{
			int key = arr[i], j=i-1;
			while(j>=0 && arr[j] > key )
			{
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
	}

}
