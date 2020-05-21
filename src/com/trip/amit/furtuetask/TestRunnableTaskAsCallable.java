package com.trip.amit.furtuetask;

import java.util.Random;

public class TestRunnableTaskAsCallable {

	public static void main(String[] args) 
	{
		MyRunnableTask[] task = new MyRunnableTask[5];
		for(int i=0; i<5; i++)
		{
			task[i] = new MyRunnableTask();
			new Thread(task[i]).start();
		}
		
		for(int i=0; i<5; i++)
		{
			try {
				System.out.println("Runnable Task result "+task[i].get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class MyRunnableTask implements Runnable
{
	private Object result = null;
	@Override
	public void run() 
	{
		Integer randomnumber = new Random().nextInt();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = randomnumber;
		synchronized (this) {
			notifyAll();
		}	
	}
	
	public  Object get() throws InterruptedException
	{	
		while(result == null)
		{
			synchronized(this)
			{
				wait();
			}
		}
		return result;
	}
}