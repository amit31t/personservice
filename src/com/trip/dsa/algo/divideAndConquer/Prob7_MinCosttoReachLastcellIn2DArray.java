package com.trip.dsa.algo.divideAndConquer;
/*
 * Given 2D matrix, each cell have a cost associated with it.
 * Start from (0,0) and reach (n-1, n-1) with min cost
 * we can go only right or down from the cell
 * 	| 2   3   2 |
 * 	| 5   1   4 |
 * 	| 6   7   2 |  Ans is 2+3+1+4+2 =12
 * it has optimal structure prop so we can go to D&C
 * case1- go right from current cell M(i,j) + f(i+1, j)
 * case2- go down from current cell M(i,j) + f(i, j+1)
 * 
 */
public class Prob7_MinCosttoReachLastcellIn2DArray {

	public static void main(String[] args) 
	{
		int [][] cost = {{2, 3, 2}, {5, 1, 4}, {6, 7, 2}};
		int n = cost.length;
		int minCost = minCosttoReachLastcellIn2DArray(cost, 0, 0, n-1);
		System.out.println("Minimum cost to reach end of the cell = "+minCost);

	}

	private static int minCosttoReachLastcellIn2DArray(int[][] cost, int i, int j, int k) 
	{
		//base case
		if(i > k || j > k) return Integer.MAX_VALUE/100; //devide by 100 so arithmatic overflow does not occurs
		if(i == k && j == k)return cost[k][k];
		//case1
		int c1 = cost[i][j] +  minCosttoReachLastcellIn2DArray(cost, i+1, j, k); 
		
		//case2
		int c2 =  cost[i][j] + minCosttoReachLastcellIn2DArray(cost, i, j+1, k); 
		
		//int currentCellCost = cost[i][j];
		return Integer.min(c1, c2);
	}

}
