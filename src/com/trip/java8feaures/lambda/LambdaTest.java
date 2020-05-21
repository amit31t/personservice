package com.trip.java8feaures.lambda;

public class LambdaTest {

	public static void main(String[] args)
	{
		//method interface implementation by implemented class
		Shape classShape = new Rectangle();
		System.out.println("Class Shape area : "+classShape.calculateArea(20, 30));
		
		//interface's method implementation by anonymous class
		Shape anonymousShape = new Shape() {
			
			@Override
			public int calculateArea(int a, int b) {
				return a * b;
			}
		};
		System.out.println("Anonymous Shape area : "+anonymousShape.calculateArea(15, 20));
		
		//interface's method implementation by lambda function
		Shape lambdaShape = (a, b) -> a * b;
		System.out.println("Lambda Shape area : "+lambdaShape.calculateArea(40, 50));
		
		Shape shape = (int a, int b) ->
				{
					return ( a * b);
				};
		System.out.println(shape.calculateArea(10, 10));
	}

}
