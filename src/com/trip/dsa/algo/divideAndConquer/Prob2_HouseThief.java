package com.trip.dsa.algo.divideAndConquer;

/*
 * House Thief Problem
	So we are given the houses which are built in a line. Each of these houses contains some value in it. 
	Now a thief who is going to steal the maximum value from these houses but he cannot be in two adjacent houses.

	Ex. input- houses_money = {6, 7 ,1, 30, 8, 2, 4}
	output  - thief will steal money = 41 from houses# 7, 30, 4	
*/
public class Prob2_HouseThief 
{
	public static void main(String[] args)
	{
		int [] house_wealth = {6, 7, 1, 30, 8, 2, 4};
		int current_index =0;
		int totalMoney = maxMoneyRecursive(house_wealth, current_index);
		System.out.println("Total money stole by thief = " + totalMoney);
	}

	private static int maxMoneyRecursive(int[] house_wealth, int current_index) 
	{
		//1. base condition
		if(current_index > house_wealth.length-1) return 0;
		
		//2. strategy#1 - include first house for stealing
		int includeFirst = house_wealth[current_index] + maxMoneyRecursive(house_wealth, current_index +2); // If include first then we can not consider 2nd due to adjacent house
		
		//3. strategy#1 - skip first house for stealing
		int skipFirst = maxMoneyRecursive(house_wealth, current_index +1); // If include first then we can not consider 2nd due to adjacent house
		
		int result = Math.max(includeFirst, skipFirst);
		return result;
	}

	
}