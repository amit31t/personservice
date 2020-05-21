package com.trip.amit.prodcons;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread
{
	//max size for the queue
	public static final int MAX_SIZE = 2;
	//define the queue, here using arrayList as a queue
	List<String> queue = new ArrayList<>(2);
	
	public void run()
	{
		while(true)
		{
			try
			{
				produce();
			}
			catch(InterruptedException ex){};
		}
	}

	private synchronized void produce() throws InterruptedException
	{
		if(queue.size() == MAX_SIZE)
		{
			System.out.println(" Before producer wait");
			wait();
			System.out.println("After producer wait");
		}
		String data = LocalDateTime.now().toString();
		queue.add(data);
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " produces data : "+data);
	}
	
	public synchronized String consume() throws InterruptedException
	{
		if(queue.size() == 0)
		{
			wait();
		}
		String s = queue.get(0);
		queue.remove(s);
		System.out.println("Producer notified");
		notifyAll();
		return s;
	}
}
