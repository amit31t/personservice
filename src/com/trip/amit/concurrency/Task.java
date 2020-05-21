package com.trip.amit.concurrency;

public class Task implements Runnable
{

	@Override
	public void run() {
		System.out.println("Thread :"+Thread.currentThread() + " is executing the task ");
		
	}

}
