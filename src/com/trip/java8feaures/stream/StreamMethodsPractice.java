package com.trip.java8feaures.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethodsPractice {

	public static void main(String[] args) 
	{
		int [] arr = {1, 2, 3, 4, 5, 6, 7};
		Stream.of(arr);
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		System.out.println();
		//List<Integer> list = Arrays.asList(arr);
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		//intermediate methods like map, filter
		List<Integer> square = numbers.stream().map(x -> x*x).collect(Collectors.toList());
		numbers.stream().map(x -> x*x).collect(Collectors.toList()).forEach(i -> System.out.print(i + " "));System.out.println();
		square.stream().forEach(i -> System.out.print(i + " "));System.out.println();
		
		List<Integer> evenList = numbers.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
		evenList.stream().forEach(i -> System.out.print(i + " "));
		System.out.println();
		//terminate methods like foreach, collect, reduce
		int even = numbers.stream().filter(i -> i*i == 0).reduce(0, (ans, i) -> ans +i);
		System.out.println("output reduce method " +even);
		System.out.println();
		
		List<List<String>> namesNested = Arrays.asList( 
			      Arrays.asList("Jeff", "Bezos"), 
			      Arrays.asList("Bill", "Gates"), 
			      Arrays.asList("Mark", "Zuckerberg"));
		namesNested.stream().flatMap(Collection :: stream).collect(Collectors.toList()).forEach(i -> System.out.print(i + " "));
		System.out.println();
		namesNested.stream().flatMap(name -> name.stream()).collect(Collectors.toList()).forEach(i -> System.out.print(i + " "));
	}

}
