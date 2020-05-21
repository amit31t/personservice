package com.trip.amit.multithreading;

public class RunnableTherad implements Runnable
{
	@Override
	public void run() 
	{
		System.out.println(Thread.currentThread().getId() + " is "+Thread.currentThread().getState());		
	}
}
