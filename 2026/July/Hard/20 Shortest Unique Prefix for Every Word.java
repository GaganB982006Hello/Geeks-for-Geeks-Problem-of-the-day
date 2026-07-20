/*
Given an array of strings arr[ ], find the shortest prefix of each string that uniquely identifies it among all strings in the array. A prefix is unique if it is not a prefix of any other string in the array.

Note: No string in the given array is a prefix of another string.

Examples :

Input: arr[] = ["zebra", "dog", "duck", "dove"]
Output: ["z", "dog", "du", "dov"]
Explanation: z => zebra, dog => dog, duck => du, dove => dov 
Input: arr[] = ["geeksgeeks", "geeksquiz", "geeksforgeeks"]
Output: ["geeksg", "geeksq", "geeksf"]
Explanation: geeksgeeks => geeksg, geeksquiz => geeksq, geeksforgeeks => geeksf
Constraints:

1 ≤ |arr| ≤ 1000
1 ≤ |arr[i]| ≤ 1000
  */

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    
    // Trie Node structure using HashMap to save memory
    class TrieNode {
        HashMap<Character, TrieNode> children;
        int count; 
        
        public TrieNode() {
            children = new HashMap<>();
            count = 0;
        }
    }
    
    // Function to insert a word into the Trie
    private void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            // Add the character node if it doesn't exist
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            curr.count++; // Increment the count for this prefix
        }
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        TrieNode root = new TrieNode();
        
        // Step 1: Insert all words into the Trie
        for (String word : arr) {
            insert(root, word);
        }
        
        ArrayList<String> result = new ArrayList<>();
        
        // Step 2: Find the shortest unique prefix for each word
        for (String word : arr) {
            TrieNode curr = root;
            StringBuilder prefix = new StringBuilder();
            
            for (char c : word.toCharArray()) {
                prefix.append(c);
                curr = curr.children.get(c);
                
                // If this node is only visited by 1 word, it's a unique prefix
                if (curr.count == 1) {
                    break;
                }
            }
            result.add(prefix.toString());
        }
        
        return result;
    }
}
