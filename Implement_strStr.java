/*
 *  Implement strStr().
 *
 *  Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
 */
public class Solution {
  public int strStr(String s, String t) {
	int n = s.length(), m = t.length();
	if(m == 0) return 0;
	for(int i = 0; i < n; i++) {
	  if(i + m > n) return -1;
	  for(int j = 0; j < m; j++) {
		if(s.charAt(i + j) != t.charAt(j)) break;
		if(j == m - 1) return i;
	  }
	}
	return -1;
  }
}

// v2
public class Solution {
  public int strStr(String s, String t) {
	int n = s.length(), m = t.length();
	if(m == 0) return 0;
	for(int i = 0; i < n; i++) {
	  if(i + m > n) return -1;
	  for(int j = 0; j < m; j++) {
		if(s.charAt(i + j) != t.charAt(j)) {
		  break;
		}
		if(j == m - 1) {
		  return i;
		}
	  }
	}
	return -1;
  }
}


// v3
public class Solution {
  public int strStr(String s, String t) {
	if(t.length() == 0) return 0;
	for(int i = 0; i < s.length(); i++) {
	  if(i + t.length() > s.length()) {
		return -1;
	  }
	  for(int j = 0; j < t.length(); j++) {
		if(s.charAt(i + j) != t.charAt(j)) {
		  break;
		}
		if(j == t.length() - 1) {
		  return i;
		}
	  }
	}
	return -1;
  }
}
