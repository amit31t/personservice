package com.trip.java.basics.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee extends Person implements Externalizable
{
	private String email;
	private double salary;
	
	public Employee()
	{
		System.out.println("Employee Default constuctor");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return super.toString() +"Employee [email=" + email + ", salary=" + salary + "]";
	}
	@Override
	public void readExternal(ObjectInput objInput) throws IOException,
			ClassNotFoundException 
	{
		//deserialize parent class Person's fields
		setId(objInput.readInt());
		//int id = objInput.readInt();
		//System.out.println(id);
		setName((String)objInput.readObject());
		
		//deserialize child class Employee's fields
		setEmail((String)objInput.readObject());
		setSalary(objInput.readDouble());
	}
	@Override
	public void writeExternal(ObjectOutput objOutput) throws IOException 
	{
		//serialize parent class Person's fields
		objOutput.writeInt(getId());
		objOutput.writeObject(getName());
		
		//serialize child class Employee's fields
		objOutput.writeObject(getEmail());
		objOutput.writeDouble(getSalary());
	}
	
	
}
