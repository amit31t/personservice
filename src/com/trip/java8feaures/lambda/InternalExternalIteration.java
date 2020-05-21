package com.trip.java8feaures.lambda;

import java.util.Arrays;
import java.util.List;

public class InternalExternalIteration {

	public static void main(String[] args)
	{
		//create a list of person 
		List<Person> list = Arrays.asList(
				new Person("amit", "trip", 34),
				new Person("jack", "troy", 49),
				new Person("denial", "trump", 31),
				new Person("Raj", "verma", 36),
				new Person("ashish", "shukla", 34)		
				);
		
		//External iteration
		System.out.println("Iterate for in loop");
		for(Person p : list)
		{
			System.out.println(p);
		}
		//internal iteration
		System.out.println("Iterate foreach loop");
		list.forEach(p -> System.out.println(p));
		
		System.out.println("Stream:::::");
		list.stream().filter(p -> p.getLastName().startsWith("t")).forEach(p -> System.out.println(p));

	}

}
