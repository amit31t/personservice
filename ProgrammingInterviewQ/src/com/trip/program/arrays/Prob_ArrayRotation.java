package com.trip.program.arrays;

import java.util.Arrays;

/*
 * 	Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
	Array - {1, 2, 3, 4, 5}	
	Rotation of the above array by 2 will make array
	ArrayRotation1  - {3, 4, 5, 1, 2} 
 */
public class Prob_ArrayRotation 
{
	public static void main(String[] args) 
	{
		int [] input = {1, 2, 3, 4, 5, 6};
		int rotateByNumber = 2;
		System.out.println("Array before rotation - "+Arrays.toString(input));
		//soln-1 uses temp array, then shift input array and later merge temp array
		int[] rotatedArray = rotateArrayByTempArray(input.clone(), rotateByNumber);
		System.out.println("Array After rotation - "+Arrays.toString(rotatedArray));
		
		//Soln-2 using A Juggling Algorithm 
		int[] rotatedArray1 = rotateArrayByJugglingAlgorithm(input, rotateByNumber);
		System.out.println("Array After Juggling Algorithm  rotation - "+Arrays.toString(rotatedArray1));
	}

	/*
	 * Instead of moving one by one, divide the array in different sets where 
	 * number of sets is equal to GCD of n and d and move the elements within sets. 
	 * If GCD is 1, then elements will be moved within one set only,
	 *  we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
	 *  Here is an example for n =12 and d = 3. GCD is 3 and
	 */
	private static int[] rotateArrayByJugglingAlgorithm(int[] input, int d) 
	{
		int n = input.length;
		int i, j, k;
		int gcd = calculateGCD(n, d);
		System.out.println("GCD for " +d + " and "+n +" = " +gcd );
		for(i =0; i<gcd; i++)
		{
			int temp = input[i];
			j = i;
			while(true)
			{
				k = j + d;
				if(k >= n ) k = k-n;
				if(k == i) break;
				input[j] = input[k];
				j =k;
			}
			input[j] = temp;
		}
		return input;
	}

	private static int calculateGCD(int n, int d)
	{
		int gcd=0;
		for(int i=1; i<=d; i++)
		{
			if(n%i == 0 && d%i ==0)
				gcd =i;
		}
		return gcd;
	}

	private static int[] rotateArrayByTempArray(int[] input, int rotateByNumber) 
	{
		int [] temp = new int[rotateByNumber];
		int i, j=0;
		//add items from input array to temp array which need to be rotated
		for(i=0; i<input.length; i++)
		{
			if(i < rotateByNumber)
				temp[i] = input[i];
			else
			{
				input[j++] = input[i];
			}
		}
		for(i =0; i<rotateByNumber; i++)
		{
			input[j++] = temp[i];
		}
		return input;
	}

}
