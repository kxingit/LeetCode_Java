/*
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 */
public class Solution {
    public List<String> generatePalindromes(String s) {
        // 1:38 - 1:54 - 2:25 // key: remove duplicates
        char[] arr =  s.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        for(char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        char midc = 'a'; int midcount = 0;
        for(char c : map.keySet()) {
            if(map.get(c) % 2 == 1) {
                midcount++;
                midc = c;
            }
        }
        
        List<String> res = new ArrayList();
        if(midcount > 1) return res;
        
        StringBuffer sb = new StringBuffer();
        for(char c : map.keySet()) {
            int count = map.get(c);
            for(int i = 0; i < count / 2; i++) {
                sb.append(c);
            }
        }
        System.out.print(sb.toString() + " ");
        
        char[] list = sb.toString().toCharArray();
        Arrays.sort(list);
        StringBuffer solution = new StringBuffer();
        boolean[] visited = new boolean[list.length];
        dfs(list, visited, solution, res);
        
        return buildPal(midc, midcount, res);
    }
    
    public void dfs(char[] list, boolean[] visited, StringBuffer solution, List<String> res) {
        if(solution.length() == list.length) {
            res.add(solution.toString());
            return;
        }
        for(int i = 0; i < list.length; i++) {
            if(visited[i]) continue;
            if(i > 0 && list[i] == list[i - 1] && visited[i - 1] == false) continue; // key
            char c = list[i];
            visited[i] = true;
            solution.append(c);
            dfs(list, visited, solution, res);
            solution.setLength(solution.length() - 1);
            visited[i] = false;
        }
    }
    
    public List<String> buildPal(char midc, int midcount, List<String> input) {
        List<String> res = new ArrayList();
        
        for(String s : input) {
            StringBuffer sb = new StringBuffer();
            if(midcount == 1) sb.append(midc);
            StringBuffer tmpsb = new StringBuffer(s);
            sb.append(tmpsb);
            sb.insert(0, tmpsb.reverse());
            res.add(sb.toString());
        }
        
        return res;
    }
}
