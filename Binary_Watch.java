/*
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 *
 * Each LED represents a zero or one, with the least significant bit on the right.
 *
 * ￼
 * For example, the above binary watch reads "3:25".
 *
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 */
public class Solution {
    public int int2bit(int x) {
        int num = 0, temp = x;
        while(temp != 0) {
            if((temp & 0x01) == 0x01) {
                num++;
            }
            temp >>= 1;
        }
        return num;
    }
 
    public List<String> readBinaryWatch(int num) {
        if(num < 0 || num > 10) return null;
        List<String> watches = new ArrayList<String>();
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 60; j++) {
                if(int2bit(i) + int2bit(j) == num) {
                    if(j < 10)
                        watches.add(i + ":0" + j);
                    else
                        watches.add(i + ":" + j);
                }
            }
        }
        return watches;
    }
}

// v2
public class Solution {
    public List<String> readBinaryWatch(int num) {
        // 3:24 - 3:28
        List<String> res = new ArrayList();
        for(int h = 0; h < 12; h++) {
            for(int m = 0; m < 60; m++) {
                if(count1(h) + count1(m) == num) {
                    String s = Integer.toString(h) + ":";
                    if(m < 10) {
                        s += "0";
                    }
                    s += Integer.toString(m);
                    res.add(s);
                }
            }
        }
        return res;
    }
    private int count1(int n) {
        int res = 0;
        while(n > 0) {
            if(n % 2 == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }
}
