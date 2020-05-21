package com.trip.program.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstDuplicatesInIntgerArray {

	public static void main(String[] args) 
	{
		//array only contains non negative numbers
		int [] arr = {10, 5, 3, 4, 3, 5, 6};
		//soln-1 using hashmap time O(n) and space O(n)
		int dupIndex = findFirstDuplicateSol1(arr);
		System.out.println("First Duplicate is = "+dupIndex);
		
		//this works for array items (1...n) find two duplicates
		int [] arr1 = {4, 1, 2, 3, 4, 2, 3}; 
		ArrayList<Integer> duplicate = findFirstDuplicate(arr1);
		System.out.println("First Duplicate is = "+duplicate);
	}

	private static int findFirstDuplicateSol1(int[] arr) 
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int firstIndex = Integer.MAX_VALUE;
		for(int i =0; i<arr.length; i++)
		{
			if(!map.containsKey(arr[i]))
			{
				map.put(arr[i], i);
			}
			else
			{
				int tempIndex = map.get(arr[i]);
				firstIndex = Integer.min(firstIndex, tempIndex);
			}
		}
		return arr[firstIndex];
	}

	private static ArrayList<Integer> findFirstDuplicate(int[] arr1)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		//logic check if arr1[i] > 0 them use it as an index and change the sign i.e -arr1[arr1[i]]
		// {4, 1, 2, 3, 4, 2}
		for(int i =0; i<arr1.length; i++)
		{
			int newIndex = Math.abs(arr1[i]);
			if(arr1[newIndex] > 0)
			{
				arr1[newIndex] = -arr1[newIndex];
			}
			else
			{
				result.add(Math.abs(arr1[newIndex]));
			}
		}
		return result;
	}

}
