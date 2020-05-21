package com.trip.java.basics.externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectExternaizeToFromFile {

	public static void main(String[] args)
	{
		String fileName = "employee.ser";
		serializeExtObject(fileName);
		deserializeExtObject(fileName);

	}

	private static void serializeExtObject(String fileName) 
	{
		ObjectOutputStream objSteram = null;
		FileOutputStream fos = null;
		Employee emp = new Employee(); emp.setEmail("xyz.gmail.com"); emp.setId(22); emp.setName("Amit"); emp.setSalary(75000);
		try
		{	
			fos = new FileOutputStream(fileName);
			objSteram = new ObjectOutputStream(fos);
			objSteram.writeObject(emp);
			objSteram.flush();
			System.out.println("WRITE Externaiized Object Successfully - "+emp.toString());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				objSteram.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void deserializeExtObject(String fileName) 
	{
		ObjectInputStream objSteram = null;
		
		try
		{
			objSteram = new ObjectInputStream(new FileInputStream(fileName));
			Employee emp = (Employee)objSteram.readObject();
			
			System.out.println("READ Externaiized Object Successfully - "+emp.toString());
		} 
		catch (ClassCastException | ClassNotFoundException | IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				objSteram.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
