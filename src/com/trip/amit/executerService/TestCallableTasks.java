package com.trip.amit.executerService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestCallableTasks {

	public static void main(String[] args) 
	{
		//callable task by extending Callable interface
		ExecutorService service = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		Future<Integer> future= service.submit(new MyCallableTask());
		
		//callable task by converting from runnable task
		MyRunnableTask myRunnableTask = new MyRunnableTask(100);
		Callable<Integer> convertedCallableTask = Executors.callable(myRunnableTask, myRunnableTask.total ); 
		Future<Integer> future1= service.submit(convertedCallableTask);
		
		int callableResult =0; 
		int runableResult = 0;
		try 
		{
			callableResult = future.get(1, TimeUnit.SECONDS);
			runableResult = future1.get();
		} 
		catch (InterruptedException | ExecutionException | TimeoutException  e) 
		{
			e.printStackTrace();
		}
		System.out.println("Result of callable task is = "+callableResult);
		System.out.println("Result of Rubnnable task is = "+runableResult);
		service.shutdown();
	}

}

class MyCallableTask implements Callable<Integer>
{

	@Override
	public Integer call() throws Exception 
	{
		int total =0;
		for(int i =0; i<=100; i++)
		{
			total = total +i;
		}
		return total;
	}
	
}

class MyRunnableTask implements Runnable
{
	int total;
	
	public MyRunnableTask(int total) {
		this.total = total;
	}

	@Override
	public void run() 
	{
		int sum =0;
		for(int i =0; i<=100; i++)
		{
			sum = sum +i;
		}	
		System.out.println("MyRunnableTask total " +sum);
		this.total = sum;
	}
}