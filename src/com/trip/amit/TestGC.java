package com.trip.amit;

public class TestGC {

	String name;
	
	public TestGC(String name)
	{
		this.name = name;
	}
	public static void main(String[] args) {
	
		TestGC gc1 = new TestGC("gc1");
		TestGC gc2 = new TestGC("gc2");
		
		gc1 = gc2;
		
		System.gc();
	}

	protected void finalize() throws Throwable  
    { 
        // will print name of object 
        System.out.println( this.name+ " successfully garbage collected"); 
    } 
}
