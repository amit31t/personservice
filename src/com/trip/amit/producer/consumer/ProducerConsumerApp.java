package com.trip.amit.producer.consumer;

public class ProducerConsumerApp {

	public static void main(String[] args) 
	{
		MyBlockingQueue<Item> myQueue = new MyBlockingQueue<Item>(5);
		
		new Thread(new Producer(myQueue)).start();
		new Thread(new Consumer(myQueue)).start();

	}

}
