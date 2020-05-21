package com.question.trip;

import java.util.Scanner;

public class ReverseEachWordInAGivenString 
{
	//test case
	//number of test cases = 2
	//first string = "i.like.this.program.very.much"
	//second string = "pqr.mno"
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int testCasesCount = scanner.nextInt();
		String str;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<=testCasesCount; i++)
		{
			str = scanner.next();
			String [] words = str.split("\\.");
			for(String s : words)
			{
				sb.append(s+".");
			}
			System.out.println(sb.toString());
		}
		scanner.close();

	}

}
