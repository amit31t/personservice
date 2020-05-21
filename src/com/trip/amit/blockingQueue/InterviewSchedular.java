package com.trip.amit.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class InterviewSchedular implements Runnable
{
	BlockingQueue<String> queue;
	
	public InterviewSchedular(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() 
	{
		for(int i=0; i<10; i++)
		{
			String msg = new String("Candidate "+i);
			try
			{
				queue.put("Candidate : "+i);
				System.out.println("Interview schedule for : "+msg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Interview scheduled for all candidates ");
		try
		{
			queue.put("STOP");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
