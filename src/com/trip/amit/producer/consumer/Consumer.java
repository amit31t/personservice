package com.trip.amit.producer.consumer;

public class Consumer implements Runnable
{
	private MyBlockingQueue<Item> queue;
	
	public Consumer(MyBlockingQueue<Item> queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true )
		{
			Item item = queue.take();
			item.process(item);
		}
	}
}
