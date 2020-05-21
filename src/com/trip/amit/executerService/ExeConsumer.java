package com.trip.amit.executerService;

import java.util.List;

public class ExeConsumer implements Runnable
{
	private List<String> queue;
	public ExeConsumer(List<String> queue) 
	{
		this.queue = queue;
	}

	@Override
	public void run() 
	{
		while(true)
		{
			synchronized (queue) {
				if(queue.isEmpty())
				{
					try {
						System.out.println(Thread.currentThread().getName() + " going to wait set");
						queue.wait();
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " consumes the data = "+queue.remove(0));
				queue.notifyAll();
			}
			
		}
		
	}

}
