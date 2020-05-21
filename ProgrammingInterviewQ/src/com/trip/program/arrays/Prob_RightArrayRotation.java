package com.trip.program.arrays;

import java.util.Arrays;

/*
 * 	Write a function rotate(ar[], d, n) that rotates from right side of arr[] of size n by d elements.
	Array - {1, 2, 3, 4, 5}	
	Rotation of the above array by 2 will make array
	ArrayRotation1  - {4, 5, 1, 2, 3} 
 */
public class Prob_RightArrayRotation 
{
	public static void main(String[] args) 
	{
		int [] input = {1, 2, 3, 4, 5, 6};
		int rotateByNumber = 2;
		System.out.println("Array before rotation - "+Arrays.toString(input));
		//soln-1 uses reverse
		int[] rotatedArray = rotateRightArrayByReverseAlgo(input.clone(), rotateByNumber);
		System.out.println("Array After rotation - "+Arrays.toString(rotatedArray));
	}

	/*
	 *Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. 
	 *The idea of the algorithm is :
	Reverse A to get ArB, where Ar is reverse of A.
    Reverse B to get ArBr, where Br is reverse of B.
    Reverse all to get (ArBr) r = BA.
	 */

	private static int[] rotateRightArrayByReverseAlgo(int[] input, int d) 
	{
		int n = input.length;
		reverseArray(input, n-d, n-1); //right reverese the array A(n-d+1, n-1)
		reverseArray(input, 0, n-d-1); //reverese the array B(0...n-d-1)
		reverseArray(input, 0, n-1); //reverese the array AB(0...n-1)
		//System.out.println(Arrays.toString(input));
		return input;
	}

	private static void reverseArray(int[] input, int i, int j) 
	{
		while(i <= j)
		{
			int temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;
		}
		
	}
}
