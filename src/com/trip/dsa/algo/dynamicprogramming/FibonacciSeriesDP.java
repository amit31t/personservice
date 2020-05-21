package com.trip.dsa.algo.dynamicprogramming;

public class FibonacciSeriesDP {

	public static void main(String[] args) 
	{	
		//Fibonacci series - 0, 1, 1, 2, 3, 5, 8, 13, 21,34 (fn = fn-1 + fn-2)
		int number = 9;
		int fibNumber = getFibonacciNumberByRecursion(number);
		int fibNumber1 = getFibonacciNumberByTabulationDP(number);
		int fibNumber3 = getFibonacciNumberByMemoizationDP(number);
		System.out.println("Fibonacci Number at "+number + " = "+fibNumber);
		System.out.println("Fibonacci Number at "+number + " = "+fibNumber1);
		System.out.println("Fibonacci Number at "+number + " = "+fibNumber3);
	}
	
	/*
	 * this is Top down approach, save result of subproblems in lookup table(array) 
	 * to use later when required
	 */
	private static int getFibonacciNumberByMemoizationDP(int n) 
	{
		FibonacciByMemoization fbm = new FibonacciByMemoization();
		fbm.initialize_lookup();
		return fbm.getFibonacci(n);
	}
	/*
	 * this is bottom up approach, save result of subproblems in table(array) 
	 * to use later when required
	 */
	private static int getFibonacciNumberByTabulationDP(int number)
	{
		int [] table = new int [number +1];
		table[0] = 0; table[1] =1;
		for(int i=2; i<=number; i++)
		{
			table[i] = table[i -1 ] + table[i -2];
		}
		return table[number];
	}

	private static int getFibonacciNumberByRecursion(int n) 
	{
		if(n == 0 )return 0;
		if(n == 1) return 1;
		return getFibonacciNumberByRecursion(n-1) +getFibonacciNumberByRecursion(n-2);
	}
	
}
