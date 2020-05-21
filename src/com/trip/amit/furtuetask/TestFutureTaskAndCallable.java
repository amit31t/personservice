package com.trip.amit.furtuetask;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestFutureTaskAndCallable {

	public static void main(String[] args) 
	{
		
		FutureTask[] futureTasks = new FutureTask[5];
		for (int i=0; i<5; i++)
		{
			MyCallableTask callbleTask = new MyCallableTask();
			futureTasks[i] = new FutureTask(callbleTask);
			
			new Thread(futureTasks[i]).start();
		}

		for(int i=0; i<5; i++)
		{
			try 
			{
				System.out.println("future return " + futureTasks[i].get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}	
}

@SuppressWarnings("rawtypes")
class MyCallableTask implements Callable
{
	@Override
	public Object call() throws Exception 
	{
		Random generator = new Random();
		int randonNumber = generator.nextInt(5);
		Thread.sleep(randonNumber * 100);
		return randonNumber;
	}	
}