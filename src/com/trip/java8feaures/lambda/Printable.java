package com.trip.java8feaures.lambda;

import java.util.List;

@FunctionalInterface
public interface Printable 
{
	void print(List<Person> lis);
	
	//boolean equals(Object obj);
}
