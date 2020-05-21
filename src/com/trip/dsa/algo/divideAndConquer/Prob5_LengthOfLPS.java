package com.trip.dsa.algo.divideAndConquer;

import java.util.Arrays;
/*
 * longest palindromic subsequence 
 * Ex. String = "abxa" in this aba is the subsequence which is palindrome
 * 
 * 1- a b x a - if first and last chars are same then -> 2 + f(i+1, j-1)
 * 2- a b x a - if first and last not same then check first +1 with last -> 0 + f(i+1, j)
 * 3- a b x a - if first and last not same then check last -1 with first -> 0 + f(i, j-1)
 * take max of (2, 3)
 */
public class Prob5_LengthOfLPS
{
	public static void main(String[] args) 
	{
		String str = "zabxaz";
		int lps = longestPalindromicSubsequence(str, 0, str.length()-1 );
		System.out.println("Longest Palindromic Subsequence = "+lps);
 	}

	private static int longestPalindromicSubsequence(String str, int left, int right) 
	{
		//base case
		if(left > right)
		{
			return 0;
		}
		if(left == right)
		{
			return 1;
		}		
		int lps =0;
		//1 case
		if(str.charAt(left) == str.charAt(right))
		{
			lps = 2 + longestPalindromicSubsequence(str, left+1, right-1);
		}
		//2 case
		int lps2 = longestPalindromicSubsequence(str, left+1, right);
		int lps3 = longestPalindromicSubsequence(str, left, right-1);
		return Integer.max(lps, Integer.max(lps2, lps3) );
	}
}
