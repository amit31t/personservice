package com.trip.dsa.algo.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuickSort {

	public static void main(String[] args) 
	{
		int [] arr = {15, 20, 10, 25, 5, 30};
		System.out.println("Data Before sort..");
		IntStream.of(arr).forEach(i -> System.out.print(" "+i));
		
		quickSort(arr);
		System.out.println("Data After sort..");
		IntStream.of(arr).forEach(i -> System.out.print(" "+i));
	}

	private static void quickSort(int[] arr) 
	{
		int c =0; int r = arr.length -1;
		quickSortUtil(arr, c, r);
		
	}

	private static void quickSortUtil(int[] arr, int c, int r) 
	{
		if(c<r)
		{
			int p = findPivot(arr, c, r);
			System.out.println("\npivot " +p);
			quickSortUtil(arr, c, p-1);
			quickSortUtil(arr, p+1, r);
		}		
	}

	// {30, 15, 10, 25, 5, 20}
	private static int findPivot(int[] arr, int p, int r) 
	{
		int pivot = r;
		int i = p-1;
		for(int j=p; j<=r; j++)
		{
			if(arr[j] <= arr[pivot])
			{
				++i;
				int temp =  arr[j];
				arr[j] = arr[i];
				arr[i] = temp;	
			}
		}
		return i;
	}

}
