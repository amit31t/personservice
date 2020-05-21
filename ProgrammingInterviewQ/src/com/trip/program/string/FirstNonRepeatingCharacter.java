package com.trip.program.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) 
	{
		//input string only contains only lower case English letters l
		String input = "aabccd";
		char result = '_';
		//first solution using inner loop
		//result = firstNonRepeatingCharInString(input);
		
		//Second solution using haspmap
		//result = firstNonRepeatingCharInStringUsingHashMap(input);
		
		//Third Solution - define any int array for all charachters size i.e 26 and put count as char occurs
		//result = firstNonRepeatingCharInStringUsingIntArray(input);
		//fourth solution 
		char [] chars = input.toCharArray();
		for(int i =0;i<input.length();i++)
		{			
			if(input.indexOf(chars[i]) == input.lastIndexOf(chars[i]))
			{
				result = input.charAt(i); 
				break;
			}
		}
		System.out.println("First Non repeating character = "+result);
	}

	private static char firstNonRepeatingCharInStringUsingIntArray(String input) 
	{
		int [] char_counts = new int[26]; //[0, 0, 0 ,......0]
		for(int i =0; i<input.length(); i++)
		{
			char c = input.charAt(i);
			char_counts[c -'a']++;
		}
		for(int i =0; i<input.length(); i++)
		{
			if(char_counts[input.charAt(i) - 'a'] == 1)
				return input.charAt(i);
		}
		return '_';
	}

	//this solution takes O(n) time and O(n) space
	private static char firstNonRepeatingCharInStringUsingHashMap(String input) 
	{
		Map<Character, Integer> map = new HashMap<>();
		for(int i =0; i<input.length(); i++)
		{
			if(map.containsKey(input.charAt(i)))
				map.put(input.charAt(i), map.get(input.charAt(i))+1 );
			else
				map.put(input.charAt(i), 1);
		}
		
		for(int j=0; j<input.length();j++)
		{
			if(map.get(input.charAt(j))==1)
				return input.charAt(j);
		}
		return '_';
	}

	//this solution takes O(n2) time
	private static char firstNonRepeatingCharInString(String input) 
	{
		for(int i =0; i<input.length(); i++)
		{
			boolean seenDuplicate = false;
			for(int j = 0; j<input.length(); j++)
			{  
				if(input.charAt(i) == input.charAt(j) && (i != j))
				{
					seenDuplicate = true;
					break;
				}
			}
			if(!seenDuplicate)
				return input.charAt(i);
		}
		return '_';
	}

}
