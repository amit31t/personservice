package com.trip.dsa.recursive;

public class RecursiveMethods {

	public static void main(String[] args) 
	{
		int n =5;
		int fibNo = fibonacciNumber(n);
		System.out.println("FibonacciNumber = "+fibNo);
	}
	
	private static int fibonacciNumber(int n)
	{
		if(n<0)
		{
			System.out.println("Error message");
			return -1;
		}

		else if(n==2 || n==1)
			return n-1;
		else
			return fibonacciNumber(n-1)+fibonacciNumber(n-2);
			
	}

}
