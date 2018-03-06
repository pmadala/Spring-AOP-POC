package org.SpringAOP.spring.model;

/* Trie is an efficient information reTrieval data structure. 
 * Using Trie, search complexities can be brought to optimal limit (key length). 
 * If we store keys in binary search tree, 
 * a well balanced BST will need time proportional to M * log N,
 * where M is maximum string length and N is number of keys in tree.
 * Using Trie, we can search the key in O(M) time. 
 * However the penalty is on Trie storage requirements. 
 * 
 * The occurrence attribute represents the number of times a string is inserted into  a trie DS .
 * 
 * */
import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Map<Character, TrieNode> children;
	boolean endOfWord;
	int occurance;

	public TrieNode() {
		children = new HashMap<>();
	}

	@Override
	public String toString() {
		return "TrieNode [children=" + children + ", endOfWord=" + endOfWord + "]";
	}

	public int getOccurance() {
		return occurance;
	}

}
