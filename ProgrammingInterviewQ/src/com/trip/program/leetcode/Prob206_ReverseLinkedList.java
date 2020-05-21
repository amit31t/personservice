package com.trip.program.leetcode;

public class Prob206_ReverseLinkedList
{
	private static class Node
	{
		int val;
		Node next;
		Node(int val)
		{
			this.val = val;
			this.next = null;
		}
	}
	public static void main(String[] args) 
	{
		Node head = new Node(1);
		head.next = new Node(2);
		
		Node prev = null;
		while(head != null)
		{
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		Node x = prev;
		while(x != null)
		{
			System.out.print(" "+x.val);
			x = x.next;
		}
		System.out.println();
		
		Node root = new Node(1);
		root.next = new Node(2); 
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		Node head1 = reverseBetween(root, 2, 4);
		while(head1 != null)
		{
			System.out.print(" "+head1.val);
			head1 = head1.next;
		}
	}
	
	public static Node reverseBetween(Node head, int m, int n)
	{
		Node start = head;
		Node prev = null;
		while(m>1)
		{
			prev = start;
			start =start.next;
			m--; n--;
		}

		Node last = prev;
		Node start1 = start;
		while(n>0)
		{
			Node next = start.next;
			start.next = prev;
			prev = start;
			start = next;
			n--;
		}
		if(last != null)
			last.next = prev;
		else 
			head = prev;
		start1.next = start;
		return head;
    }

}
