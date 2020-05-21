package com.trip.amit;

public class SyncApp {

	public static void main(String[] args)
	{
		System.out.println("== Application Started ==");
		Printer printer = new Printer();
		
		//Thread1
		new myThread(printer).start();
		
		//Thread2
		new Thread(new myThread1(printer)).start();

		System.out.println("== Application Finished ==");
	}
}

class myThread extends Thread
{
	Printer pref;
	public myThread(Printer p)
	{
		this.pref = p;
	}
	public void run()
	{
		pref.printDoc(50, "Amit's profile ");
	}
}

class myThread1 implements Runnable
{
	Printer pref;
	public myThread1(Printer p)
	{
		this.pref = p;
	}
	public void run()
	{
		pref.printDoc(10, "Trip's profile ");
	}
}

