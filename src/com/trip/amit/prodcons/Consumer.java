package com.trip.amit.prodcons;

public class Consumer extends Thread
{
	private Producer producer;
	
	public Consumer(Producer producer) {
		super();
		this.producer = producer;
	}

	public void run()
	{
		while(true)
		{
			try
			{
				String data = producer.consume();
				System.out.println(Thread.currentThread().getName() + "  consumes data "+data);
				Thread.sleep(1000);
			}catch(InterruptedException e){}
		}
	}
}
