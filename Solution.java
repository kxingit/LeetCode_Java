import java.util.Scanner;

public class Solution {

    public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        int step = nRows * 2 - 2, len = s.length();
        String ret = "";
        // first row
        for (int i = 0; i < len; i += step)
            ret += s.charAt(i);
        for (int i = 1; i < nRows - 1; i++) {
            for (int j = i; j < len; j += step) {
                ret += s.charAt(j);
                if (j + (step - i * 2) < len)
                    ret += s.charAt(j + (step - i * 2));
            }
        }
        // last row
        for (int i = nRows - 1; i < len; i += step)
            ret += s.charAt(i);
        return ret;
    }

    // debug
    public static void main(String[] args) {
        Solution solution = new Solution();
		String input = "0123456789\n";
		System.out.print(input);
		System.out.print(solution.convert(input, 3));
        System.out.println("\nThe end");
    }
}
