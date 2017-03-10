/*
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 */
// TLE: 30 / 134 test cases passed.
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        // 4:00 - 4:11
        int n = words.length;
        List<List<Integer>> result = new ArrayList();
        List<Integer> solution = new ArrayList();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                String ns = words[i] + words[j];
                System.out.print(ns + " ");
                if(isPal(ns)) {
                    solution.clear();
                    solution.add(i);
                    solution.add(j);
                    result.add(new ArrayList(solution));
                    // result.add(solution);
                }
            }
        }
        return result;
    }
    private boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
