package com.trip.dsa.linkedlist;

public class TestLinkedList {

	public static void main(String[] args) 
	{
		//LinkedList list = new LinkedList();
		LinkedList list = LinkedList.createSingleLinkedList(5);
		LinkedList.insert(list, 10, 0);
		LinkedList.insert(list, 15, 2);
		LinkedList.insert(list, 2, 2);
		Node curNode = list.head;
		while(curNode != null)
		{
			System.out.print( " > "+curNode.data);
			curNode = curNode.next;
		}
	}

}
