package com.trip.amit.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCalllable {

	public static void main(String[] args) 
	{
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> future = service.submit(new CallableTask());
		System.out.println("Callable Task is running by "+Thread.currentThread());
		try {
			Integer result = future.get();
			System.out.println("Future result is : "+result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static class CallableTask implements Callable<Integer>
	{
		@Override
		public Integer call() throws Exception {
			Thread.sleep(10000);
			System.out.println("Callable Task is running by "+Thread.currentThread());
			return new Random().nextInt();
		}
		
	}
}


