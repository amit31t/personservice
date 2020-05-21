package com.trip.program.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Prob- Shortest path to reach one prime to other by changing single digit at a time
 * 
 * Given two four digit prime numbers, suppose 1033 and 8179, we need to find the 
 * shortest path from 1033 to 8179 by altering only single digit at a time such 
 * that every number that we get after changing a digit is prime. 
 * For example a solution is 1033, 1733, 3733, 3739, 3779, 8779, 8179 
 */
public class Prob03_ShortestPathToReachOnePrimeToOther 
{
	public static void main(String[] args) 
	{
		//System.out.println("Number is Prime = "+isPrime(1073));
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int sourcePrime =  1033;
		int destPrime = 3739;
		sieveOfEratosthenes(3739 + 1, primes, sourcePrime, destPrime );

		//use above list as vertices list, and add an edge between two vertex iff they are differ with 
		//only single digit
		ArrayList<PrimeVertex> list = new ArrayList<PrimeVertex>();
		for(Integer value : primes)
			list.add(new PrimeVertex(value));
		addEdges(list);
		
		//bfs for shortest path
		BFSForPrime(list, destPrime);
	}

	private static void BFSForPrime(ArrayList<PrimeVertex> list, int destPrime) 
	{
		Queue<PrimeVertex> queue = new LinkedList<PrimeVertex>();
		queue.add(list.get(0));
		while(!queue.isEmpty())
		{
			PrimeVertex currentVertex = queue.poll();
			currentVertex.setVisit(true);
			if(currentVertex.value == destPrime)
			{
				printPath(currentVertex);
			}
				
			for(PrimeVertex adjVertex : currentVertex.adjList)
			{
				if(!adjVertex.isVisit())
				{
					queue.add(adjVertex);
					adjVertex.setVisit(true);
					adjVertex.setParent(currentVertex);
				}
			}
		}
	}

	private static void addEdges(ArrayList<PrimeVertex> list)
	{
		for(int i=0; i<list.size(); i++)
		{
			for(int j =i+1; j<list.size(); j++)
			{
				if(compare(list.get(i).value, list.get(j).value) == 1)
				{
					list.get(i).adjList.add(list.get(j));
					list.get(j).adjList.add(list.get(i));
				}
			}
		}
	
		
	}

	private static int compare(int u, int v) 
	{
		int count =0;
		String su = Integer.toString(u);
		String sv = String.valueOf(v);
		for(int i=0; i< su.length(); i++)
		{
			if( su.charAt(i) != sv.charAt(i))
				count++;	
		}
		return count;
	}
	private static void printPath(PrimeVertex node) 
	{
		if(node.getParent()!=null)
		{
			printPath(node.getParent()); // recurseive call to all parents
		}
		System.out.print(node+" ");	
	}
	//Sieve of Eratosthenes, Given a number n, print all primes smaller than or equal to n.
	//It is also given that n is a small number. 
	public static void sieveOfEratosthenes(int n, ArrayList<Integer> primes, int source, int dest) 
    { 
        // Create a boolean array "prime[0..n]" and initialize 
        // all entries it as true. A value in prime[i] will 
        // finally be false if i is Not a prime, else true. 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) 
            { 
                // Update all multiples of p 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
          
        // Print all prime numbers 
        for(int i = source; i <= dest; i++) 
        { 
            if(prime[i] == true)
            {
            	 //System.out.print(i + " "); 
            	 primes.add(i);
            }
               
        } 
       // System.out.println();
    }
	
}

class PrimeVertex
{
	int value;
	ArrayList<PrimeVertex> adjList;
	boolean visit;
	PrimeVertex parent;
	public PrimeVertex(int value)
	{
		this.value = value;
		this.adjList = new ArrayList<>();
	}
	
	public boolean isVisit() {
		return visit;
	}

	public void setVisit(boolean visit) {
		this.visit = visit;
	}

	public PrimeVertex getParent() {
		return parent;
	}

	public void setParent(PrimeVertex parent) {
		this.parent = parent;
	}

	public String toString()
	{
		return ("[ "+value+" ]");
	}
}