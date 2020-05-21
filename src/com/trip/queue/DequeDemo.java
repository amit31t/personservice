package com.trip.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeDemo {

	public static void main(String[] args) 
	{
		testArrayDeque();

	}

	private static void testArrayDeque()
	{
		Deque<Integer> d_que = new ArrayDeque<Integer>(5);
		d_que.add(2); d_que.add(3); d_que.add(4); d_que.offer(5); d_que.offer(6);
		System.out.println("Array Deque :- "+d_que);
		
		System.out.println(d_que.peekFirst());
		System.out.println("Array Deque :- "+d_que);
		System.out.println(d_que.pollFirst());
		System.out.println("Array Deque :- "+d_que);
		d_que.addFirst(10);
		System.out.println("Array Deque :- "+d_que);
		System.out.println("Offer last value " +d_que.offerLast(12));
		System.out.println("Array Deque :- "+d_que);
		Iterator<Integer> itr = d_que.descendingIterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+ " ");
		}
		System.out.println();
		//d_que.clear();
		d_que.push(1111); d_que.push(2222);
		System.out.println(d_que);
		d_que.pop();
		System.out.println(d_que);
	}

}
