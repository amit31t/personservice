package com.trip.program.mix;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MapTest 
{
	//static Map<String, AtomicInteger> orders = new ConcurrentHashMap<String, AtomicInteger>();
	static Map<String, Integer> orders = new HashMap<String, Integer>();
	public static void process()
	{
		Map<String, Integer> synMap = Collections.synchronizedMap(orders);
		for(String key : synMap.keySet())
		{
			for(int i=0; i<50; i++)
				synMap.put(key, synMap.get(key)+1);
		}
	}
	public static void main(String[] args)
	{
		//concurrent hash map
		orders.put("Bangalore", 0);
		orders.put("Hyderabad", 0);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.submit(MapTest :: process);
		service.submit(MapTest :: process);
		
		try {
			service.awaitTermination(1, TimeUnit.SECONDS);
			service.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(orders);
		//weakHashMap
		Map<Order, Integer> map = new WeakHashMap<>();
		map.put(new Order(1), 2);
		Order order = new Order(5);
		map.put(order, 3);
		System.out.println(map.size());
		System.gc();
		System.out.println(map.size());

	}

}

class Order
{
	int x;
	public Order(int x)
	{
		this.x = x;
	}
	
}