package com.trip.java8feaures.lambda;

import java.util.function.Consumer;

public class SomeMoreLambdaCode {

	public static void main(String[] args) 
	{
		//Message refernce
		//Thread t = new Thread(() -> System.out.println("ttttt"));
		Thread t = new Thread(SomeMoreLambdaCode :: printMessage);
		t.start();
		//System.out.println(this);
		SomeMoreLambdaCode sm = new SomeMoreLambdaCode();
		//sm.process(10, k -> System.out.println(k) );
		sm.process(10, SomeMoreLambdaCode :: printMessage);
	}
	//this reference
	
	public static void printMessage()
	{
		System.out.println("message hello");
	}
	public static void printMessage(int k)
	{
		System.out.println("message hello ;;;" +k);
	}
	public void process(int k, Consumer<Integer> consumer)
	{
		consumer.accept(k);
	}
}
