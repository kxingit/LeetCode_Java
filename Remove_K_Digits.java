/*
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        // 10:40 - 10:46 - 10:58 - 11:16
        int start = 0, end = k;
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < num.length() - k; i++) {
            int idx = findMinIndex(num, start, end);
            res.append(num.charAt(idx));
            start = Math.min(idx + 1, num.length() - 1);
            end = Math.min(end + 1, num.length() - 1);
        }
        while(res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        if(res.length() == 0) return "0";
        return res.toString();
    }
    private int findMinIndex(String num, int start, int end) {
        int min = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++) {
            min = Math.min(min, num.charAt(i) - '0');
        }
        for(int i = start; i <= end; i++) {
            if(num.charAt(i) - '0' == min) return i;
        }
        return num.length() - 1;
    }
}

// v2
public class Solution {
    public String removeKdigits(String num, int k) {
        char[] sc = num.toCharArray();
        if(k >= sc.length) return "0";
        StringBuilder sb = new StringBuilder();
        // try to maintaing an increasing num, delete at most k times
        for(char c: sc){
          while(sb.length() > 0 && sb.charAt(sb.length() - 1) > c && k > 0){
            sb.deleteCharAt(sb.length() - 1);
            k--;
          }
          sb.append(c);
        }
    
        // remove leading '0'
        while(sb.length() > 1 && sb.charAt(0) == '0'){
          sb.deleteCharAt(0);    
        }
        
        // delete remaining numbers from end
        for(int i=0; i < k; i++){
          sb.deleteCharAt(sb.length() - 1);    
        }
        return sb.toString();
    }
}

// v3
public class Solution {
    public String removeKdigits(String num, int k) {
        // 11:35 - 11:40 - 11:46
        char[] nums = num.toCharArray();
        int n = nums.length;
        int len = num.length() - k;
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < n; i++) {
            while(res.length() > 0 && res.charAt(res.length() - 1) > nums[i] && k > 0) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            res.append(nums[i]);
        }
        while(res.length() > len) {
            res.deleteCharAt(res.length() - 1);
        }
        while(res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        if(res.length() == 0) return "0";
        return res.toString();
    }
}
