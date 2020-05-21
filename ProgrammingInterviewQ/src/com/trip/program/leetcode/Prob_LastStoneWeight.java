package com.trip.program.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/*
 * Given a collection of stones, each stone has a positive integer weight.
 * Each turn, we choose the two heaviest stones and smash them together.  
 * Suppose the stones have weights x and y with x is less than equal to y.  
 * The result of this smash is:

 If x == y, both stones are totally destroyed;
 If x != y, the stone of weight x is totally destroyed, 
            and the stone of weight y has new weight y-x.
 
At the end, there is at most 1 stone left.  
Return the weight of this stone (or 0 if there are no stones left.)

Input: {2, 7, 4, 1, 8, 1}

Output: 1
 */
public class Prob_LastStoneWeight 
{
	public static void main(String[] args) 
	{
		//Integer [] stones_weight = {2, 7, 4, 1, 8, 1};
		//Integer [] stones_weight = {7, 5, 2, 20, 4};
		Integer [] stones_weight = {7, 5, 2, 1};
		List<Integer> list =  Arrays.asList(stones_weight);
		int lastStone = lastStonesWeight(list);
		System.out.println("Last Stone Weight = "+lastStone);
	}

	private static int lastStonesWeight(List<Integer> list) 
	{		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( (i, j) -> j - i);
		maxHeap.addAll(list);
		int y =0; int x =0;
		while(maxHeap.size() > 1)
		{
			if(maxHeap.size() >= 2)
			{
				y = maxHeap.poll();
				x = maxHeap.poll();
				if(y != x )
				{
					maxHeap.add(y-x);
				}
			}
		}
		return maxHeap.isEmpty() ? 0 : maxHeap.peek();
	}

}
