/*
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.*/
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        // 6:48 - 6:59
        String[] aarr = a.split("\\+");
        String[] barr = b.split("\\+");
        int a0 = Integer.parseInt(aarr[0]);
        int a1 = Integer.parseInt(aarr[1].substring(0, aarr[1].length() - 1));
        int b0 = Integer.parseInt(barr[0]);
        int b1 = Integer.parseInt(barr[1].substring(0, barr[1].length() - 1));
        
        int c0 = a0 * b0 - a1 * b1;
        int c1 = a0 * b1 + a1 * b0;
        
        return c0 + "+" + c1 + "i";
    }
}
