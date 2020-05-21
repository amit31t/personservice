package com.trip.program.mix;

public class Test 
{

	public static void main(String[] args)
	{
		MethodOverload obj = new MethodOverload();
		obj.m1(10);
	}

}

class MethodOverload
{
	public void m1(Object a)
	{
		System.out.println(" Object"+a);
	}
	
	public void m1(Number a)
	{
		System.out.println("Number "+a);
	}
	
	public void m1(Integer a)
	{
		System.out.println(" Integer"+a);
	}
	public void m1(int a)
	{
		System.out.println("int "+a);
	}
}