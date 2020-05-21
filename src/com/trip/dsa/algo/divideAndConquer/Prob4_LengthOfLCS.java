package com.trip.dsa.algo.divideAndConquer;

import java.util.Arrays;

public class Prob4_LengthOfLCS
{
	static int [][] L;
	public static void main(String[] args) 
	{
		String str1 = "ab";
		String str2 = "cabc";
		
		//Find the longest common subsequence in str1 & str2. this method return the length of subsequence
		int lenLCS = recursiveLCS(str1, str2, 0, 0);
		System.out.println("LCS length by recursion = "+lenLCS);
		
		//Find the longest common subsequence in str1 & str2 by using memoization
		int lenLCS1 = memoizationLCS(str1, str2, str1.length(), str2.length());
		System.out.println("LCS length by memoization = "+lenLCS1);
		
		//print the longest common subsequence
		char[] lcsString = printLCS(str1, str2, lenLCS1);
		System.out.println("LCS String= "+Arrays.toString(lcsString));
 	}

	private static int memoizationLCS(String str1, String str2, int n, int m)
	{
		L = new int [n+1][m+1];
		
		for(int i =0; i<=n;i++)
		{
			for(int j=0; j<=m; j++)
			{
				if(i == 0 || j == 0)
					L[i][j] = 0;
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					L[i][j] = 1 + L[i-1][j-1];
				else
					L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
			}
		}
		
		return L[n][m];
	}
	/*
	 * 2) Traverse the 2D array starting from L[m][n]. Do following for every cell L[i][j]
		a) If characters (in X and Y) corresponding to L[i][j] are same (Or X[i-1] == Y[j-1]), then include this character as part of LCS.
		b) Else compare values of L[i-1][j] and L[i][j-1] and go in direction of greater value.
	 * 
	 */
	private static char[] printLCS(String str1, String str2, int lenLCS1)
	{
		char[] lcsStr = new char[lenLCS1];
		
		int i = str1.length();
		int j = str2.length(); 
		while(i > 0 && j>0)
		{
			if(str1.charAt(i-1) == str2.charAt(j-1))
			{
				lcsStr[lenLCS1 -1] = str1.charAt(i-1);
				i--; j--; lenLCS1--;
			}
			else if(L[i][j-1] > L[i-1][j])
			{
				j--;
			}
			else
				i--;
		}
		
		return lcsStr;
	}

	private static int recursiveLCS(String str1, String str2, int i, int j) 
	{
		//base condition
		if(i >= str1.length() || j >= str2.length()) 
		{
			return 0;
		}
			
		int lcsL =0;
		if(str1.charAt(i)== str2.charAt(j))
		{
			lcsL = 1+ recursiveLCS(str1, str2, i+1, j+1);
		}
		int lcsL1 = Math.max(recursiveLCS(str1, str2, i, j+1), recursiveLCS(str1, str2, i+1, j));
	
		return Integer.max(lcsL, lcsL1);
	}

}
