package com.trip.amit.prodcons;

public class ProducerConsumerProblem {

	public static void main(String[] args) 
	{
		Producer pr = new Producer();
		pr.setName("producer-1");
		
		Producer pr1 = new Producer();
		pr1.setName("producer-2");
		
		Consumer cr = new Consumer(pr);
		cr.setName("consumer-1");
		
/*		Consumer cr1 = new Consumer(pr);
		cr1.setName("consumer-2");*/
		
		pr.start(); //pr1.start(); 
		cr.start();// cr1.start();
	}

}
