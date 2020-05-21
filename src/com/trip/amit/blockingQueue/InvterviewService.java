package com.trip.amit.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InvterviewService {

	public static void main(String[] args)
	{
		BlockingQueue<String> bQueue = new ArrayBlockingQueue<String>(3);
		
		InterviewSchedular interviewSchedular = new InterviewSchedular(bQueue);
		
		InterviewProcessor interviewProcessor = new InterviewProcessor(bQueue);
		
		new Thread(interviewSchedular).start();
		new Thread(interviewProcessor).start();
	}

}
