/*
Given an array arr[], find the minimum number of elements to delete so that the remaining elements form a strictly increasing sequence in the same order.

Examples:

Input: arr[] = [5, 6, 1, 7, 4]
Output: 2
Explanation: Removing 1 and 4 leaves [5, 6, 7] which is strictly increasing.
Input: arr[] = [1, 1, 1]
Output: 2
Explanation: Removing any 2 elements leaves [1] which is strictly increasing.
Constraints:
1 ≤ n ≤ 105 
1 ≤ arr[i] ≤ 105
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minDeletions(int[] arr) {
        int n = arr.length;
        List<Integer> lis = new ArrayList<>();
        
        for (int x : arr) {
            int idx = Collections.binarySearch(lis, x);
            if (idx < 0) {
                idx = -idx - 1;
            }
            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x);
            }
        }
        
        return n - lis.size();
    }
}
