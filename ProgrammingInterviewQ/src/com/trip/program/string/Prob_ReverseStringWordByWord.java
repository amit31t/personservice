package com.trip.program.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob_ReverseStringWordByWord 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		String [] strTokens = input.split(" ");
		String reverseStr ="";
		for(String str : strTokens)
		{
			String revWord = "";
			char [] strArr = str.toCharArray();
			int i =0, j = strArr.length-1;
			while(i<j)
			{
				char temp = strArr[i];
				strArr[i] = strArr[j];
				strArr[j] = temp;
				i++;
				j--;
			}
			revWord = String.valueOf(strArr)+" ";
			reverseStr = reverseStr + revWord;
		}
		System.out.println("Reverse String "+reverseStr);
	}

}
