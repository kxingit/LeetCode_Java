/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class Solution {
    HashMap<Character, String> map = new HashMap();
    public List<String> letterCombinations(String digits) {
        // 1:39 - 1:45 - 1:53 bugs: char not int, return 
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> res = new ArrayList();
        if(digits.length() == 0) {
            return res;
        }
        StringBuffer solution = new StringBuffer();
        dfs(digits, 0, solution, res);
        
        return res;
    }
    
    public void dfs(String digits, int pos, StringBuffer solution, List<String> res) {
        if(pos == digits.length()) {
            res.add(solution.toString());
            return;
        }
        
        char c = digits.charAt(pos);
        for(int i = 0; i < map.get(c).length(); i++) {
            solution.append(map.get(c).charAt(i));
            dfs(digits, pos + 1, solution, res);
            solution.setLength(solution.length() - 1);
        }
    }
}

// v2
public class Solution {
    String[] keyboard = new String[10];
    public List<String> letterCombinations(String digits) {
        // 9:43 - 9:53
        keyboard[2] = "abc";
        keyboard[3] = "def";
        keyboard[4] = "ghi";
        keyboard[5] = "jkl";
        keyboard[6] = "mno";
        keyboard[7] = "pqrs";
        keyboard[8] = "tuv";
        keyboard[9] = "wxyz";
        
        List<String> res = new ArrayList();
        if(digits.length() == 0) return res;
        StringBuffer solution = new StringBuffer();
        dfs(digits, 0, solution, res);
        
        return res;
    }
    
    public void dfs(String digits, int pos, StringBuffer solution, List<String> res) {
        if(pos == digits.length()) {
            res.add(solution.toString());
            return;
        }
        int num = digits.charAt(pos) - '0';
        String letters = keyboard[num];
        for(int i = 0; i < letters.length(); i++) {
            solution.append(letters.charAt(i));
            dfs(digits, pos + 1, solution, res);
            solution.setLength(solution.length() - 1);
        }
    }
}
