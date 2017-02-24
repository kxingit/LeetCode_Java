/*
 * For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:
 *
 * 1. The area of the rectangular web page you designed must equal to the given target area.
 *
 * 2. The width W should not be larger than the length L, which means L >= W.
 *
 * 3. The difference between length L and width W should be as small as possible.
 */
public class Solution {
    public int[] constructRectangle(int area) {
        // 12:09 - 12:14
        int w = 1, l = 0;
        while(w <= area / w) {
            if(area % w == 0) l = area / w;
            w++;
        }
        w = area / l;
        int[] res = new int[2];
        res[0] = l; res[1] = w;
        return res;
    }
}
