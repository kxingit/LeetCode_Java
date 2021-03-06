/*
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 */

// Gives only one solution
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // 1:02
        Stack<Integer> stack = new Stack();
        List<Integer> list = new ArrayList(); // to be removed
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '(' && c != ')') continue;
            if(c == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    list.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            list.add(0, stack.pop());
        }
        System.out.print(list.toString());
        StringBuffer sb = new StringBuffer();
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(j == -1) {
                sb.append(s.charAt(i));
            } else if(i == list.get(j)) {
                j--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        List<String> res = new ArrayList();
        res.add(sb.toString());
        return res;
    }
}

// v2: TLE: 72 / 125 test cases passed.
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // 1:50 - 2:19
        String solution = new String();
        List<String> res = new ArrayList();
        dfs(s, 0, 0, solution, res);
        int maxlen = 0;
        for(int i = 0; i < res.size(); i++) {
            maxlen = Math.max(maxlen, res.get(i).length());
        }
        Set<String> set = new HashSet();
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i).length() == maxlen) {
                set.add(res.get(i));
            }
        }
        List<String> result = new ArrayList();
        for(String e : set) {
            result.add(e);
        }
        return result;
    }
    private void dfs(String s, int start, int netleft, String solution, List res) {
        if(start == s.length() && netleft == 0) res.add(solution);
        for(int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '(' && c != ')') dfs(s, i + 1, netleft, solution + c, res);
            if(c == '(') {
                dfs(s, i + 1, netleft + 1, solution + c, res);
                dfs(s, i + 1, netleft, solution, res);
            } 
            if(c == ')') {
                if(netleft == 0) {
                    dfs(s, i + 1, netleft, solution, res);
                } else {
                    dfs(s, i + 1, netleft - 1, solution + c, res);
                    dfs(s, i + 1, netleft, solution, res);
                }
            }
        }
    }
}

// v3: TLE: 96 / 125 test cases passed.
public class Solution {
    int len = 0;
    public List<String> removeInvalidParentheses(String s) {
        // 1:50 - 2:19
        Stack<Integer> stack = new Stack();
        List<Integer> list = new ArrayList();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '(' && c != ')') {
                len++;
            } else if(c == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    list.add(i);
                } else {
                    stack.pop();
                    len += 2;
                }
            }
        }
        String solution = new String();
        List<String> res = new ArrayList();
        dfs(s, 0, 0, solution, res);
        return new ArrayList<String>(new LinkedHashSet<String>(res));
    }
    private void dfs(String s, int start, int netleft, String solution, List res) {
        if(start == s.length() && netleft == 0 && solution.length() == len) res.add(solution);
        for(int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '(' && c != ')') dfs(s, i + 1, netleft, solution + c, res);
            if(c == '(') {
                dfs(s, i + 1, netleft + 1, solution + c, res);
                dfs(s, i + 1, netleft, solution, res);
            } 
            if(c == ')') {
                if(netleft == 0) {
                    dfs(s, i + 1, netleft, solution, res);
                } else {
                    dfs(s, i + 1, netleft - 1, solution + c, res);
                    dfs(s, i + 1, netleft, solution, res);
                }
            }
        }
    }
}

// v3
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        int l = 0, r = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') l++;
            if(s.charAt(i) == ')') {
                if(l != 0) l--;
                else r++;
            }
        }
        dfs(res, s, 0, l, r, 0, new StringBuilder());
        return new ArrayList<String>(res);  
    }

    public void dfs(Set<String> res, String s, int pos, int l, int r, int open, StringBuilder sb) {
        if(pos == s.length() && l == 0 && r == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if(pos == s.length() || l < 0 || r < 0 || open < 0) return;

        char c = s.charAt(pos);
        int len = sb.length();

        if(c == '(') {
            dfs(res, s, pos + 1, l - 1, r, open, sb);
            dfs(res, s, pos + 1, l, r, open + 1, sb.append(c)); 

        } else if(c == ')') {
            dfs(res, s, pos + 1, l, r - 1, open, sb);
            dfs(res, s, pos + 1, l, r, open - 1, sb.append(c));

        } else {
            dfs(res, s, pos + 1, l, r, open, sb.append(c)); 
        }

        sb.setLength(len);
    }
}

// v4
// TLE: 96 / 125 test cases passed.
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // 9:35 - 9:49 - 10:01
        List<String> res = new ArrayList();
        StringBuffer solution = new StringBuffer();
        
        dfs(s, 0, 0, solution, res);
        
        if(res.size() == 0) res.add("");
        
        return res.stream().distinct().collect(Collectors.toList());
        
    }
    
    public void dfs(String s, int start, int netleft, StringBuffer solution, List<String> res) {
        if(start == s.length()) {
            if(netleft != 0) return;
            if(res.size() == 0 || solution.length() == res.get(0).length()) {
                res.add(solution.toString());
            }
            if(res.get(0).length() < solution.length()) {
                res.clear();
                res.add(solution.toString());
            }
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '(' && c != ')') {
                solution.append(c);
                // continue;
                dfs(s, i + 1, netleft, solution, res);
                solution.setLength(solution.length() - 1);
            } else if(c == '(') {
                solution.append(c);
                dfs(s, i + 1, netleft + 1, solution, res);
                solution.setLength(solution.length() - 1);
                
                dfs(s, i + 1, netleft, solution, res);
            } else { // ')'
                if(netleft <= 0) {
                    dfs(s, i + 1, netleft, solution, res);
                } else {
                    solution.append(c);
                    dfs(s, i + 1, netleft - 1, solution, res);
                     solution.setLength(solution.length() - 1);
                }
            }
        }
    }
}


