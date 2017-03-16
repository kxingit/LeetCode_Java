/* Suppose we abstract our file system by a string in the following manner:
 *
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 *
 * dir
 *     subdir1
 *         subdir2
 *                 file.ext
 */
public class Solution {
    public int lengthLongestPath(String input) {
        // 3:35
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.contains(".")) {
                res = Math.max(res, m.get(level) + len);
            } else {
                m.put(level + 1, m.get(level) + len + 1);
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public int lengthLongestPath(String input) {
        // 3:43 - 3:48
        HashMap<Integer, Integer> map = new HashMap();
        int res = 0;
        map.put(0, 0);
        String[] strings = input.split("\n");
        for(String s: strings) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.length() - level;
            if(s.contains(".")) {
                res = Math.max(res, map.get(level) + len);
            } else {
                map.put(level + 1, map.get(level) + len + 1); // '/'
            }
        }
        return res;
    }
}
