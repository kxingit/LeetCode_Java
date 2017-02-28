/*
   Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 */
public class Solution {
  public int maxProduct(String[] words) {
    // 10:20 - 10:27
    int n = words.length;
    int res = 0;
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
	if(isValid(words[i], words[j])) {
	  res = Math.max(res, words[i].length() * words[j].length());
	}
      }
    }
    return res;
  }
  private boolean isValid(String s1, String s2) {
    Set<Character> set = new HashSet();
    for(int i = 0; i < s1.length(); i++) {
      set.add(s1.charAt(i));
    }
    for(int i = 0; i < s2.length(); i++) {
      if(set.contains(s2.charAt(i))) {
	return false;
      }
    }
    return true;
  }
}
// v2
public class Solution {
  public int maxProduct(String[] words) {
    final int n = words.length;
    final boolean[][] hashset = new boolean[n][ALPHABET_SIZE];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < words[i].length(); ++j) {
	hashset[i][words[i].charAt(j) - 'a'] = true;
      }
    }

    int result = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
	boolean hasCommon = false;
	for (int k = 0; k < ALPHABET_SIZE; ++k) {
	  if (hashset[i][k] && hashset[j][k]) {
	    hasCommon = true;
	    break;
	  }
	}
	int tmp = words[i].length() * words[j].length();
	if (!hasCommon && tmp > result) {
	  result = tmp;
	}
      }
    }
    return result;
  }
  private static final int ALPHABET_SIZE = 26;
}
