package com.trip.queue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TestBlockingQueues {

	public static void main(String[] args) 
	{
		try
		{
			//testArrayBlockingQueue();
			testPriorityBlockingQueue();
		}
		catch(Exception e ){};
		
		Runtime.getRuntime().addShutdownHook(new Thread(){ public void run(){System.out.println("Main Exit :"+Thread.currentThread().getName());}});

	}

	private static void testPriorityBlockingQueue() 
	{
		PriorityBlockingQueue<String> pbq = new PriorityBlockingQueue<String>(5);
		pbq.add("abc");pbq.add("def");
		pbq.offer("123");	pbq.offer("456");	pbq.put("1ass"); 
		pbq.put("888");
		System.out.println("Priority Blocking Queue : "+pbq);
		System.out.println("Remaining capacity : "+pbq.remainingCapacity());
	}

	private static void testArrayBlockingQueue() throws Exception
	{
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(5, false);
		bq.add("abc");bq.add("abc1");bq.add("abc2");bq.add("abc3"); bq.offer("def"); 
		System.out.println("Array Blocking Queue elements"  +bq);
		//adding more element beyond capacity
		bq.take();
		bq.peek();bq.poll();
		bq.put("1abc2");
		ArrayList<String> list = new ArrayList<>();
		int eleNumber = bq.drainTo(list, 2);
		System.out.println("Array Blocking Queue elements after adding "  +bq);
		System.out.println("Drain list "  +list + "number of elements : "+eleNumber);
	}

}
