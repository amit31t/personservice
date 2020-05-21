package com.trip.dsa.algo.sorting;
/*
 * This is in-place sorting algorithm.
 * time -> O(n2) , space -> O(1)
 */
public class SelectionSort {

	public static void main(String[] args) 
	{
		int [] arr = {40, 30, 70, 10};
		selectionSort(arr);
		BubbleSort.printArray(arr);
	}

	private static void selectionSort(int[] arr) 
	{
		int n = arr.length; int i, j;
		for(i =0; i<n-1; i++)
		{
			int iMin = i;
			for(j =i+1 ; j< n; j++)
			{
				if(arr[iMin] > arr[j])
					iMin = j;
			}
			BubbleSort.swap(iMin, i, arr);
		}
	}

}
