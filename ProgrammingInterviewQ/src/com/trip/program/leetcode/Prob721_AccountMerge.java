package com.trip.program.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * Given a list accounts, each element accounts[i] is a list of strings, where the first 
 * element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person 
 * if there is some email that is common to both accounts. Note that even if two accounts have
 * the same name, they may belong to different people as people could have the same name. 
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * After merging the accounts, return the accounts in the following format: 
 * the first element of each account is the name, and the rest of the elements are emails 
 * in sorted order. The accounts themselves can be returned in any order.
 */
public class Prob721_AccountMerge {

	public static void main(String[] args)
	{
		 String accounts [][] = {{"Gaurav", "gaurav@gmail.com", "gaurav@gfgQA.com"}, 
                 {"Lucky", "lucky@gmail.com"}, 
                 {"Gaurav", "gaurav123@skype.com", "gaurav@gmail.com"}, 
                 {"Gaurav","gaurav@gfgQA.com"}, 
                 {"raja","raja@gfg.com"},
                 {"raja", "rajaji@xyz.com", "raja@gfg.com"}
                }; 
		 List<List<String>> mergerdAccoints = mergeAccounts(accounts);
		 for(List<String> l : mergerdAccoints)
			 System.out.println(l);
	}

	private static List<List<String>> mergeAccounts(String[][] accounts) 
	{
		int[][] graph = constructGraph(accounts);
		for(int[] row : graph)
			System.out.println(Arrays.toString(row));
		
		List<List<String>> solution = new ArrayList<>();
		boolean [] visited = new boolean[graph.length];
		for(int i =0; i<graph.length; i++)
		{
			if(!visited[i])
			{
				ArrayList<String> list = new ArrayList<String>();
				DFSUtil(i, graph, list, accounts, visited);
				Collections.sort(list);
				solution.add(list);
			}
		}
		return solution;
	}

	private static void DFSUtil(int i, int[][] graph, List<String> emailSet, String[][] accounts, boolean[] visited) 
	{
		visited[i] =true;
		for(String email : accounts[i])
		{
			if(!emailSet.contains(email))
				emailSet.add(email);
		}
		for(int j=0; j<graph.length; j++)
		{
			if(graph[i][j] != 0 && !visited[j])
			{
				visited[j] = true;
				DFSUtil(j, graph, emailSet, accounts, visited);
			}
		}
	}

	private static int[][] constructGraph(String[][] accounts)
	{
		int n = accounts.length;
		int[][] graph = new int[n][n];
		for(int i =0; i<n; i++)
		{
			String[] account1 = accounts[i];
			for(int j =i+1; j<n; j++)
			{
				String[] account2 = accounts[j];
				if(account1[0].equals(account2[0]))
				{
					for(int k=1; k<account1.length; k++)
					{
						for(int l=1; l<account2.length; l++)
						{
							if(account1[k].equals(account2[l]))
							{
								graph[i][j] = 1;
								graph[j][i] = 1;
								break;
							}
						}
						
					}
				}
			}
			
		}
		return graph;
	}

}
