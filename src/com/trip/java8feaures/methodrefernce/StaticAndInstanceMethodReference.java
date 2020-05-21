package com.trip.java8feaures.methodrefernce;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class StaticAndInstanceMethodReference {

	public static void main(String[] args) 
	{
		//static method reference 
		staticMethodRefernce();
		
		//Instance method reference 
		instanceMethodReference();		
	}

	private static void instanceMethodReference() 
	{
		LambdaUtility lu = new LambdaUtility();
		//lambda expression
		Consumer<String> consumer = (String str) -> lu.printMessage(str);				
		consumer.accept("Hello Lambda");
		//same as instance method reference
		Consumer<String> consumer1 = lu :: printMessage;				
		consumer1.accept("Hello Method Reference");
	}

	private static void staticMethodRefernce()
	{
		//lambda expression
		BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> LambdaUtility.addition(a, b);
		System.out.println("result = " +biFunction.apply(20, 50));
		//same as method reference
		BiFunction<Integer, Integer, Integer> biFunction1 = LambdaUtility :: addition;
		System.out.println("result = " +biFunction1.apply(120, 80));
	}

}
