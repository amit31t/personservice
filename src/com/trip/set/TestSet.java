package com.trip.set;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) 
	{
		//testHashSetMethods();
		
		//testEnumSet();
		
		testTreeSet();
	}
	private static void testTreeSet() 
	{
		TreeSet<Integer> set = new TreeSet<>();
		set.add(1); set.add(4); set.add(6);set.add(9);
		System.out.println("Tree Set data :- "+set);
		
		System.out.println("Ceiling element - "+set.ceiling(9));
		System.out.println("Higher element - "+set.higher(9));
		System.out.println("Floor element - "+set.floor(1));
		System.out.println("Lower element - "+set.lower(1));
	}
	private static void testEnumSet() 
	{
		EnumSet<Amit> set1, set2, set3;
		set1 = EnumSet.allOf(Amit.class);
		set2 = EnumSet.of(Amit.MCQ, Amit.QUIZZ);
		set3 = EnumSet.complementOf(set2);
		System.out.println("Enum sets :- " +set1 + " ------ "+set2+ " Complimentory set :- "+set3);
	}

	private static void testHashSetMethods() 
	{
		Set set = new HashSet();
		set.add("abc"); set.add("def"); set.add("ghi"); set.add("ABC");  set.add(2893275); set.add(null);
		set.add("abc");
		//set.remove("ABC");
		System.out.println("Set data :- "+set);
		
	}

}

enum Amit
{
	CODE, QUIZZ, TEST, MODULE, MCQ
};