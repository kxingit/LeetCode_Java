/*
   You need to construct a binary tree from a string consisting of parenthesis and integers.

   The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

   You always start to construct the left child node of the parent first if it exists.
   */
// Weekly contest
public class Solution {
    public TreeNode str2tree(String s) {
        return build(s, 0, s.length() - 1);
    }
    
    private TreeNode build(String s, int start, int end) {
        if(start > end) {
            return null;
        }
        // System.out.print(s.charAt(start));
        int isNeg = 1;
        if(s.charAt(start) == '-') {
            isNeg = -1;
            // System.out.print("here");
            start++;
        }
        int numend = start;
        while(numend <= end) {
            if(numend == end) {
                numend++;
                break;
            }
            if(s.charAt(numend) == '(' || s.charAt(numend) == ')') {
                break;
            }
            numend++;
        }

        String numstring = s.substring(start, numend);
        // System.out.print(numstring);
        int val = Integer.parseInt(numstring);
        val *= isNeg;
        // System.out.print(val + " ");
        TreeNode root = new TreeNode(val);
        
        start = numend - 1;

        if(start == end) return root;
        
        int netleft = 0;
        int i = start + 1;
        while(i <= end) {
            if(s.charAt(i) == '(') {
                netleft++;
            } else if(s.charAt(i) == ')'){
                netleft--;
            }
            if(netleft == 0) break; 
            i++;
        }
        TreeNode left = build(s, start + 2, i - 1);
                // System.out.print(i);
        
        i++;
        start = i;
        while(i <= end) {
            if(s.charAt(i) == '(') {
                netleft++;
            } else if(s.charAt(i) == ')'){
                netleft--;
            }
            if(netleft == 0) break; 
            i++;
        }
        TreeNode right = build(s, start + 1, i - 1);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}
