/*
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.
 */
// LTE:  31 / 51 test cases passed.
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // 1:30 - 1:44 - 1:50
        int res = 0;
        int i = 0, j = 0;
        boolean toEnd = false;
        while(true) {
            for(int iword = 0; iword < sentence.length; iword++) {
                String word = sentence[iword];
                int len = word.length();
                if(j + len <= cols) {
                    j = j + len;
                    j++;
                    if(j >= cols) {
                        i++;
                        j = 0;
                    }
                } else {
                    i++;
                    j = 0;
                    iword--;
                }
                if(i == rows) {
                    toEnd = true;
                    if(iword == sentence.length - 1) res++;
                    break;
                }
            }
            if(toEnd) break;
            res++;
        }
        return res;
    }
}

// v2
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuffer sb = new StringBuffer();
        for (String word : sentence) sb.append(word + " ");
        String all = sb.toString();
        
        int start = 0, len = all.length();
        for (int i = 0; i < rows; ++i) {
            start += cols;
            if (all.charAt(start % len) == ' ') {
                ++start;
            } else {
                while (start > 0 && all.charAt((start - 1) % len) != ' ') {
                    --start;
                }
            }
        }
        return start / len;
    }
}
