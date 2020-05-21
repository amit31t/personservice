package com.trip.java8feaures.lambda;

import java.util.function.BiConsumer;

public class LambdaExceptionHandling {

	public static void main(String[] args) 
	{
		int [] numbers = {1, 2, 3, 4, 5};
		int key = 0;
		
		//to handle exception in lambda with wrapper lambda
		process(numbers, key, wrapperlambda((a, b) -> System.out.println(a/b)));
	}

	//wrapper lambda which accepts functional interface and return functional interface
	private static BiConsumer<Integer, Integer> wrapperlambda(BiConsumer<Integer, Integer> consumer) 
	{
		BiConsumer<Integer, Integer>  cons = (a, b) -> 
		{
			System.out.println("Executing from wrapper");
			try
			{
				consumer.accept(a, b);
			}
			catch(ArithmeticException e)
			{
				System.out.println("ArithmeticException occurs");
			}	
		};
		return cons;
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) 
	{
		System.out.println("process the numbers ");
		for(int i : numbers)
		{
			//System.out.println(i + key);
			consumer.accept(i, key);
		}			
	}

}
