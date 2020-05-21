package com.trip.dsa.tree.trie;

import java.util.HashMap;

public class TrieNode 
{
	HashMap<Character, TrieNode> children;
	boolean endOfString;
	
	public TrieNode()
	{
		children = new HashMap<Character, TrieNode>();
		endOfString = false;
	}
	
	public String toString()
	{
		return children.toString();
	}
}
