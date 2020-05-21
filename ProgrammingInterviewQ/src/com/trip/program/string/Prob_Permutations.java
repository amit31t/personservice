package com.trip.program.string;
/*
 * Print all the permutations of the given string
 */
public class Prob_Permutations 
{
	public static void main(String[] args) 
	{
		String str ="abc";
		char[] strArr = str.toCharArray();
		pernutations(strArr, 0, str.length()-1);
	}

	private static void pernutations(char[] strArr, int l, int r) 
	{
		if( l==r) System.out.println(String.copyValueOf(strArr));
		else
		{
			for(int i =l; i<=r; i++)
			{
				char temp = strArr[i];
				strArr[i] = strArr[l];
				strArr[l] = temp;
				System.out.println("Before recursion "+String.copyValueOf(strArr));
				pernutations(strArr, l+1, r);
				System.out.println("After recursion "+String.copyValueOf(strArr));
				char temp1 = strArr[i];
				strArr[i] = strArr[l];
				strArr[l] = temp1;
			}
		}
		
	}

}
