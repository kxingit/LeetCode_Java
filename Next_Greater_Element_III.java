/*
Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.
*/
public class Solution {
    public int nextGreaterElement(int n) {
        // 8:55 - 9:11 - 9:18
        String s = "";
        while(n > 0) {
            s = n % 10 + s;
            n = n / 10;
        }
        
        char[] num = s.toCharArray();
        
        int pos = num.length - 2;
        for(; pos >= 0; pos--) {
            if(num[pos] < num[pos + 1]) break;
        }
        if(pos == -1) return -1;
        
        char tmp = num[pos];
        for(int i = num.length - 1; i >= 0; i--) {
            if(num[i] <= tmp) continue;
            num[pos] = num[i];
            num[i] = tmp;
            break;
        }
        
        int newn = num.length - pos - 1;
        char[] tailn = new char[newn];
        for(int i = 0; i < newn; i++) {
            tailn[i] = num[pos + 1 + i];
        }
        Arrays.sort(tailn);
        
        for(int i = pos + 1; i < num.length; i++) {
            num[i] = tailn[i - pos - 1];
        }
        
        long res = Long.parseLong(new String(num));
        return res > Integer.MAX_VALUE ? - 1 : (int) res;
    }
}
