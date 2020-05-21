package com.trip.dsa.arrays;

public class TestArrays {
	private static int [] arr = {10,20, 30};
	
	public static void main(String[] args) 
	{
		insertInArray(arr, 50, 2);
		arrayTravelsal(arr);
		int number = 30;
		int searchCellNo = searchInAnArray(arr, number);
		System.out.println("number found in cell number ="+searchCellNo);
	}
	
	private static int searchInAnArray(int []arr, int value)
	{
		int ret = -1;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]== value)
				ret = i;
		}
		return ret;
	}
	private static void insertInArray(int []arr, int value, int location)
	{
		if(arr[location] != 0)
			return;
		else
			arr[location] = value;		
	}
	
	private static void arrayTravelsal(int []arr)
	{
		if(arr == null )
			System.out.println("Array does not exist");
		else
		{
			for(int i=0; i<arr.length; i++)
			{
				System.out.println(arr[i]);
			}
		}
	}

}
