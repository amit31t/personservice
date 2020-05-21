package com.trip.program.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * Prob01- Longest Sub String without Repeating Chars
 * 
 */
public class Prob_LongestSubString 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		//Soln-1
		int ls_lenght = longestSubStringNonRepeatingChars(input);
		System.out.println("Longest SubString Lenght "+ls_lenght);
		
		//Soln-2 
		int ls_lenght1 = longestSubStringNonRepeatingCharsUsingSet(input);
		System.out.println("Longest SubString Lenght "+ls_lenght1);
	}

	//use hashset O(n) 
	private static int longestSubStringNonRepeatingCharsUsingSet(String input) 
	{
		int a_pointer=0, b_pointer=0;
		int max_length = 0;
		Set<Character> set = new HashSet<Character>();
		while(b_pointer < input.length())
		{
			if(!set.contains(input.charAt(b_pointer)))
			{
				set.add(input.charAt(b_pointer));
				max_length = Math.max(set.size(), max_length);
				b_pointer++;
			}			
			else
			{
				set.remove(input.charAt(a_pointer));
				a_pointer++;
			}
		}
		return max_length;
	}

	//soln-1 - iterating with two pointers O(n2)
	// str = "a b c a d e"
	private static int longestSubStringNonRepeatingChars(String input) 
	{
		int max_lenght =0; int n = input.length();
		int max_local;
		for(int i =0; i<n; i++)
		{
			max_local=1;
			for(int j=i+1; j<n; j++)
			{
				if(input.charAt(i) != input.charAt(j))
					max_local++;
				else
				{
					max_lenght = Math.max(max_lenght, max_local);
					break;
				}
			}
		}
		return max_lenght;
	}

}
