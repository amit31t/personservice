package com.trip.program.string;

public class ProgramStrings {

	public static void main(String[] args) 
	{
		//Q1 reverse the given string without using String reverse method
		reverseTheGivenString();
	}

	//Q1 reverse the given string without using String reverse method
	private static void reverseTheGivenString() 
	{
		String str = "Amit";
		char[] reverseArray = new char[str.length()];
		
		for(int i =0; i<str.length(); i++ )
		{
			reverseArray[i] = str.charAt((str.length()-1)-i);
		}
		System.out.println("Reverse String is - "+String.copyValueOf(reverseArray));
	}

}
