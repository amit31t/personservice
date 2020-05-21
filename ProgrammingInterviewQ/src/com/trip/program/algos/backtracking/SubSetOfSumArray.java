package com.trip.program.algos.backtracking;

import java.util.Arrays;

public class SubSetOfSumArray {

	public static void main(String[] args) 
	{
		int [] input = {4, 1, 2, 3, 5, 10, 6};
		int sum = 8;
		
		generateSubsets(input, sum);
	}

	private static void generateSubsets(int[] input, int sum)
	{
		//ArrayList<Integer> subArrays = new ArrayList<Integer>();
		int [] subArrays = new int[input.length];
		//int input_size = input.length;
		//subSetOfSum(input, sum, subArrays, subArrays_size, sum_till_now, iteration_number);
		//Arrays.sort(input);
		subSetOfSum(input, sum, subArrays, 0, 0,0);
	}

	private static void subSetOfSum(int[] input, int targetSum, int[] subArrays, int itr, int sum_now, int sub_size) 
	{
		if(sum_now == targetSum )
		{
			printSubArray(subArrays);
			//consider next input value if target sum can be achived by next. // Exclude previous added item and consider next candidate 
			//Constraint check (if input has next element and target sum should be more than sum_now+inout[itr+1]
			if(itr+1 < input.length && targetSum >= sum_now - input[itr] + input[itr +1])
			{
				//subArrays.remove(input[itr]);
				subSetOfSum(input, targetSum, subArrays, itr+1, sum_now - input[itr], sub_size -1);
			}
			return;
		}
		else
		{
			if(itr < input.length && targetSum >= sum_now +input[itr])
			{
				// now find sub arrays breadth level, generate nodes along the breadth
				for(int i = itr; i<input.length; i++)
				{
					//subArrays.add(input[i]);
					subArrays[sub_size] = input[i];
					if(sum_now + input[i] <= targetSum)
					{
						//subArrays.add(input[i]);
						//consider next level node along depth
						subSetOfSum(input, targetSum, subArrays, i+1, sum_now+input[i], sub_size +1);
					}
				}
				subArrays[sub_size] =0;
			}
		}
		
	}

	private static void printSubArray(int [] subArrays) 
	{
		for(int i = 0; i<subArrays.length; i++)
		{
			System.out.print( " "+subArrays[i]);
		}
		System.out.println();
	}


}
