/*
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        // 10:04 - 10:16 - 10:31
        List<String> res = new ArrayList();
        String solution = "";
        System.out.print(solution.length());
        dfs(num, target, 0, 0, 0, solution, res);
        return res;
    }
    
    private void dfs(String num, int target, int start, long pre, long currres, String solution, List res) {
        if(start == num.length() && currres == target) {
            res.add(solution);
        }
        
        for(int i = start; i < num.length(); i++) {
            String substring = num.substring(start, i + 1);
            if(isValidNum(substring) == false) {
                continue;
            }
            long next = toNum(substring);
            if(solution.length() == 0) { 
                dfs(num, target, i + 1, next, next, "" + next, res);
            } else {
                dfs(num, target, i + 1, next, currres + next, solution + "+" + next, res);
                dfs(num, target, i + 1, -next, currres - next, solution + "-" + next, res);
                dfs(num, target, i + 1, next * pre, currres - pre + pre * next, solution + "*" + next, res);
            }
        }
    }
    
    private boolean isValidNum(String s) {
        if(s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        return true;
    }
    
    private long toNum(String s) {
        long res = 0;
        for(int i = 0; i < s.length(); i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res;
    }
}

// v2
public class Solution {
    int target, n;
    
    public List<String> addOperators(String num, int target) {
        // 2:03 - 2:14
        this.target = target;
        this.n = num.length();
        List<String> res = new ArrayList();
        String solution = "";
        dfs(num, 0, 0, 0, solution, res);
        return res;
    }
    
    public void dfs(String num, int pos, long prev, long sum, String solution, List<String> res) {
        if(solution.length() > 0 && (solution.charAt(0) == '-' || solution.charAt(0) == '*')) return;
        if(pos == n) {
            if(sum == target) {
                res.add(solution.substring(1, solution.length()));
            }
            return;
        }
        
        for(int i = pos + 1; i <= n; i++) {
            String currStr = num.substring(pos, i);
            // System.out.print(currStr + " ");
            if(!isValidNum(currStr)) continue;
            long curr = Long.parseLong(currStr);
            dfs(num, i, curr, sum + curr, solution + "+" + curr, res);
            dfs(num, i, -curr, sum - curr, solution + "-" + curr, res);
            dfs(num, i, curr * prev, sum - prev + curr * prev, solution + "*" + curr, res);
        }
    }
    
    public boolean isValidNum(String s) {
        if(s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        
        return true;
    }
}
