package com.trip.java8feaures.methodrefernce;

import java.util.function.BiFunction;

public class ConstructorReference {

	public static void main(String[] args) 
	{
		BiFunction<Integer, String, Employee> employeeInstance = Employee :: new;
		System.out.println("Employee instance - "+employeeInstance.apply(20, "Amit"));
	}
}

class Employee
{
	private int empId;
	private String empName;

	public Employee(int empId, String empName)
	{
		this.empId = empId;
		this.empName = empName;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
}
