package com.trip.dsa.algo.divideAndConquer;

/*Number Factor Problem - Count of different ways to express N as the sum of 1, 3 and 4
	Ex. Input :  N = 4  Output : 4 
  Explanation: 1+1+1+1 
        	 1+3
        	 3+1 
        	 4 
*/
public class Prob1_NumberFactor 
{
	public static void main(String[] args)
	{
		int [] number_rep = {1, 3, 4};
		int number = 5; 
		int totalWays = waysToGetNumber(number_rep, number);
		System.out.println("Total ways to express "+number + "as 1, 3, 4 - is "+totalWays);
	}

	private static int waysToGetNumber(int[] number_rep, int number) 
	{
		//1. base case when number = 1
		if(number ==0 || number == 1 || number == 2)
			return 1;
		
		if(number==3) return 2; //{1 1 1} and {3} 
		//2. find the total ways from n-1
		int i1 = waysToGetNumber(number_rep, (number-number_rep[0]));
		
		//2. find the total ways from n-3
		int i2 = waysToGetNumber(number_rep, (number-number_rep[1]));
				
		//2. find the total ways from n-4
		int i3 = waysToGetNumber(number_rep, (number-number_rep[2]));
		
		return i1 +i2 +i3;
	}
}