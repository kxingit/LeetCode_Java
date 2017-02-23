/*
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        // 5:39 - 5: 42
        int n = word.length();
        if(n == 0) return true;
        if(!Character.isUpperCase(word.charAt(0))) {
            for(int i = 1; i < n; i++) {
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else { // first upper
            for(int i = 1; i < n - 1; i++) {
                if(Character.isUpperCase(word.charAt(i)) != Character.isUpperCase(word.charAt(i + 1))) {
                    return false;
                }
            }
            return true;
        }
    }
}
