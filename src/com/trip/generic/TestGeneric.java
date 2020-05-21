package com.trip.generic;

public class TestGeneric<T>
{
	T obj;
	
	public TestGeneric(T obj)
	{
		this.obj = obj;
	}
	
	public TestGeneric()
	{
	}
	
	public T getObject()
	{
		return this.obj;
	}
	
	public static void main (String args [])
	{
		TestGeneric<Integer> intObj = new TestGeneric<Integer>(15);
		System.out.println(intObj.getObject());
		
		TestGeneric<String> strObj = new TestGeneric<String>("My Generic ===");
		System.out.println(strObj.getObject());
		
		TestGeneric newObj = new TestGeneric();
		newObj.displayGeneric(22);
		newObj.displayGeneric("Amit T");
		newObj.displayGeneric(true);
	}
	
	//Generic function
	<U> void displayGeneric(U element)
	{
		System.out.println(element.getClass().getName()+ " = " +element);
	}
}
