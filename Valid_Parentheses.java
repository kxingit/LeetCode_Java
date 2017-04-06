/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    public boolean isValid(String s) {
        // 5:14 - 5:18
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if(c == ']') {
                if(stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if(c == '}') {
                if(stack.size() > 0 && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
