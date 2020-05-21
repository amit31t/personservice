package com.trip.program.arrays;
/*
 * prob-1 search an element in sorted and rotated array
 * prob-2 Find the minimum element in a sorted and rotated array
 * prob-3 Given a sorted and rotated array, find if there is a pair with a given sum X
 */
public class Prob_SortedAndRotatedArray 
{
	public static void main(String[] args) 
	{
		int [] input = {5, 6, 0, 1, 2, 3, 4}; //sorted and rotated array with pivot 7
		int key = 1;
		//prob-1, soln-1, find the pivot and then do binary search around the pivot
		int search_index = searchAnElement(input, key);
		System.out.println("Found element in index = "+search_index );
		//prob-2, soln-2, find the pivot and next element after pivot element must be min
		int min_index = findPivot(input, 0, input.length-1);
		System.out.println("Minimum element is = "+input[min_index +1] );
		//System.out.println(7%25);
		int pivot = findPivot1(input);
		System.out.println("Pivot is = "+pivot );
	}

	private static int searchAnElement(int[] input, int key) 
	{
		int index = 0;
		int n = input.length;
		int pivot = findPivot(input, 0, n-1);
		System.out.println("pivot index = "+pivot);
		
		if(pivot == -1) //it means array is not rotated at all
			index = binartSearch(input, key, 0, n-1);
		else if(key == input[pivot]) 
			index = pivot;

		else if(key > input[0])
			index = binartSearch(input, key, 0, pivot -1);
		
		else index = binartSearch(input, key, pivot+1, n-1);
	
		return index;
	}

	private static int binartSearch(int[] input, int key, int low, int high) 
	{
		//base case
		if(high < low) return -1;
		
		int mid = low + (high - low)/2;
		if(key == input[mid]) return mid;
		
		//key lies left side 
		if(key < input[mid])
			return binartSearch(input, key, low, mid -1);
		return binartSearch(input, key, mid +1, high);
	}

	private static int findPivot(int[] input, int low, int high) 
	{
		if(low >= high) return -1;
		//if(low == high) return low;
		
		int mid = (low + high)/2;
		if(mid < high && input[mid] > input[mid +1]) 
			return mid;
		if(mid > low && input[mid -1] > input[mid])
			return mid-1;
		if(input[low] >= input[mid])
			return findPivot(input, low, mid-1);
		 return findPivot(input, mid +1, high);			
	}

	private static int findPivot1(int[] input) 
	{
		if(input == null) return -1;
		int start =0; int end = input.length -1;
		//if(low == high) return low;
		while(start <= end )
		{
			int mid = (start + end)/2;
			if(input[mid] > input[mid+1]) 
				return mid;
			else
			{
				if(input[start] < input[mid])
					start = mid+1;
				else
					end = mid-1;
			}		
		}
		return -1;
	}
}
