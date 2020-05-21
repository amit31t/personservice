package com.trip.dsa.tree.trie;

public class Trie 
{
	private final TrieNode root;
	
	public Trie()
	{
		root = new TrieNode();
	}
	public void insert(String str)
	{
		TrieNode currentNode = root;
		for(char c : str.toCharArray())
		{
			TrieNode node = currentNode.children.get(c);
			if(node == null)
			{
				node = new TrieNode();
				currentNode.children.put(c, node);
			}
			currentNode = node;
		}
		currentNode.endOfString = true;
	}
	
	public boolean search(String str)
	{
		TrieNode node = root;
		for(char c : str.toCharArray())
		{
			TrieNode nextNode = null;
			if(!node.children.containsKey(c))
				return false;
			else
			{
				nextNode = node.children.get(c);
			}
			node = nextNode;
		}
		if(!node.endOfString)
			return false;
		
		return true;
	}
	
	// Delete word from Trie
	public void delete(String word) {
		if (search(word) == true) {
			delete(root, word, 0);
		}
	}
	//delete recursive 
	private boolean delete(TrieNode currNode, String word, int index)
	{
		//base case
		if(index == word.length())
		{
			if(!currNode.endOfString)
				return false;
			currNode.endOfString = false;
			return currNode.children.size() == 0;
		}
		
		char c = word.charAt(index);
		TrieNode node = currNode.children.get(c);	
		if(node == null) return false;
		
		boolean nodebedeleted = delete(node, word, index+1);
		
		if(nodebedeleted)
		{
			currNode.children.remove(c);
			return currNode.children.size() == 0;
		}
		return false;	
	}
	// Returns true if parent should delete the mapping
/*	private boolean delete(TrieNode parentNode, String word, int index) {
		
		// CASE#1 -- Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
		// CASE#2 -- We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
		// CASE#3 -- Some other word is a Prefix of this word (BCDE, BC)
		// CASE#4 -- No one is dependent on this Word (BCDE, BCDE)	
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);

		boolean canThisNodeBeDeleted;

		if (currentNode.children.size() > 1) {
			System.out.println("Entering Case#1");
			delete(currentNode, word, index + 1); // CASE#1
			return false;
		}
		if (index == word.length() - 1) { // CASE#2
			System.out.println("Entering Case#2");
			if (currentNode.children.size() >= 1) {
				currentNode.endOfString = false;//updating endOfWord will signify that this word is not there in Trie
				return false;
			} else {
				System.out.println("Character " + ch + " has no dependency, hence deleting it from last");
				parentNode.children.remove(ch);
				return true;// If this word is not a prefix of some other word, and since this is last character, we should
							// return true, indicating we are ok to delete this node
			}
		}		
		if (currentNode.endOfString == true) { // CASE#3
			System.out.println("Entering Case#3");
			delete(currentNode, word, index + 1); 
			return false;
		}	
		System.out.println("Entering Case#4");
		canThisNodeBeDeleted = delete(currentNode, word, index + 1); // CASE#4
		if (canThisNodeBeDeleted == true) {
			System.out.println("Character " + ch + " has no dependency, hence deleting it");
			parentNode.children.remove(ch);
			return true; // Current node can also be deleted
		} else {
			return false; // Someone is dependent on this node, hence dont delete it
		}

	}*/
	public static int wordsWithGivenprefix(TrieNode node, String prefix)
	{
		for(char c : prefix.toCharArray())
		{
			TrieNode cNode = node.children.get(c);
			if(cNode == null)return 0;
			node = cNode;
		}
		return totalWordsCount(node);
		
	}
	public static int totalWordsCount(TrieNode node)
	{
		if(node == null )return 0;
		
		int count =0;
		if(node.endOfString)count++;
		
		for(char c : node.children.keySet())
		{
			if(node.children.get(c) != null)
				count += totalWordsCount(node.children.get(c));
		}
		return count;
	}
	public static void main(String[] args) 
	{
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abcx");
		trie.insert("xyz");
		trie.insert("zzz");
		trie.insert("ab");
		
		System.out.println("Search in trie "+trie.search("ab"));
		System.out.println("Search in trie "+trie.search("amit"));
		
		System.out.println("Total words in trie = "+totalWordsCount(trie.root));
		System.out.println("Total words in trie with prefix ab = "+wordsWithGivenprefix(trie.root, "ab"));
		trie.delete("abc");

	}

}
