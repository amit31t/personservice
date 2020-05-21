package com.trip.program.problems;

public class Prob01_LongestCommonPrefix 
{
	public static void main(String[] args) 
	{
		String [] input = {"geeksforgeeks", "geeksfor", "geekeer", "geeser", "gek"};
		String lcp = findLCP01CharbyCharMmatching(input);
		System.out.println("Longest Common Prefix - "+lcp);
		
		//second soln - take 2 strings and find lcp then take lcp and third string and find new lcp and so on....
		String lcp1 = findLCP02WordbyWordMmatching(input);
		System.out.println("Longest Common Prefix - "+lcp1);
		
		//Third soln - As this problem has optimal structure prop so we can apply divide and conquer
		String lcp2 = findLCP03ByDivideAndConquer(input);
		System.out.println("Longest Common Prefix - "+lcp2);
		
		//Fourth Solution -- useof indexof method of string
		String lcp3 = findLCP04(input);
		System.out.println("Longest Common Prefix - "+lcp3);
		
		System.out.println("geeksfor".indexOf("k"));
	}

	private static String findLCP04(String[] input) 
	{
		String prefix ="";
		if(input.length == 0) return prefix;
		
		prefix = input[0];
		for(int i =1; i<input.length; i++)
		{
			while(input[i].indexOf(prefix) != 0)
			{
				prefix = prefix.substring(0, prefix.length()-1);
			}
		}
		return prefix;
	}

	private static String findLCP03ByDivideAndConquer(String[] input) 
	{
		int n = input.length;	
		return findLCPUtil(input, 0, n-1);
	}

	private static String findLCPUtil(String[] input, int low, int high) 
	{
		//base case
		if(low == high)
			return input[low];

		if(high > low)
		{
			int mid = (low + high)/2;
			String str1 = findLCPUtil(input, low, mid);
			String str2 = findLCPUtil(input, mid +1, high);
			
			return LCPForTwoStrings(str1, str2);
		}
		return null;
	}

	private static String LCPForTwoStrings(String str1, String str2)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<Math.min(str1.length(), str2.length()); i++)
		{
			if(str1.charAt(i) != str2.charAt(i))
				break;
			sb.append(str1.charAt(i));
		}
		return sb.toString();
	}
	private static String findLCP02WordbyWordMmatching(String[] input) 
	{
		StringBuilder sb = new StringBuilder(input[0]);
		//String result = null;
		int i, j;
		for(i=1; i<input.length; i++)
		{
			String first = sb.toString();
			String second = input[i];
			sb.delete(0, first.length());
			for(j=0; j<Math.min(first.length(), second.length()); j++)
			{
				if(first.charAt(j) != second.charAt(j))
				{
					break;
				}
				sb.append(first.charAt(j));
			}
		}
		return sb.toString();
	}

	private static String findLCP01CharbyCharMmatching(String [] input) 
	{
		StringBuilder sb = new StringBuilder();
		//loop for character maching in all the strings of array
		int i=0, j; 
		int minLength = input[4].length();//hardcoding here plz calculate actula min length
		//take the minimum length among all the strings
		String first = input[0];// compare till the minimum string lenght
		while(i < minLength)
		{
			char c = first.charAt(i);
			//int index = i;
			for(j =0; j<input.length; j++ )
			{
				if(c != input[j].charAt(i))
				{
					return sb.toString();
				}
			}
			sb.append(c);
			i++;
		}
		return sb.toString();
	}

}
