package com.trip.amit.producer.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdConsApp {

	public static void main(String[] args)
	{
		final BlockingQueue<String> blQueue = new ArrayBlockingQueue<String>(2);
		final Runnable producer = () -> {
			while(true)
			{
				try {
					blQueue.put("item");
					System.out.println("Item added item");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		new Thread(producer).start();
		new Thread(producer).start();
		
		final Runnable consumer = () -> {
			while(true)
			{
				try {
					String i = blQueue.take();
					System.out.println("Item processed "+i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		new Thread(consumer).start();
		new Thread(consumer).start();

	}

}
