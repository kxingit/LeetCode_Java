/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        // 11:10 - 11:16
        int i = 0, j = num.length() - 1;
        while(i < j) {
            if(!isStrob(num.charAt(i), num.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        if(i != j) {
            return true;
        } else {
            char c = num.charAt(i);
            return c == '0' || c == '1' || c == '8';
        }
        
    }
    
    public boolean isStrob(char a, char b) {
        if((a == '0' && b == '0') 
            || (a == '6' && b == '9')
            || (a == '1' && b == '1')
            || (a == '9' && b == '6')
            || (a == '8' && b == '8')
        ) {
            return true;
        }
        return false;
    }
}
