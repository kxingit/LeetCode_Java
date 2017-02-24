/*
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 10:11 - 10:13
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, res = 0;
        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                j++; i++;
                res++;
            } else {
                j++;
            }
        }
        return res;
    }
}
// v2
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 10:11 - 10:13
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
