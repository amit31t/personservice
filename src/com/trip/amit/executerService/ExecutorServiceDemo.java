package com.trip.amit.executerService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	public static void main(String[] args) 
	{
		final int size = 3;
		List<String> queue = new ArrayList<String>(size);
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		ExeProducer prodTask = new ExeProducer(queue, size);
		ExeConsumer consTask = new ExeConsumer(queue);
		service.submit(prodTask);
		//service.submit(prodTask);	
		service.submit(consTask);
		
	}

}
