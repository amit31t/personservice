package com.trip.java8feaures.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//solution with java 8
public class ExerciseUnit01 {

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
		//sort that list with lastname
		Comparator<Person> comp = (p1, p2) -> 
		{
			int c = p1.getLastName().compareTo(p2.getLastName());
			return c;
		};
		System.out.println("Sort list by last name : : ");
		sortByLastName(list, comp);
		
		// create print method to print the list
		//list.forEach(p -> System.out.println(p.toString()));
		
/*		Printable printing = (list) -> {
			for(Person p : list)
			{
				System.out.println(p.toString());
			}
			return
		};*/
		
		Printable p = (lis) -> {
				for(Person pe :lis)
					System.out.println(pe.toString());
			};
		p.print(list);
		// print the list of persons whome last name start with T
	}

	private static void sortByLastName(List<Person> list, Comparator<Person> comp) 
	{ 
		int i, j , min_idx;
		for(i = 0 ; i<list.size()-1; i++)
		{
			min_idx =i;
			for(j=i+1; j<list.size(); j++)
			{
				if(comp.compare(list.get(j), list.get(min_idx)) < 0)
				{
					min_idx = j;
				}
			}
			swap(list, min_idx, i);
		}
		
	}

	private static void swap(List<Person> list, int min_idx, int i) 
	{
		Person temp = list.get(i);
		list.set(i, list.get(min_idx));
		list.set(min_idx, temp);
		
	}



}
