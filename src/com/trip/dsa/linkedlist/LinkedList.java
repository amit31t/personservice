package com.trip.dsa.linkedlist;

public class LinkedList 
{
	Node head;
	Node tail;
	
	public static LinkedList createSingleLinkedList(int value)
	{
		LinkedList list = new LinkedList();
		Node head = null;
		Node tail = null;
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		list.head = head;
		list.tail = tail;
		return list;
	}
	//insert the node in last of the list
	public static void insert(LinkedList list, int data, int position)
	{	
		int n =0;
		Node curNode = list.head;
		while(curNode != null )
		{
			n++;
			curNode = curNode.next;
		}

		Node newNode = new Node(data);
		
		//In the beginning of the list
		if(position == 0)
		{
			newNode.next = list.head;
			list.head = newNode;
		}
		//In the end of the list
		else if(position == n)
		{
			newNode.next = null;
			list.tail.next = newNode;
			list.tail = newNode;
		}
		else
		{	
			Node cueNode = list.head;
			Node tempNode = null;
			for(int i =0; i<position-1 ;i++)
			{
				tempNode = cueNode.next;
			}
			newNode.next = tempNode.next;
			tempNode.next = newNode;
		}
	}
	
}
