/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public int romanToInt(String s) {
        // 1:35 - 1:40
        int res = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(getTwoCharValue(s, i) != -1) {
                res += getTwoCharValue(s, i++);
            } else {
                res += getValue(s, i);
            }
        }
        return res;
    }
    
    public int getTwoCharValue(String s, int i) {
        if(i + 1 >= s.length()) return -1;
        String sub = s.substring(i, i + 2);
        if(sub.equals("IV")) return 4;
        if(sub.equals("IX")) return 9;
        if(sub.equals("XL")) return 40;
        if(sub.equals("XC")) return 90;
        if(sub.equals("CD")) return 400;
        if(sub.equals("CM")) return 900;
        return -1;
    }
    
    public int getValue(String s, int i) {
        String sub = s.substring(i, i + 1);
        if(sub.equals("I")) return 1;
        if(sub.equals("V")) return 5;
        if(sub.equals("X")) return 10;
        if(sub.equals("L")) return 50;
        if(sub.equals("C")) return 100;
        if(sub.equals("D")) return 500;
        if(sub.equals("M")) return 1000;
        return -1;
    }
}

// v2
public class Solution {
    public int romanToInt(String s) {
        // 1:40 - 1:49
        int res = 0;
        int n = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        for(int i = 0; i < n; i++) {
            if(i + 1 < n && map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}
