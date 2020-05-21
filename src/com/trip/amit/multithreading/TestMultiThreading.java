package com.trip.amit.multithreading;

public class TestMultiThreading {

	public static void main(String[] args) throws Exception
	{
		
		testCustomThread();
		System.out.println(" TestMultiThreading " +Thread.currentThread().getName());
		//Thread.currentThread().join();
		//Thread.sleep(10000);
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run() {
				System.out.println("TestMultiThreading Exit");
			}
		});
		
	}

	private static void testCustomThread() throws Exception
	{
/*		//Thread custom = new CustomThread();
		for(int i =0; i<10; i++)
		{
			System.out.println(Thread.currentThread().getName() + " running " +i);
			Thread.yield();
			System.out.println(Thread.currentThread().getName() +" is in control");
		}*/
		//CustomThread t = new CustomThread();
		CustomThread t1 = new CustomThread();
		//t.setName("New Custom");
		t1.setName("Custom");
		t1.start();
		//t1.join();
		//Thread t2 = new Thread(new RunnableTherad());
		Thread t3 = new Thread(new RunnableTherad1(t1));
		t3.start();
		t1.join();
	}

}
