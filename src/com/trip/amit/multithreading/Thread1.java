package com.trip.amit.multithreading;

public class Thread1 implements Runnable
{
	int total =0;
	@Override
	public void run()
	{
		for (int i =0; i<=100; i++)
		{
			total = total +i;
		}
		synchronized (this) {
			System.out.println(" This "+this.getClass().getName());
			System.out.println("Thread is Running --" + Thread.currentThread().getName());
			notify();
		}
	}

}
