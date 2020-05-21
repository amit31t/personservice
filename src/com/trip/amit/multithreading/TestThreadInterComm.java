package com.trip.amit.multithreading;

public class TestThreadInterComm {

	public static void main(String[] args) throws InterruptedException
	{
		Thread1 myRunnable = new Thread1();
		Thread t1 = new Thread(myRunnable);
		t1.start();
/*		try {
			//Thread.sleep(0, 100);
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		synchronized (t1) {
			System.out.println(" t1 "+t1.getClass().getName());
			System.out.println("Thread is Running --" + Thread.currentThread().getName());
			t1.wait();
		}
		System.out.println(" Total = "+myRunnable.total);
	}

}
