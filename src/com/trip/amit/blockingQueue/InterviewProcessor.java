package com.trip.amit.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class InterviewProcessor implements Runnable
{
	BlockingQueue<String> queue;
	
	public InterviewProcessor(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() 
	{
		try
		{
			String msg;
			//Thread.sleep(10000);
			while(!(msg = queue.take()).equals("STOP"))
			{
				System.out.println("Interview completed for : " +msg);
				Thread.sleep(10000);
			}
			System.out.println("Interview completed for all the students ");
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}

	}
}
