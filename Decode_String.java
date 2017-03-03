/*
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 */
public class Solution {
    public String decodeString(String s) {
        // 1:30 - 2:41
        String res = "";
        int i = 0;
        if(s.length() == 0) return res;
        if(Character.isDigit(s.charAt(0)) == false) {
            res += s.charAt(0);
            res += decodeString(s.substring(1, s.length()));
            return res;
        } else {
            int number = 0;
            for(; i < s.length(); i++) {
                int c = s.charAt(i);
                if(Character.isDigit(c)) {
                    number = number * 10 + Character.getNumericValue(c);
                } else {
                    break; // break when [i] is not digit
                }
            }
            Stack<Integer> stack = new Stack();
            int start = i + 1;
            for(; i < s.length(); i++) {
                if(s.charAt(i) == '[') {
                    stack.push(1);
                } else if(s.charAt(i) == ']') {
                    stack.pop();
                }
                if(stack.size() == 0) break;
            }
            String sub = s.substring(start, i);
            for(int ii = 0; ii < number; ii++) {
                res += decodeString(sub);
            }
        }
        if(i + 1 < s.length()) res += decodeString(s.substring(i + 1, s.length()));
        return res;
    }
}

// v2
public class Solution {
    public String decodeString(String s) {
        String res="";
        Stack<Integer> counts=new Stack<>();
        Stack<String> strs=new Stack<>();
        int i = 0;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                counts.push(num);
            }else if(s.charAt(i) == '['){
                strs.push(res);
                res="";
                i++;
            }else if(s.charAt(i) == ']'){
                StringBuilder str=new StringBuilder(strs.pop());
                int count = counts.pop();
                for(int j = 0; j < count; j++){
                    str.append(res);
                }
                res = str.toString();
                i++;
            }else{
                res += s.charAt(i++);
            }
        }
        return res;
    }
}

// v3
public class Solution {
    public String decodeString(String s) {
        if (s == null) {
            return null;
        }
        
        Stack<StringBuilder> sbStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int repeat = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                sbStack.push(sb);
                intStack.push(repeat);
                sb = new StringBuilder();
                repeat = 0;
            } else if (c == ']') {
                StringBuilder temp = sb;
                sb = sbStack.pop();
                repeat = intStack.pop();
                while (repeat > 0) {
                    sb.append(temp);
                    repeat -= 1;
                }
            } else if (c >= '0' && c <= '9') {
                repeat *= 10;
                repeat += c - '0';
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}


