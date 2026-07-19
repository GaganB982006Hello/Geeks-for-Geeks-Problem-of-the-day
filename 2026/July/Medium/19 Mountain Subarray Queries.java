/*
Given an array arr[] and a list of queries. For each query [l, r], find whether the subarray arr[l...r] is a mountain array. A subarray is called a mountain array if there exists an index k (l ≤ k ≤ r) such that: arr[l] ≤ arr[l + 1] ≤ ... ≤ arr[k] ≥ arr[k + 1] ≥ ... ≥ arr[r].

Elements of a Mountain subarray are first non-decreasing and then non-increasing.
A subarray that is entirely non-decreasing or entirely non-increasing is also considered a mountain.
Examples:

Input: arr[] = [2, 3, 2, 4, 4, 6, 3, 2], queries[][] = [[0, 2], [1, 3]]
Output: [true, false]
Explanation: For query [0, 2], the subarray is [2, 3, 2]. The elements first increase and then decrease, so it forms a mountain.
For query [1, 3], the subarray is [3, 2, 4]. The elements decrease and then increase, so it does not form a mountain.
Input: arr[] = [2, 2, 2, 2], queries[][] = [[0, 2], [1, 3]]
Output: [true, true]
Explanation: All subarrays of the given array are mountain.
Constraints:
1 <= arr.size(), queries.size() <= 105
1 <= arr[i] <= 106
0 <= l <= r < arr.size()

 */

import java.util.ArrayList;

class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // left[i] stores the furthest index to the left that forms a non-increasing sequence ending at i.
        // In other words, moving left from i, the elements keep increasing or stay the same.
        int[] left = new int[n];
        
        // right[i] stores the furthest index to the right that forms a non-decreasing sequence starting from i.
        // In other words, moving right from i, the elements keep increasing or stay the same.
        int[] right = new int[n];
        
        // Base case for left
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i]) {
                left[i] = left[i - 1];
            } else {
                left[i] = i;
            }
        }
        
        // Base case for right
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                right[i] = right[i + 1];
            } else {
                right[i] = i;
            }
        }
        
        // Process each query in O(1) time
        ArrayList<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            
            // If the peak reachable from 'l' extends at least as far as 
            // the peak reachable backwards from 'r', it is a mountain.
            if (right[l] >= left[r]) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}
  
