package com.trip.amit.executerService;

import java.time.LocalDateTime;
import java.util.List;

public class ExeProducer implements Runnable
{
	private List<String> queue;
	private int size;
	
	public ExeProducer(List<String> queue, int size) 
	{
		this.queue = queue;
		this.size = size;
	}

	@Override
	public void run() 
	{
		String data = LocalDateTime.now().toString();
		while(true)
		{
			synchronized (queue) {
				if(queue.size()== size)
				{
					try {
						System.out.println(Thread.currentThread().getName() + " going to wait set");
						queue.wait();
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				queue.add(data);
				System.out.println(Thread.currentThread().getName() + " produces the data "+data);
				queue.notifyAll();
			}
			
		}
		
	}

}
