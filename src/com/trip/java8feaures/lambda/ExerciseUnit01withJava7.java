package com.trip.java8feaures.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExerciseUnit01withJava7 {

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
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareToIgnoreCase(p2.getLastName());
			}	
		});		
				
		// create print method to print the list
		printList(list);
			
		//print all whome first name start with j
		printFilteredList(list, new Filter() {		
			@Override
			public boolean test(Person p) {
				return p.getFirstName().startsWith("j");
			}
		});
		
	}

	private static void printFilteredList(List<Person> list, Filter filter)
	{
		System.out.println("\n Fitered List ::");
		for(Person p : list)
		{
			if(filter.test(p))
				System.out.println(p);
		}
	}

	private static void printList(List<Person> list) 
	{
		for(Person p : list)
		{
			System.out.println(p);
		}
		
	}

}

interface Filter
{
	boolean test(Person p);
}
