package com.trip.generics;

public class Glass<T>
{
	T liquid;
	
}

class WineGlass<T> extends Glass<T>
{
	
}

class Tray
{
	Glass<? extends Juice> jGlass;
	
	//unbound wildcard  - it can take any kind of Glass type
	public void add(Glass<?> liquid)
	{
		System.out.println(" Tray contains Glass of liquid");
	}
	
	//upper bound wildcard  - it can take any kind of Glass<UpperBound>  type and UpperBound Subtypes
	public void remove(Glass<? extends Juice> liquid)
	{
		System.out.println(" Tray Glass removed of liquid");
	}
	
	//lower bound wildcard  - it can take any kind of Glass<LowerBound>  type and UpperBound superType
	public void replace(Glass<? super Juice> liquid)
	{
		System.out.println(" Tray Glass removed of liquid");
	}
}