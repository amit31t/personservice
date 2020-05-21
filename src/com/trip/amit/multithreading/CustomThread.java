package com.trip.amit.multithreading;

public class CustomThread extends Thread
{
	@Override
	public void run()
	{
		//Thread.currentThread().setName("CustomThread");
		System.out.println(Thread.currentThread().getName() + " is "+Thread.currentThread().getState());
		//Thread.threadLocals;
		for(int i =0; i<8; i++)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception E){}
			System.out.println(Thread.currentThread().getName() + " running " +i);
			System.out.println(Thread.currentThread().getName() +" is in control");
		}
		System.out.println(Thread.currentThread().getName() + " done its job");
	}
}


class RunnableTherad1 extends RunnableTherad
{
	Thread t;
	public RunnableTherad1(Thread t) {
		this.t =t;
	}
	@Override
	public void run() 
	{
		Thread.currentThread().setName("RunnableTherad1");
		Thread.currentThread().setPriority(1);
		System.out.println(Thread.currentThread().getName() + " is "+Thread.currentThread().getState());	
		
		for(int i =0; i<10; i++)
		{
			
			try
			{
				t.join();
				Thread.sleep(1000);
			}
			catch(Exception E){}
			System.out.println(Thread.currentThread().getName() + " running " +i);
			System.out.println(Thread.currentThread().getName() +" is in control");
		}
		System.out.println(Thread.currentThread().getName() + " done its job");
	}
	
}