/*
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 *
 * You may assume each number in the sequence is unique.
 */
public class Solution {
    int len;
    public boolean verifyPreorder(int[] preorder) {
        // 5:00 - 5:25
        len = preorder.length;
        return isPreorder(preorder, 0, preorder.length - 1);
    }
    
    public boolean isPreorder(int[] A, int start, int end) {
        int n = end - start + 1;
        if(n <= 2) return true;
        
        int rootval = A[start];
        int i = start + 1;
        for(; i <= end; i++) {
            if(A[i] > rootval) break;
        }
        for(int k = i; k <= end; k++) {
            if(A[k] < rootval) {
                return false;
            }
        }
        if(i == end) return isPreorder(A, start + 1, end);
        return isPreorder(A, start + 1, i - 1) && isPreorder(A, i, end);
    }
}

// v2
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stk = new Stack<Integer>();
        int min = Integer.MIN_VALUE;
        for(int num : preorder){
            if(num < min) return false;
            while(!stk.isEmpty() && num > stk.peek()){
                min = stk.pop();
            }
            stk.push(num);
        }
        return true;
    }
}
