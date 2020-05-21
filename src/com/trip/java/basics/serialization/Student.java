package com.trip.java.basics.serialization;

import java.io.Serializable;

public class Student implements Serializable
{
	private static String name;
	private int id;
	private Department department;
	
	public Student(String name, int id, Department department) 
	{
		super();
		this.name = name;
		this.id = id;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Department getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", department="
				+ department + "]";
	}

}
