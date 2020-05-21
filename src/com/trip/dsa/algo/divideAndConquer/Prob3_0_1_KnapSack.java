package com.trip.dsa.algo.divideAndConquer;

/*
 * 0/1 knapsack problem
– Given the weights and profits of “N” items.
– Need to put these items in knapsack(bag) with capacity “C”
– Restriction is, that we can not break the item into smaller units(no fractional unit)
– Find the max profit from the items in the knapsack
Ex. items = { mango, banana, orange, apple} , profits={31, 26, 72, 17} 
       weights = {3, 1, 5, 2} knapsack capacity 7 
*/
public class Prob3_0_1_KnapSack 
{
	public static void main(String[] args)
	{
		//int items = 4; 
		int [] profits = {31, 26, 72};
		int [] weights = {3, 1, 5};
		int knapsack_capacity = 7; 
		int maxProfit = maxProfitInknapSack(profits, weights, knapsack_capacity, 0);
		System.out.println("Max profit from knapsack = "+maxProfit );
	}

	private static int maxProfitInknapSack(int[] profits, int[] weights,int knapsack_capacity, int current_index) 
	{
		//base Condition
		if(knapsack_capacity <=0 || current_index <0 || current_index >= profits.length)
			return 0;
		
		//if include first item
		int profit1=0;
		if(weights[current_index] <= knapsack_capacity)
		{
			profit1 = profits[current_index] + maxProfitInknapSack(profits, weights, knapsack_capacity - weights[current_index], current_index+1);
		}
		
		//If first item not included
		int profit2 = 0 + maxProfitInknapSack(profits, weights, knapsack_capacity, current_index +1);
			
		return Math.max(profit1, profit2);
	}
}