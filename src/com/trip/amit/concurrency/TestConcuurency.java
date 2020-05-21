package com.trip.amit.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestConcuurency 
{
	public static void main(String args[]) throws Exception
	{
/*		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("total core count :"+coreCount);
		ExecutorService exService = Executors.newFixedThreadPool(coreCount);
		for(int i=0; i<10; i++)
		{
			exService.execute(new Task());
		}*/

			//testCustomThread();
			System.out.println(" TestConcuurency " +Thread.currentThread().getPriority());
			Thread.sleep(5000);
			Runtime.getRuntime().addShutdownHook(new Thread(){
				public void run() {
					System.out.println("TestConcuurency Exit");
				}
			});

/*		ScheduledExecutorService exService = Executors.newScheduledThreadPool(10);
		//exService.schedule(new Task(), 10, TimeUnit.SECONDS);
		exService.scheduleAtFixedRate(new Task(), 10, 2, TimeUnit.SECONDS);
		exService.shutdown();
		System.out.println("Running main thread");*/
	}

}
