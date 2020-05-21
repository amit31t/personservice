package com.trip.java.basics.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerToFile {

	public static void main(String[] args)
	{
		String fileName = "data.txt";
				
		serializeObjectToFile(fileName);
		deSerializeObjectFromFile(fileName);		
	}
	
	private static void serializeObjectToFile(String fileName) 
	{
		Department department = new Department();
		department.setName("ECE");
		department.setSubjecs(1000);
		Student student = new Student("Amit", 22, department);
		
		//we can serialize more than one object in single file. But when deseralize need to follow same sequence otherwise u will get ClassCastException
		Department department1 = new Department();
		department1.setName("MATH");
		department1.setSubjecs(5000);
		
		//child class 
		MathStudent mStudent = new MathStudent("Trip", 44, department1);
		
		FileOutputStream outputStream;
		ObjectOutputStream objStream = null;
		try {
			outputStream = new FileOutputStream(fileName);
			objStream = new ObjectOutputStream(outputStream);		
			objStream.writeObject(student);
			System.out.println("First Object Serialized successfully : "+student.toString());
			
			objStream.writeObject(department1);
			System.out.println("Second Object Serialized successfully : "+department1.toString());	
			
			objStream.writeObject(mStudent);
			System.out.println("Third Object Serialized successfully : "+mStudent.toString());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				objStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Object Serialized successfully : "+student.toString());		
	}

	
	private static void deSerializeObjectFromFile(String fileName) 
	{
		Student student = null;
		Department dep = null;
		MathStudent ms = null;
		try {
			ObjectInputStream objStream = new ObjectInputStream(new FileInputStream(fileName));
			student = (Student)objStream.readObject();
			dep = (Department)objStream.readObject();
			ms = (MathStudent)objStream.readObject();
		} 
		catch (ClassCastException | ClassNotFoundException | IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Object recovered from file "+student.toString());
		System.out.println("Object recovered from file "+dep.toString());
		System.out.println("Object recovered from file "+ms.toString());
	}
}
