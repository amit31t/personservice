package com.trip.dsa.tree.Heap;

import java.util.stream.IntStream;

public class Heap 
{
	int [] heap;
	int heapSize;
	public Heap(int size)
	{
		heap = new int[size+1];
		this.heapSize = 0;
	}
	
	public int getHeapSize()
	{
		return heapSize;
	}
	
	public boolean isEmpty()
	{
		if(heapSize <= 0 ) return true;
		else
			return false;
	}
	
	public int peek()
	{
		return heap[1];
	}
	
	public void insert(int value)
	{
		heap[heapSize + 1] = value;
		heapSize++;
		heapifyFromBottomToTop(heapSize);
	}

	private void heapifyFromBottomToTop(int index) 
	{
		if(index<=1) return;
		int parent = index/2; //using formula left 2x and right 2x+1
		if(heap[parent] > heap[index])
		{
			int temp = heap[index];
			heap[index] = heap[parent];
			heap[parent] = temp;
		}
		heapifyFromBottomToTop(parent);
	}
	
	public void levelOrderTraversal()
	{
		IntStream stream = IntStream.of(heap);
		stream.filter(i -> i > 0).forEach(i -> System.out.print(" "+i));
		System.out.println();
	}
}