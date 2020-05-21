package com.trip.program.cracking.coding.interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Prob1_01 - Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 * 
 * Prob1_02 - check if two given strings are permutations
 * 
 */
public class Chapter1_Exercises 
{
	public static void main(String[] args) 
	{
		String input = "abcdeefg";
		
		//Soln1_01 - using hashset
		boolean isUnique = isUniqueChars(input);
		System.out.println("Is Unique Chars String -"+isUnique);
		
		//Soln1_02 - 1.  sort both the strings and then compare
		//2. use array and store the char counts from first str, and then compare with second
		boolean isPermutation = isPermutaions("dof", "god");
		System.out.println("Is Permutations - "+isPermutation);
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a + ", "+b);


	}
	 private static String isSumPrsent(int[] numArray, int n, int sum)
	    {
	        Set<Integer> set =  new HashSet<>();
	        for(int x : numArray)
	        {
	            if(set.contains(x))
	                return "YES";
	            set.add(sum - x);
	        }
	        return "NO";
	    }
	private static boolean isPermutaions(String str1, String str2) 
	{
		if(str1.length() != str2.length()) return false;
		
		int [] letters = new int[128];
		
		for(char c : str1.toCharArray())
		{
			letters[c]++;
		}
		for(int i =0; i<str2.length(); i++)
		{
			int c = str2.charAt(i);
			letters[c]--;
			if(letters[c] < 0)
				return false;
		}
		return true;
	}

	private static boolean isUniqueChars(String input) 
	{
		Set<Character> set = new HashSet<>();
		for(Character c : input.toCharArray())
		{
			if(!set.contains(c))
				set.add(c);
			else
				return false;
		}
		return true;
	}

}
