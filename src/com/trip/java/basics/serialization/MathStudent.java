package com.trip.java.basics.serialization;

//if parent class is serializable then child class not needed to extend Serializable
public class MathStudent extends Student
{
	private int mathId;
	
	public MathStudent(String name, int id, Department department) 
	{
		super(name, id, department);
		this.mathId = id;
	}

	public int getMathId() {
		return mathId;
	}

	@Override
	public String toString() {
		return super.toString() + "MathStudent [mathId=" + mathId + "]";
	}

}
