package com.trip.amit.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E>
{
	private Queue<Item> myQueue = new LinkedList<Item>();
	private int max =16;
	private ReentrantLock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	
	public MyBlockingQueue(int size)
	{
		this.max = size;
	}
	public void put(Item item)
	{
		lock.lock();
		try
		{
			if(myQueue.size() == max)
			{
				notFull.await();
			}
			myQueue.add(item);
			notEmpty.signalAll();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
		
	}
	
	public Item take()
	{
		Item item = null;
		lock.lock();
		try
		{
			if(myQueue.size() == 0)
			{
				notEmpty.await();
			}
			item = myQueue.remove();
			notFull.signalAll();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
		return item;
	}
	
	public boolean empty()
	{
		return myQueue.isEmpty();
	}
	
}
