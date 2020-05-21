package com.trip.program.cracking.coding.interviews;

import java.util.Arrays;

/*
 * Triple Step: A child is running up a staircase with n steps and can hop 
 * either 1 step, 2 steps, or 3 steps at a time, implement a method to count 
 * how many possible ways the child can run up the stairs.
 */
public class Prob8_01_TripleStep 
{
	public static void main(String[] args) 
	{
		int n = 5; // number of steps in stairs
		//soln01 by D&C
		int possWays = totalPossibleWays(n);
		System.out.println("Total possible ways by D&C = "+possWays);
		
		//soln02 by Memoization(DP)
		int [] memo = new int [n+1];
		Arrays.fill(memo, -1);
		int possWays1 = totalWaysByMemo(n, memo);
		System.out.println("Total possible ways by D&C = "+possWays1);
		
		//soln03 by Tabluization (DP)
		int possWays2 = totalWaysByTablulization(n);
		System.out.println("Total possible ways by D&C = "+possWays2);
		
	}

	private static int totalWaysByTablulization(int n) 
	{
/*		if(n < 0 ) return 0;
		if(n == 0)return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;*/
		int [] memo = new int [n];
		//memo[0] =1;
		memo[0] = 1;
		memo[1] = 2;
		memo[2] = 4;
		for(int i = 3; i<n; i++)
		{
			memo[i] = memo[i-1] +memo[i-2] + memo[i-3];
		}
		
		return memo [n-1];
	}

	private static int totalWaysByMemo(int n, int[] memo) 
	{
		/*if(n == 0 ) return 0;
		if(n == 1)return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;*/
		if(n<0)return 0;
		else if(n==0 ) return 1;
		else if(memo[n] > -1) return memo[n];
		else
			memo[n] = totalWaysByMemo(n-1, memo) + totalWaysByMemo(n-2, memo) + totalWaysByMemo(n-3, memo);
		return memo[n];
	}

	private static int totalPossibleWays(int n) 
	{//base cases
		if(n < 0 ) return 0;
		if(n == 0)return 1;
		//if(n == 2) return 2;
		//if(n == 3) return 4;
		
		int total1 = totalPossibleWays(n-1);
		int total2 = totalPossibleWays(n-2);
		int total3 = totalPossibleWays(n-3);
		
		return total1+total2+total3;
	}

}
