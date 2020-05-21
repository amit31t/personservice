package com.trip.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) throws Exception
	{	
		ArrayList<String> list = new ArrayList<String>(); list.add("amit");
		
		
		List<String> newList = Collections.unmodifiableList(list);
		
		list.add("anurag");
		
		System.out.println(" Normal List :"+list);
		System.out.println(" unmodifiable List :"+newList);
	}

}
