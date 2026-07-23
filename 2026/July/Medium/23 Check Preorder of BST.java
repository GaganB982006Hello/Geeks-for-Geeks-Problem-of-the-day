/*
Given an array arr[ ] consisting of distinct integers, check if the given array can represent preorder traversal of a BST.

Examples :

Input: arr[] = [2, 4, 3]
Output: true
Explaination: Given arr[] can represent preorder traversal of following BST:
 
Input: arr[] = [2, 4, 1]
Output: false
Explaination: Given arr[] cannot represent preorder traversal of a BST.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 105
*/

class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> s = new Stack<>();
        int root = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.size(); i++) {
            // If we find a node who is on the right side and is smaller than root, return false
            if (arr.get(i) < root) {
                return false;
            }
            
            // If arr[i] is greater than the top of stack, pop it and make the last popped element the new root.
            while (!s.isEmpty() && s.peek() < arr.get(i)) {
                root = s.pop();
            }
            
            // Push the current element
            s.push(arr.get(i));
        }
        return true;
    }
}
