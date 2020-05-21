package com.trip.java8feaures.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamCreationWays {

	public static void main(String[] args) 
	{
		//Create a Stream using Stream.builder()
		//Stream.Builder<String> builder = Stream.builder();
		//Stream<String> stringStream = builder.add("a").add("b").add("c").build();
		Stream.builder().add("a").add("b").add("c").build().forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		//Create an infinite Stream using Stream.iterate()
		Stream.iterate(2, (i) -> i+2).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		//Create an infinite Stream using Stream.generate() method
		Stream.generate(Math :: random).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		//Create stream from Iterator
		Iterator<String> itretor = Arrays.asList("a", "b", "c").iterator();
		Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(itretor, Spliterator.NONNULL);
		Stream<String> stream = StreamSupport.stream(spliterator, false);
		stream.forEach(i -> System.out.print(i+" "));
		
		//Create stream from Iterable
		Iterable<Integer> iterable = Arrays.asList(1, 2, 3, 4, 5, 10);
		StreamSupport.stream(iterable.spliterator(), false).forEach(i -> System.out.print(i + " "));
		
		
		
		
	}

}
