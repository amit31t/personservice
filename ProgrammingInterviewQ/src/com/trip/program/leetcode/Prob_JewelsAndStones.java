package com.trip.program.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings J and S. 
  J - represents the type of stones that are jewels, 
  S - represents the stones you have.  
 * Each character in S is a type of stone you have.  You want to know how many of the stones 
 * you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.  
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class Prob_JewelsAndStones 
{
	public static void main(String[] args) 
	{
		String stones = "aAAbbbb";
		String jewels = "aA";
		
		int numberOfJewelStones = numberOfJewelStones(stones, jewels);
		System.out.println("Number of Jewels Stones = "+numberOfJewelStones);
		
		int numberOfJewelStones1 = numberOfJewelStones1(stones, jewels);
		System.out.println("Number of Jewels Stones = "+numberOfJewelStones1);
	}

	private static int numberOfJewelStones1(String stones, String jewels)
	{
		int[] countArray = new int[65]; //array of size 123 - 64
		int count = 0;
		//ASCII value of a to z is 97 to 122
		//ASCII value of A to Z is 65 to 90
		for(char c : stones.toCharArray())
			countArray[c - 'A']++;
		for(char c : jewels.toCharArray())
		{
			if(countArray[c - 'A'] >=0)
			{
				count = count + countArray[c - 'A'];
			}
		}
		return count;
	}

	private static int numberOfJewelStones(String stones, String jewels) 
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		for(char c : stones.toCharArray())
			map.put(c, map.getOrDefault(c, 0)+1);
		
		for(char c : jewels.toCharArray())
			count = count+map.getOrDefault(c, 0);
		
		return count;
	}

}
