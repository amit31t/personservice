package com.trip.amit.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Semaphore sem = new Semaphore(1);
		MyThread t1 = new MyThread(sem, "A");
		MyThread t2 = new MyThread(sem, "B");
		MyThread t3 = new MyThread(sem, "C");
		t1.start(); t2.start(); t3.start();
		//waiting main thread to completes t1 and t2 both
		t1.join(); t2.join(); t3.join();
		System.out.println("Final Count is = "+Shared.count);
	}

}

class Shared
{
	static int count;
}

class MyThread extends Thread
{
	private Semaphore sem;
	private String threadName;
	public MyThread(Semaphore sem, String threadName) 
	{
		super(threadName);
		this.sem = sem;
		this.threadName = threadName;
	}
	
	public void run()
	{
		if(this.getName().equals("A"))
		{
			System.out.println("Starting......"+threadName);
			try 
			{
				System.out.println(threadName +" is waiting to acquire lock permit.. ");
				 // acquiring the lock 
				sem.acquire();
				
				//Threads gets the permit
			    System.out.println(threadName + " gets a permit."); 
				for(int i =0;i<3;i++)
				{
					Shared.count++;
					System.out.print(" "+Shared.count);
					System.out.println();
					//Now, allowing a context switch -- if possible. for thread B to execute 
					Thread.sleep(20);
				}
				System.out.println(threadName + " release the lock.");
				sem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Starting......"+threadName);
			try 
			{
				System.out.println(threadName +" is waiting to acquire lock permit.. ");
				 // acquiring the lock 
				sem.acquire();
				
				//Threads gets the permit
			    System.out.println(threadName + " gets a permit."); 
				for(int i =0;i<5;i++)
				{
					Shared.count--;
					System.out.print(" "+Shared.count);
					System.out.println();
					//Now, allowing a context switch -- if possible. for thread A to execute 
					Thread.sleep(20);
				}
				System.out.println(threadName + " release the lock.");
				sem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}









