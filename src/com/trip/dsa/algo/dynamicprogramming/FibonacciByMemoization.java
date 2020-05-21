package com.trip.dsa.algo.dynamicprogramming;

public class FibonacciByMemoization 
{
	final int MAX = 100;
	final int NILL = -1;
	
	private int[] lookup = new int[MAX];
	
	public void initialize_lookup()
	{
		for(int i =0; i<lookup.length; i++)
			lookup[i] = NILL;
	}
	
	protected int getFibonacci(int n)
	{
		if(lookup[n] == NILL)
		{
			if(n<= 1)
				lookup[n] =n;
			else
				lookup[n] = getFibonacci(n-1)+getFibonacci(n-2);
		}		
		return lookup[n];				
	}
}
