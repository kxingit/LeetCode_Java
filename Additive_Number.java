/*
 * Additive number is a string whose digits can form additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {   
        //枚举前两个数的位置，因为前两个数决定了num是否为Additive   
        for(int i = 0; i < num.length(); i++) {   
            for(int j = i + 1; j < num.length() - i - 1; j++) {   
                String first = num.substring(0, i + 1);   
                String second = num.substring(i + 1, j + 1);   
                if(valid(j + 1, num, first, second))   
                    return true;   
            }   
        }   
        return false;   
    }   
   
    private boolean valid(int start, String num, String first, String second) {   
        if(start == num.length())   
            return true;   
        long f = Long.parseLong(first);   
        long s = Long.parseLong(second);   
        if(!Long.toString(f).equals(first) || !Long.toString(s).equals(second))   
            return false;   
        long sum = f + s;   
        String sumS = Long.toString(sum);   
        if(start + sumS.length() > num.length())   
            return false;   
        String third = num.substring(start, start + sumS.length());   
        long t = Long.parseLong(third);   
        if(!Long.toString(t).equals(third) || t != sum)   
            return false;   
        return valid(start + sumS.length(), num, second, third);   
    }   
}

// v2
public class Solution {
    public boolean isAdditiveNumber(String num) {
        // 3:21 - 3:39
        int n = num.length();
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - i - 1; j++) {
                String first = num.substring(0, i + 1);
                String second = num.substring(i + 1, j + 1);
                if(isValid(num, j + 1, first, second)) return true;
            }
        }
        return false;
    }
    private boolean isValid(String num, int start, String first, String second) {
        if(start == num.length()) return true;
        long f = Long.parseLong(first);
        long s = Long.parseLong(second);
        if(!Long.toString(f).equals(first) || !Long.toString(s).equals(second))
            return false;
        long t = s + f;
        String third = Long.toString(t);
        int len = third.length();
        if(start + len > num.length()) return false;
        String sub = num.substring(start, start + len);
        if(!sub.equals(third)) return false;
        return isValid(num, start + len, second, third);
    }
}
