package com.trip.java.basics.trickQuestions;

public class Tricky 
{
	public Tricky(int i)
	{
		System.out.println("Tricky " +i);
	}
	
	static Tricky t = new Tricky(1);
	public static void main(String[] args)
	{
		Tricky t = new Tricky(2);
	}

}
