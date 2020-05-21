package com.trip.java.basics.bitwiseoperations;

public class BitwiseOperations 
{

	public static void main(String[] args) 
	{
		int a = 15; // 0000 1111
		int b = 20; // 0001 0100
		int aANDb = a & b; // 0000 0100
		int aORb = a | b; // 0000 0100
		int aXORb = a ^ b; // 0000 0100
		int oneCompliment = ~a; // 0000 0100
		
		System.out.println(" a & b  = "+ aANDb);
		System.out.println(" a | b  = "+ aORb);
		System.out.println(" a ^ b  = "+ aXORb);
		System.out.println(" ones compliment of a = "+ oneCompliment);
		System.out.println(" twos compliment of a = "+ (~(~a)));
		System.out.println(" left shift compliment of a = "+ (66 << 2)); // 0100 0010 << 2 =1 0000 1000
		System.out.println(" right shift compliment of a = "+ (130 >>> 1)); // 1000 0010 >> 2 =1 0000 1000
	}
}
