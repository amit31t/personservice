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
public class Prob6_LengthOfLPalindromicSubstring
{
	public static void main(String[] args) 
	{
		String str = "bxczaba";
		int lps = longestPalindromicSubstring(str, 0, str.length()-1 );
		System.out.println("Longest Palindromic Subsequence = "+lps);
 	}

	private static int longestPalindromicSubstring(String str, int left, int right) 
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
		if(str.charAt(left) == str.charAt(right) )
		{
			int remainLPS = right -left -1;
			if(remainLPS == longestPalindromicSubstring(str, left+1, right-1))
				lps = 2 + remainLPS;
		}
		//2 case
		int lps2 = longestPalindromicSubstring(str, left+1, right);
		int lps3 = longestPalindromicSubstring(str, left, right-1);
		return Integer.max(lps, Integer.max(lps2, lps3) );
	}
}
