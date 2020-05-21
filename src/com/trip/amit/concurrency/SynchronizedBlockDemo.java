package com.trip.amit.concurrency;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBlockDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		List<String> list = new ArrayList<String>();
		NameTask task1 = new NameTask("amit", list);
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(new NameTask("t", list));
		t2.start();
		//new Thread(task1).start();
		//new Thread(task1).start();
		t1.start();
		t1.join(); t2.join();
		System.out.println("List added Name : "+list);
	}

}

class NameTask implements Runnable
{
	String listName ="";
	private static int count = 0;
	String name1;
	private List<String> myList;
	
	public NameTask(String name1, List<String> myList)
	{
		this.name1 = name1;		
		this.myList = myList;
	}

	@Override
	public void run() 
	{
		updateAndaddName(name1, myList);
	}
	
	private void updateAndaddName(String name, List<String> list)
	{
		synchronized (this) {
			listName = name; 
			count++;
		}	
		System.out.println("Number of times name updated = "+count);
		list.add(listName);
		
	}
}