// v5: attempt to optimize
// 86 / 125 test cases passed
public class Solution {
    int len = 0;
    public List<String> removeInvalidParentheses(String s) {
        // 9:35 - 9:49 - 10:01 - 10:19
        int npairs = 0;
        int l = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                l++;
            } else if(c == ')') {
                if(l == 0) {
                    continue;
                } else {
                    l--;
                    npairs++;
                    len += 2;
                }
            } else {
                len++;
            }
        }
        
        Set<String> res = new HashSet();
        StringBuffer solution = new StringBuffer();
        
        dfs(s, 0, npairs, npairs, solution, res);
        
        if(res.size() == 0) res.add("");
        
        return new ArrayList<String>(res);
        
    }
    
    public void dfs(String s, int start, int nleft, int nright, StringBuffer solution, Set<String> res) {
        if(nleft > nright) return;
        if(nleft < 0 || nright < 0) return;
        if(start == s.length()) {
            if(solution.length() < len) return;
            if(nleft != 0 || nright != 0) return;
            
            res.add(solution.toString());
            
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '(' && c != ')') {
                solution.append(c);
                // continue;
                dfs(s, i + 1, nleft, nright, solution, res);
                solution.setLength(solution.length() - 1);
            } else if(c == '(') {
                solution.append(c);
                dfs(s, i + 1, nleft - 1, nright, solution, res);
                solution.setLength(solution.length() - 1);
                
                dfs(s, i + 1, nleft, nright, solution, res);
            } else { // ')'
                dfs(s, i + 1, nleft, nright, solution, res);
 
                solution.append(c);
                dfs(s, i + 1, nleft, nright - 1, solution, res);
                solution.setLength(solution.length() - 1);
            }
        }
    }
}

// v6: key: no for loop
public class Solution {
    int len = 0;
    public List<String> removeInvalidParentheses(String s) {
        // 10:19 - 10:29
        int npairs = 0;
        int l = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                l++;
            } else if(c == ')') {
                if(l == 0) {
                    continue;
                } else {
                    l--;
                    npairs++;
                    len += 2;
                }
            } else {
                len++;
            }
        }
       
        Set<String> res = new HashSet();
        StringBuffer solution = new StringBuffer();
       
        dfs(s, 0, npairs, npairs, solution, res);
       
        if(res.size() == 0) res.add("");
       
        return new ArrayList<String>(res);
       
    }
   
    public void dfs(String s, int start, int nleft, int nright, StringBuffer solution, Set<String> res) {
        if(nleft > nright) return;
        if(nleft < 0 || nright < 0) return;
        if(start == s.length()) {
            if(solution.length() < len) return;
            if(nleft != 0 || nright != 0) return;
           
            res.add(solution.toString());
           
            return;
        }
       
        int solutionLen = solution.length();
        int i = start;
        // for(int i = start; i < s.length(); i++) { // do not need the loop, cause there is select/no-select in dfs'
            char c = s.charAt(i);
            if(c != '(' && c != ')') {
                dfs(s, i + 1, nleft, nright, solution.append(c), res);
            } else if(c == '(') {
                dfs(s, i + 1, nleft, nright, solution, res);
                dfs(s, i + 1, nleft - 1, nright, solution.append(c), res);
            } else { // ')'
                dfs(s, i + 1, nleft, nright, solution, res);
                dfs(s, i + 1, nleft, nright - 1, solution.append(c), res);
            }
        // }
        solution.setLength(solutionLen);
    }
}

// v7
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // 11:39 - 11:54
        List<String> res = new ArrayList();
        StringBuffer solution = new StringBuffer();
        
        dfs(s, 0, 0, solution, res);
        
        return new ArrayList(new HashSet(res));
    }
    
    public void dfs(String s, int pos, int netleft, StringBuffer solution, List<String> res) {
        if(netleft < 0) return;
        if((res.size() == 0 || solution.length() == res.get(0).length()) && netleft == 0) {
            res.add(solution.toString());
        }
        if(res.size() > 0 && solution.length() > res.get(0).length() && netleft == 0) {
            res.clear();
            res.add(solution.toString());
        }
        
        if(pos == s.length()) return;
        
        char c = s.charAt(pos);
        int solutionLen = solution.length();
        if(c != '(' && c != ')') {
            dfs(s, pos + 1, netleft, solution.append(c), res);
        }
        if(c == '(') {
            dfs(s, pos + 1, netleft, solution, res);
            dfs(s, pos + 1, netleft + 1, solution.append(c), res);
        }
        if(c == ')') {
            dfs(s, pos + 1, netleft, solution, res);
            dfs(s, pos + 1, netleft - 1, solution.append(c), res);
        }
        solution.setLength(solutionLen);
    }
}
