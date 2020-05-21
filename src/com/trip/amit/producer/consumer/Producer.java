package com.trip.amit.producer.consumer;

public class Producer implements Runnable 
{
	private MyBlockingQueue<Item> queue;
	
	public Producer(MyBlockingQueue<Item> queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void run() {
		Item item = new Item();
		for(int i=0; i<10; i++)
		{
			queue.put(item.createItem(i));
		}
	}
}
