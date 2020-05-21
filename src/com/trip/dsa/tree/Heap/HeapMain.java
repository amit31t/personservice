package com.trip.dsa.tree.Heap;

public class HeapMain {

	public static void main(String[] args) 
	{
		Heap heap = new Heap(10);
		int[] arr ={20, 10, 15, 25};
		for(int a : arr)
			heap.insert(a);
		heap.levelOrderTraversal();
		
		System.out.println("Top of heap "+heap.peek());
		System.out.println("Size of heap "+heap.getHeapSize());
	}

}
