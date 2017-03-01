/*
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        // 3:19 - 3:28
        Stack<String> stack = new Stack();
        String[] str = preorder.split(",");
        for(String s: str) {
            while(s.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(s);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}

// v2
public class Solution {
    public boolean isValidSerialization(String preorder) {
        // 3:29 - 3:34
        String[] str = preorder.split(",");
        Stack<String> stack = new Stack();
        for(String s : str) {
            while(s.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(s);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
