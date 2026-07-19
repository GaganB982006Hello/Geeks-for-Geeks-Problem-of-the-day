/*
Given a string s consisting of lowercase English letters, find the maximum number of characters between any two identical characters. If no character repeats, return -1.

Examples :

Input: s = "socks"
Output: 3
Explanation: There are 3 characters between the two occurrences of 's'.
Input: s = "for"
Output: -1
Explanation: No repeating character present.
Constraints:
1 ≤ |s| ≤ 105
  */

class Solution {
    public int maxCharGap(String s) {
        // Array to store the first occurrence index of each lowercase letter
        int[] firstOccurrence = new int[26];
        
        // Initialize the array with -1 to indicate no occurrence yet
        for (int i = 0; i < 26; i++) {
            firstOccurrence[i] = -1;
        }
        
        int maxGap = -1;
        
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            
            if (firstOccurrence[charIndex] == -1) {
                // If it's the first time we see this character, record its index
                firstOccurrence[charIndex] = i;
            } else {
                // If we've seen it before, calculate the gap
                // The number of characters between them is (current_index - first_occurrence_index - 1)
                int currentGap = i - firstOccurrence[charIndex] - 1;
                maxGap = Math.max(maxGap, currentGap);
            }
        }
        
        return maxGap;
    }
}
