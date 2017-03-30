/*
 * Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).
 */
public class Solution {
    public String parseTernary(String expression) {
        // 9:12 - 9:19 wrong "T?1:F?3:4"
        // 9:30 // find the last '?'
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '?') stack.push(i);
        }
        while(stack.size() > 0) {
            int pos = stack.pop();
            char val = eval(expression.substring(pos - 1, pos + 4));
            expression = expression.substring(0, pos - 1) + val + expression.substring(pos + 4);
        }
        return expression;
    }
    
    public char eval(String s) {
        if(s.charAt(0) == 'T') {
            return s.charAt(2);
        } else {
            return s.charAt(4);
        }
    }
}
