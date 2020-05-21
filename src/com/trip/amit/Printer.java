package com.trip.amit;

public class Printer 
{
	public void printDoc(int numOfCopies, String docName)
	{
		for(int i=0; i<numOfCopies;i++)
		{
			System.out.println(">> Printing "+docName +" #"+i);
		}
	}
}
