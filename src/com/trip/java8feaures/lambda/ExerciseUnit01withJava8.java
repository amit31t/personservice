package com.trip.java8feaures.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExerciseUnit01withJava8 {

	public static void main(String[] args) 
	{
		//create a list of person 
		List<Person> list = Arrays.asList(
				new Person("amit", "trip", 34),
				new Person("jack", "Arnold", 49),
				new Person("denial", "Cieat", 31),
				new Person("Raj", "verma", 36),
				new Person("jashish", "deck", 34)		
				);
		
		//sort that list with lastname
		Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
				
		// create print method to print the list
		performConditionally(list, p -> true, p -> System.out.println(p));
			
		//print all whome first name start with j
		performConditionally(list, p -> p.getFirstName().startsWith("j"), p -> System.out.println(p.getFirstName()));
		
	}

	private static void performConditionally(List<Person> list, Predicate<Person> predeicate, Consumer<Person> consumer)
	{
		System.out.println("\n Fitered List ::");
		for(Person p : list)
		{
			if(predeicate.test(p))
				consumer.accept(p);
		}
	}
}

